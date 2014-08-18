/*Nodes are Vertices. Vertices are connected by edges.*/
public class Node {

	private String label;
	private boolean visited;
	
	public Node(String label) {
		
		this.label = label;
		visited = false;
		
	}
	
	public String getLabel() {
		
		return this.label;
		
	}
	
	public boolean getVisited() {
		
		return this.visited;
		
	}
	
	public void visit() {
		
		this.visited = true;
		
	}
	
}
