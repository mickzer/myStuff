
public class Link {

	 public String data; // data item 
     public Link next; // next link in list 
     
     public Link(String data){ // constructor 
         this.data = data; // initialize data 
     } 
     
     public void displayLink() {
      
          System.out.print(this.data+", ");//print out data
          
      }

	
}
