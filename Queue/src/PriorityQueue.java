
public class PriorityQueue
{
    
      private int[] array;
      private int size;
      private int nItems;

      public PriorityQueue(int sizein){
        
          size=sizein;
          array=new int[size];
          nItems=0;
          
      }

      public String insert(int in){
                  
          if(isFull()) //check if array is full
            return "\""+in+"\" could not be inserted as the queue is full."; 
            //return false as nothing more can be added
            
          if(isEmpty()){ // if no items, 
             array[0] = in; // insert 
          }else{ // if some items, 
              int count = nItems; // start at end of queue
              //Put new person in the right position
              while(count > 0 && array[count-1] < in) { 
                 array[count] = array[count-1];  
                 count--; 
               } 
              array[count] = in; // insert 
          } 
          //Record insert
          nItems++;   
          
          return "\""+in+"\" was inserted";
          
      }

      public String remove() {
             
             if(isEmpty())//Ensure queue isn't empty
                return "There is nothing to remove. The queue is empty";
             
             //store Person to remove
             int remove=array[0];
             //Record removal
             nItems--;
             
             //shift all remaining items up one
             int count=0;
             while(nItems>0 && count<nItems) {
             
                 array[count]=array[count+1];
                 count++;
                 
             }
             
             return "\""+remove+"\" was removed from the queue.";
      }

      public boolean isFull() {
          
             boolean full=false;
             
             if(nItems==size)  
                full=true;
                
             return full;
             
      }

      public boolean isEmpty() {
          
             boolean empty=false;
             
             if(nItems==0)
                empty=true;
          
             return empty;
      }

      public int getSize(){
          
             return nItems;
             
      }

      public void printout(){
        
        for(int i=0; i<nItems; i++) {
            
            System.out.print(array[i]+", ");
            
        }
       
        System.out.println();
        
      }
      
}
