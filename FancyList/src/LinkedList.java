import java.util.ArrayList;


public class LinkedList<T> {

	int nItems;
	Link first;
	Link last;
	
	public LinkedList() {
		nItems = 0;
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public int size() {
		return nItems;
	}
	
	/*This method inserts an item to the end of the list*/
	public void add(T in) {
		
		Link insert = new Link(in);
		
		//if list is empty
		if(isEmpty()) {
			
			//mark new link as the first 
			first = insert;
			first.setIndex(nItems++);
			//and the last
			last = insert;
			
		} else {
			
			//mark the previous last to the new link
			last.next = insert;
			last.next.previous = last;
			//mark the new link as the last
			last = insert;
			//set it's index
			last.setIndex(nItems++);
			
		}
		
	}
	
	/*This method returns an element at the parameter index*/
	public T get(int a) {
		
		if(isEmpty())
			return null;
		
		//if index is out of bounds
		if(a >= this.size())
			return null;
		
		Link current = first;
		//go through the list to the ath link
		for(int i = 0; i < a; i++) {
			
			current = current.next;
			
		}
		
		return (T)current.data;
		
	}
	
	/*This method removes the first occurence of the
	 *  parameter element from the list*/
	public T remove(T a) {
		
		if(isEmpty())
			return null;
		
		//start at first link
		Link current = first;
		while(current != null) {
			
			if(current.data == a) {
				
				//if first element
				if(first.data == a) {
					
					//set new first
					first = current.next;
					nItems--; //record removal
					
					Link cur = first; //start at first
					//update all indexes
					for(int i = 0; i < this.size(); i++) {
						
						cur.setIndex(i);
						cur = cur.next;
						
					}
					
					return (T) current.data;
					
				}else if(last.data == a) {//if last 
					
					//set the prevoius to the last and point it's next to null
					last.previous.next = null;
					last = last.previous;
					nItems--; //record removal
					
					return (T)current.data;
					
				}
				else {
				
					//set previous link's next to current's next
					current.previous.next = current.next;
					//set the next link's previous to currents previous
					current.next.previous = current.previous;
					nItems--; //record removal
					//change all indexes after the previous
					Link cur = current.previous.next;
					for(int i = current.getIndex(); i < this.size(); i++) {
						cur.setIndex(i); //set new index
						cur = cur.next; //move to next link
					}
					
					return (T)current.data;
				
				}
			}
				
			current = current.next;
			
		}
		
		return null;//not found
		
	}
	
	/*This method removes the link at the parameter index*/
	public T remove(int a) {
		
		if(isEmpty())
			return null;
		
		//if index is out of bounds
		if(a >= this.size())
			return null;
		
		//if first
		else if(a == 0) {
			
			//set new first
			Link out = first;
			first = first.next;
			nItems--; //record removal
			
			Link cur = first; //start at first
			//update all indexes
			for(int i = 0; i < this.size(); i++) {
				
				cur.setIndex(i);
				cur = cur.next;
				
			}
			
			return (T)out.data;
			
		}//if last
		else if (a == this.size()-1) {
			
			//set the prevoius to the last and point it's next to null
			Link out = last;
			last.previous.next = null;
			last = last.previous;
			nItems--; //record removal
			
			return (T)out.data;
			
		}
		else {

			Link current = first;
			//go through the list to the ath link
			for(int i = 0; i < a; i++) {
				
				current = current.next;
				
			}
			
			//remove the link
			current.previous.next = current.next;
			current.next.previous = current.previous;
			nItems--;
			//update the indexes
			Link cur = current.next;
			for(int i = current.getIndex(); i < this.size(); i++) {
				
				cur.setIndex(i);
				cur = cur.next;
				
			}
			return (T)current.data;
	
		}
		
		
		
	}
	
	/*This method returns the index of the first occurence of the parameter Object*/
	public int indexOf(T a) {
		
		if(isEmpty())
			return -1;
		
		//start at first link
		Link current = first;
		while(current != null) {
			
			if(current.data == a)
				return current.getIndex();
			
			current = current.next; 
			
		}
		return -1;//not found 
		
	}
	
	public void print() {
		
		if(isEmpty())
			System.out.println("The List is empty.");
		else {
			
			Link current = first;
			while(current != null) {
				System.out.print(current.getIndex()+ " - " + current.data + ", ");
				current = current.next;
			}
			System.out.println();
			
		}
		
	}
	
	/*This method returns a boolean depending on whether the parameter is
	 * found in the list 
	 */
	public boolean contains(T a) {
		
		if(isEmpty())
			return false;
		
		//start at first
		Link current = first; 
		while(current != null) {
			
			if(current.data == a)
				return true;
			
			current = current.next;
			
		}
		
		return false; 
		
	}
	
	/*This method replaces the first occurrence of the first parameter with the 
	 * second parameter
	 */
	public boolean replace(T a, T b) {
		
		if(isEmpty())
			return false;
		
		//start at the start
		Link current = first;
		while(current != null) {
			
			if(current.data == a) {
				
				current.data = b;
				return true;
				
			}
			
			current = current.next;
			
			
		}
		
		return false;
	}
	
	/*This method empties the list*/
	public void empty() {
		
		first = null;
		last = null;
		nItems = 0;
		
	}
	
	public static void main(String args[]) {
		
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		list.print();

		list.remove(1);
		list.remove("three");
		list.print();
		
		System.out.println(list.replace("four", "testing"));
		list.print();
		
		System.out.println(list.indexOf("testing"));
		
		System.out.println(list.contains("one"));
		
		list.empty();
		
		list.print();
		
	}
		
}
