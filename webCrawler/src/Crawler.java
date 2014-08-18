import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Crawler {

	public static File[] allFiles;
	public static ArrayList<File> webPages;
	public static Graph web;
	public static double dampingFactor = 0.5; //page Rank
	/*This method gets all the .html files in the web folder and puts them in the static
	 * webPages variable*/
	public static void getFiles(String directory) {
		
		File dir = new File(directory);
		
		webPages = new ArrayList<File>(); 
		//list all files
		allFiles = dir.listFiles();
		//ensure it is a valid directory by checking nullity
		if(allFiles != null) {
			
			//go through each file in the directory
			for(File webPage : allFiles) {

				//check for html file
				String fileName = webPage.getName();
				if(fileName.substring(fileName.lastIndexOf('.')+1, fileName.length()).equals("html")) {
					
					webPages.add(webPage);
					
				}
			}
			
		}
		else
			System.out.println("Invalid Directory");
		
	}
	
	/*This method initalises a graph of the correct size, and creates a webPage object of each web page*/
	public static void initaliseGraphFromFiles() {
		
		/*Treats the web as a graph, with web pages being nodes and links between them being
		 * edges. I'll do it the same.*/
		web = new Graph(webPages.size());
		//Represent each webpage as a node on the graph
		for(File webPage : webPages) {
			
			//create scanner to read through file
			Scanner myScanner = null;
			String contents = "";
			try
			{
			    myScanner = new Scanner(webPage);
			    //read till the end
			    contents = myScanner.useDelimiter("\\Z").next(); 
			}
			catch(FileNotFoundException e) {
				System.out.println("Problem reading file");
			}
			finally
			{
			    if(myScanner != null)
			    {
			        myScanner.close(); 
			    }
			}
			
			//create webPage node and add to graph
			web.add(new WebPage(webPage.getName(), contents));
			
		}
		
	}
	
	public static void crawl() {
		
		//go through each web page and find and record links
		for(WebPage page : web.webPages) {
			
			int lastIndex = 0;
			//search for links
			while(lastIndex != -1) {
				
				//look for next link
				lastIndex = page.content.indexOf("<a", lastIndex);
				if(lastIndex != -1) {
					
					//mark start position of link
					int start = lastIndex+2;
					//to store end of link
					int end = -1;
					//next find the href
					int href = page.content.indexOf("href=\"", start);
					//extract link location
					if(href != -1 ) {
						//get link, starts at href=" + 6 chars forward until the next "
						 end = page.content.indexOf("\"", href+6);
						if(end != -1) {
							//get the link
							String link = page.content.substring(href+6, end);
							//add to the pages list of outLinks
							page.outLinks.add(link);
						}
						else
							System.out.println("There has been a problem1");
					}
					else
						System.out.println("There has been a problem2");
					
					//move the search window forward
					lastIndex += (end-start);
				}
				
			}
		
		}
		
		/*We now have all the out going links from each web page in the directory. We will now
		 * represent these links as unidirectional edges between the webPages on the graph.
		 * We will use our 2 dimensional array as a matrix, and let the value 1 represent a connection*/
		
		/*The indexes in the array will represent the web pages and will correspond to their indexes in
		 * the Graph webPages Array List.*/
		
		//initalise the matrix
		
		//record the unidirectional connections of each webPage
		for(WebPage page : web.webPages) {
			
			//go through each list of outLinks
			for(String outLink : page.outLinks) {

				web.connect(page.getName(), outLink);
				
			}
			
		}
		
		//We now have a graph with each webPage as a Node and our connections noted in the
		//matrix
		
	}
	
	public static void main(String args[]) {
		
		//get all html files in webPages List
		getFiles("web");
		
		//intialise graph from files in web folder
		initaliseGraphFromFiles();
		
		//crawl
		crawl();
		
		//list connections
		System.out.println("Discovered Links:");
		web.listConnections();
		 
		
	}
	
}
