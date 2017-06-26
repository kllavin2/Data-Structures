/*----------------------------------------------------------------
 *  A stack of characters
 *  @version    1.0     2017-06-29
 *  @author     Kristi Lavin
 *----------------------------------------------------------------*/

public class StrStacks {
	
	int maxSize; //Max number of characters that can be stored in the stack
	int top; //Top (current size) of the stack
	Character A[]; //Character array to store the data
	
	
	
	/*
	 * Creates a new stack of characters in a string 
	 */
	public StrStacks(int n) 
	{
		
		maxSize=n;
		A=new Character[maxSize];
		top=0;
	}
	
	
	/*
	 * Looks to see if the stack is empty
	 * if it is return true if it is not empty return false
	 */
			
	public boolean isEmpty()
	{
		if(top==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * Looks to see if the stack is full
	 * if it is return turn if it is not return false
	 */
	
	public boolean isFull(){
		if(top==maxSize)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/*
	 * Push a character of the string onto the stack
	 */
	
	public void push(Character c)
	{
		if(top<maxSize)
		{
			
			A[top] = c;
			top++;	
			
		}
		else
		{
			System.out.println("Stack Overflow!");
		}
	
	}
	
	
	/*
	 * Pops the top item off the stack and moves the top item one down
	 * returns the top item of the stack
	 */
	
	public Character pop()
	{
		if(!this.isEmpty())
		{
			top--;
			return A[top];
		}
		else
		{			
			return null;
		}
		
	}
	
	
	
	/*
	 * Returns the top item on the stack if there is a top item
	 */	
	public Character peek()
	{
		if(top>0)
		{
			return A[top-1];	
		}
		else
		{
			return null; 
		}		
	}
	
	/*
	 * Returns the current size of the stack	
	 */
	public int getSize()
	{
		return top;
	}
	
	/*
	 * Prints the StrStacks object as a formatted string
	 * Use for debug purposes only
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String temp = "---------------------------\nmyStack object:\n -Top-\n";
		for (int i = top-1; i > 0; i--)
		{
			temp += " >" + A[i] + "\n";
		}
		temp += " -Bottom-\n---------------------------";
		return temp;
	}
}
	
