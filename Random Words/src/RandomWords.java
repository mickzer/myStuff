import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class RandomWords {

	public static void main(String args[]) throws IOException {
			
			Random rand = new Random();
			String alphabet = "abcdefghijklmopqrstuvwxyz";
			
			//make 1000000 random words of between length 3 and 10
			int c = 0;
			String[] array = new String[1000000];
			for(int i = 0; i < 1000000; i++) {
				
				//get random length
				int length = rand.nextInt(10-3+1)+3;
				String word = "";
				for(int j = 0; j < length; j++) {
					
					word += alphabet.charAt(rand.nextInt(alphabet.length()));
					
				}
				array[c++] = word;
				
			}
			
			//get the dictionary
			String dict = FileReader.readFile("dictionary.txt", Charset.defaultCharset());
			
			String[] dictionary = dict.split("\n");
			//System.out.println(array.length);
			
			//check each word in the dictionary
			ArrayList<String> matches = new ArrayList<String>();
	
			for(String current : array) {
				
				//check the dictionary
				for(String check : dictionary) {
					
					if(current.equalsIgnoreCase(check)) {
						matches.add(current);
						break;
					}
					
				}
				
			}
			
			//print results
			for(String s : matches) {
				
				System.out.println(s);
				
			}
			
			System.out.println(matches.size() + " matches!");
			
			System.out.println("--------------------");
		
		
		
	}
	
}
