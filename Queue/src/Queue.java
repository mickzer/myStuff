public class Queue
{
    private LinkedList list;
    private int nItems;
    
    public Queue()
    {
       list=new LinkedList();//create new linked list
       nItems=0;//set the number of items to 0
    }
    
    public void insert(String name) {
        
        list.add(name);//insert to list
        nItems++;//record insertion
        print();
        
    }
    
    public void remove() {
        
        nItems--;//record removal
        String out=list.removeHead();//remove from list
        if(out==null) {
            
            System.out.println("\nThere is nothing to remove as the Queue is empty.\n");
            nItems=0;
            
        }
        
        else if(list.isEmpty()){
            
            System.out.println("\n"+out+" was removed.");
            System.out.println("\nThe Queue has been emptied.\n");
            nItems=0;
            
        }
            
        else {
            
            System.out.println("\n"+out+" was removed.");
            print();
            
        }
        
    }
    
    public void nItems() {
        
        System.out.println("\nThere are "+nItems+" items in the queue.\n");
        
    }
    
    public void print() {
        
        System.out.println("\nQueue Contents:");
        list.display();//print list
        System.out.println("\n");
        
    }
    
    

}
