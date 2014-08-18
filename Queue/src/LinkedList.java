
public class LinkedList {

	private Link first; // ref to first link 
    private Link last; //ref to last link

    public LinkedList(){
        first = null; // no links on list yet 
        last=null;
    } 
    
    public boolean isEmpty() {
       return (first == null); //return true if list is empty
     }

     public void add(String data) {
	  
       Link newLink = new Link(data);//create the new link
        if (isEmpty()) //first and last will be the same if there is only 1 link
           first = newLink; 
        else
           last.next = newLink;//set the previous last link to the new one
        last = newLink;//Set the new link as the last
		 
     }

     public String removeHead() {       
	  
       if(isEmpty()) 
           return null; //return null if the list is empty
			
       String temp = first.data; //String to store the item being removed
       if (first==last)
         last = null;//Condition for only one item left in the array
       first = first.next;//Set the first link to the next item
       return temp;//return the removed item
		
     }
     
     public void display() { 
	  
         Link current = first; // start with first link 
         while(current!=null){ 
             current.displayLink(); //print out the link 
             current=current.next; 
             //keep going until you come to the end
         }
		  
     }       

	
}
