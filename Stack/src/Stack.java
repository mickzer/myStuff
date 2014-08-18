import java.util.*;

public class Stack
{
    
    private ArrayList<Character> stack;
    private int top; 
    
    public Stack() {
        
        stack = new ArrayList<Character>();    
        top = -1;
        
    }
    
    public void push(char c) {

        //insert into the incremented top position
        stack.add(++top, c);
        
    }
    
    public char pop() {
        //return the top position and decrement it
        return stack.remove(top--);
        
    }
    
    public char peek() {
        //return the top
        return stack.get(top);
        
    }
    
    private void print() {
        
    	//print out stack from top to bottom
        for(int i = stack.size()-1; i >= 0; i--) 
            System.out.print(" |"+stack.get(i)+"|");
        //line break
        System.out.println();
        
    }
    
    public static void palindrome(String s1) {
    	
    	//create a stack
    	Stack stack = new Stack();
    	//push all the characters of the string on to the stack
    	for(int i = 0; i < s1.length(); i++)
    		stack.push(s1.charAt(i));
    	
    	String reverse = "";
    	//pop everything from the stack to get the reverse
    	for(int i = 0; i < s1.length(); i++)
    		reverse += stack.pop();
    	
    	if(reverse.equals(s1))
    		System.out.println(s1 + " IS a palindrome.");
    	
    	else
    		System.out.println(s1 + " is NOT a palindrome.");
    	
    }
    
    public static void main(String args[]) {
    	
    	palindrome("navan");
    	
    }
    
}
