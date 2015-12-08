import java.awt.Point;
import java.util.*;


public class Flood {
    
	static int[][] picture;
	static boolean[][] processed;
	
	public static void main(String args[]) {
		
		processed = new boolean[10][13];
		
		int[][] p =  {{1,1,1,1,1,1,3,3,3,3,1,1,1},
					  {1,1,1,1,1,1,3,3,3,3,1,1,1},
					  {1,1,1,1,1,1,3,3,3,3,1,1,1},
					  {1,1,1,1,1,4,3,3,3,3,1,1,1},
					  {1,1,1,1,1,4,1,1,4,4,1,1,1},
					  {1,1,1,1,1,4,4,4,4,4,2,2,2},
					  {1,1,1,1,1,1,1,1,4,4,1,1,1},
					  {1,1,1,1,1,1,4,4,4,4,1,1,1},
					  {1,1,1,1,1,1,4,4,4,4,1,1,1},
					  {1,1,1,4,4,4,4,4,4,4,1,1,1}};
		
		picture = p;
		
		for(int i = 0; i < picture.length; i++) {
			
			for(int j = 0; j < picture[i].length; j++) {
				
				System.out.print(picture[i][j] + ", ");
				
			}
			System.out.println();
			
		}
		
		System.out.println('\n');
		
		betterFloodFill(new Point(9,5), 4, 9);
		
		for(int i = 0; i < picture.length; i++) {
			
			for(int j = 0; j < picture[i].length; j++) {
				
				System.out.print(picture[i][j] + ", ");
				
			}
			System.out.println();
		}
		
		
	}
	
	public static void betterFloodFill(Point p, int target, int fill) {
		
		if(target == fill)
			return;
		
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(p);
		
		while(!q.isEmpty()) {
			
			Point n = q.remove();
			
			if(picture[n.x][n.y] == target) {
			
				Point w = new Point(n);
				Point e = new Point(n);
				
				//go as west until a different colour is met
				while(w.y > 0 && picture[w.x][w.y] == target) {
					w.y--;
					
				}
				
				//go east until a different colour is met
				while(e.y < picture[e.x].length && picture[e.x][e.y] == target) {
					e.y++;
				}
				
				Point cur = w;
				
			
				while(cur.y < e.y) {
					
					picture[cur.x][cur.y] = fill;
					//check north
					if(cur.x-1 >= 0 && picture[cur.x-1][cur.y] == target)
						q.add(new Point(cur.x-1, cur.y));
					//check south
					if(cur.x+1 < picture.length && picture[cur.x+1][cur.y] == target)
						q.add(new Point(cur.x+1, cur.y));
					
					cur.y++;
					
				}
				
			}
			
		}
		
	}
	
	public static void floodFill(Point p, int target, int fill) {
		
		if(target == fill)
			return;
		
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(p);
		
		while(!q.isEmpty()) {
			
			Point n = q.remove();
			
			if(picture[n.x][n.y] == target) {
				
				//change fill and mark as processed
				picture[n.x][n.y] = fill;
				processed[n.x][n.y] = true;
				
				//west
				if(n.y-1 >= 0 && !processed[n.x][n.y-1])
						q.add(new Point(n.x, n.y-1));
					
				
				
				//east
				if(n.y+1 < picture[n.x].length && !processed[n.x][n.y+1]) 
						q.add(new Point(n.x, n.y+1));
					
				
				
				//north
				if(n.x-1 >= 0 && !processed[n.x-1][n.y]) 
						q.add(new Point(n.x-1, n.y));
					
				
				
				//south
				if(n.x+1 < picture.length && !processed[n.x+1][n.y]) 
						q.add(new Point(n.x+1, n.y));
					
				
					
				
			}
			
			
		}
		
		
	}
	
}