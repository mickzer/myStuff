public class Queue2 {

      private String[] array;
      private int size;
      private int front;
      private int rear;
      private int nItems;

      public Queue2(int sizein){
    	  
          size=sizein; //get size of array
          array=new String[size]; //define size of array
          front=0; 
          rear=-1;
          nItems=0;
          
      }

      public String insert(String name){
          
          if(isFull()) //check if array is full
            return "\""+name+"\" could not be inserted as the queue is full."; 
            //return false as nothing more can be added
            
          if(rear==size-1) //if the last inserted is at the last array position
            rear=-1; 
            
          rear++;//increment rear
          array[rear]=name;//insert string
          nItems++;//record the input
          return "\""+name+"\" was inserted";//return true
          
      }

      public String remove() {
             
             if(isEmpty())//Ensure queue isn't empty
                return "There is nothing to remove. The queue is empty";
             
             String remove=array[front];//get the string to remove
             
             front++;//move up the front 
             
             if(front==size)//If its at the end of the array bring it to the front
                front=0;
             
             nItems--;//Record the removal
             
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
        
    	//if wrap around has occurred
    	if(front > rear) {
    		//print from the front to the end of the array
    		for(int i = front; i < array.length; i++)
    			System.out.print(array[i]+",");
    		//the go to the start of the array and
    		//print up to the rear
    		for(int i = 0; i <= rear; i++)
    			System.out.print(array[i]+",");
    	}
    	else {
    		
	        for(int i=front; i<=rear; i++) 
	            System.out.print(array[i]+",");

    	}
        
        System.out.println();
        
      }
}