
public class App {

	public static void main(String args[]) {
		
		//Create a Graph 
		Graph g = new Graph(10);
		
		//Create the nodes
		g.add(new Node("A")); //matrix[0]
		g.add(new Node("B")); //matrix[1]
		g.add(new Node("C")); //matrix[2]
		g.add(new Node("D")); //matrix[3]
		g.add(new Node("E")); //matrix[4]
		g.add(new Node("F")); //matrix[5]
		g.add(new Node("G")); //matrix[6]
		g.add(new Node("H")); //matrix[7]
		g.add(new Node("I")); //matrix[8]
		g.add(new Node("J")); //matrix[9]
		
		//now mark connections in the adjacency matrix
		g.connect("A", "B");
		g.connect("A", "E");
		g.connect("B", "F");
		g.connect("B", "C");
		g.connect("C", "D");
		g.connect("E", "F");
		g.connect("F", "G");
		g.connect("G", "H");
		g.connect("G", "I");
		g.connect("I", "J");
		
		//g.listConnections();
		
		g.depthFirstSearch();
		
	}
	
}
