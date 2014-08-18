import java.util.*;


public class Graph {

	//adjacency matrix to store edges
	public int[][] matrix;
	//vertex matrix
	public ArrayList<Node> nodes;
	
	public Graph(int size) {
		
		nodes = new ArrayList<Node>();
		matrix = new int[size][size];
		
	}
	
	public void add(Node n) {
		
		nodes.add(n);
		
	}
	
	public void connect(String a, String b) {
		
		int aIndex = -1;
		int bIndex = -1;
		
		//go through the list and find the vertices
		for(int i = 0; i < nodes.size(); i++) {
			
			if(nodes.get(i).getLabel() == a)
				aIndex = i;
			
			else if(nodes.get(i).getLabel() == b)
				bIndex = i;
			
		}
		
		//record the connection in the adjacency matrix
		matrix[aIndex][bIndex] = 1;
		matrix[bIndex][aIndex] = 1;
		
	}
	
	//get a nodes index from it's label
	public int getIndex(String label) {
	
		for(int i = 0; i < nodes.size(); i++) {
			
			if(nodes.get(i).getLabel() == label)
				return i;
			
		}
		
		return -1;
	
	}
	
	//print all connections
	public void listConnections() {
		
		for(int i = 0; i < matrix.length; i++) {
			
			for(int j = 0; j < matrix.length; j++) {
				
				if(matrix[i][j] == 1)
					System.out.println(nodes.get(i).getLabel() + " Connected with " + nodes.get(j).getLabel());
				
			}
			
		}
		
	}
	
	//depth first search
	public void depthFirstSearch() {
		
		Stack<Node> s = new Stack<Node>();
		
		int cur = 0;
		boolean found = false;
		
		//start at the start
		s.push(nodes.get(cur));
		nodes.get(cur).visit();
		System.out.print(nodes.get(cur).getLabel() + ",");
		//go the next adjacent unvisited node
		while(!s.empty()) {
			
			for(int i = 0; i < nodes.size(); i++) {
				
				if(matrix[cur][i] == 1 && nodes.get(i).getVisited() == false) {
					
					cur = i; //new current node
					
					s.push(nodes.get(cur));//put on stack
					nodes.get(cur).visit();//visit node
					System.out.print(nodes.get(cur).getLabel() + ",");
					found = true;
					break;
				}
				
			}
			
			//if no neighbours, backtrack
			if(!found) {
				
				//backtrack
				s.pop();
				//get new top index
				if(!s.empty())
					cur = getIndex(s.peek().getLabel());
				
				
			}
			
			//reset found
			found = false;
				
			
		}
		
	}
	
}
