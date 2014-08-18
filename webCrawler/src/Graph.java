import java.util.ArrayList;
import java.util.Stack;

public class Graph {

		//adjacency matrix 
		int[][] matrix;
		//vertex matrix
		ArrayList<WebPage> webPages;
		
		public Graph(int size) {
			
			webPages = new ArrayList<WebPage>();
			matrix = new int[size][size];
			
		}
		
		public void add(WebPage n) {
			
			webPages.add(n);
	
		}
		
		/*This method records a unidirectional connection between two pages from
		 * a to b.*/
		public void connect(String a, String b) {
			
			int aIndex = -1;
			int bIndex = -1;
			
			//go through the list and find the vertices
			for(int i = 0; i < webPages.size(); i++) {
				
				if(webPages.get(i).getName().equals(a))
					aIndex = i;
				
				if(webPages.get(i).getName().equals(b)) 
					bIndex = i;
				
			}
			
			//record the connection in the adjacency matrix
			matrix[aIndex][bIndex] = 1;
			
		}
		
		//get a WebPages index from it's label
		public int getIndex(String label) {
		
			for(int i = 0; i < webPages.size(); i++) {
				
				if(webPages.get(i).getName() == label)
					return i;
				
			}
			
			return -1;
		
		}
		
		//print all connections
		public void listConnections() {
			
			for(int i = 0; i < matrix.length; i++) {
				
				for(int j = 0; j < matrix.length; j++) {
					
					if(matrix[i][j] == 1)
						System.out.println(webPages.get(i).getName() + " has a link to " + webPages.get(j).getName());
					
				}
				
			}
			
		}
		
		public static void main(String args[]) {
			
			Graph g = new Graph(3);
			g.add(new WebPage("a","aC"));
			g.add(new WebPage("b","bC"));
			g.add(new WebPage("c","cC"));
			
			g.connect("a", "b");
			g.listConnections();
			
		}
		
		
	
}
