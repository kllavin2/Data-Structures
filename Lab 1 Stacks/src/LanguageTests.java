
public class LanguageTests {

	static int DEFAULT_STACK_SIZE = 100; //Global default stack size
	/*
	 * This function tests whether or not the given string is in L1.
	 * Let L1= { w: w contains equal numbers of A's and B's (in any order) and no other characters} 
	 * @param s String to test against L1 criteria
	 * @return result Boolean result of test.
	 */
	public static boolean testL1(String s)
	{
		boolean result = true; //Assume string passes test
		
		//Declare stacks
		StrStacks aStack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks bStack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks otherStack = new StrStacks(DEFAULT_STACK_SIZE);
		
		//Populate Stacks
		for (int index = 0; index < s.length(); index++)
		{
			Character c = s.charAt(index); 
			if (c == 'A')
			{
				aStack.push(c);
			}
			else if (c == 'B')
			{
				bStack.push(c);
				
			}
			else
			{
				otherStack.push(c);
			}			
		}
		
		
		//Run language test
		if (aStack.isEmpty() && bStack.isEmpty())
		{
			result=false; 
		}	
		
		while (!aStack.isEmpty() || !bStack.isEmpty())
		{
			Character a = aStack.pop();
			Character b = bStack.pop();
			if (a == null || b == null)
			{
				result = false;
			}
			
		}
		
		if (!otherStack.isEmpty())
		{
			result = false;
		}
		
		return result;
	}
	
	/*
	 * This function tests whether or not the given string is in L2.
	 * Let L2 = { w: w is of the form AnBn, for some n > 0 }  
	 * @param s String to test against L1 criteria
	 * @return result Boolean result of test.
	 */
	
	public static boolean testL2(String s)
	{
		boolean result = true; //Assume string passes test
		boolean newStack=true;//Check first item on top of stack
		boolean poppedLetterA=false;//Check if character is A
		
		//Declare stacks
		StrStacks L2Stack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks aStack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks bStack = new StrStacks(DEFAULT_STACK_SIZE);
				
				
		//Populate Stacks
		for (int index = 0; index < s.length(); index++)
		{
			Character c = s.charAt(index);
			L2Stack.push(c);
		}
		
		//Run language test		
		if (L2Stack.isEmpty())
		{
			result=false; 
		}
		
		while(!L2Stack.isEmpty())
		{
			Character c = L2Stack.pop();
			
			//Disqualify if top of fresh stack is not 'B'
			if(c!='B' && newStack)
			{
				result = false;
			}
			
			newStack = false;
			//Disqualify if top of stack is not 'A' or 'B'
			if(c!='A'&& c!='B')
			{
				result = false; 
			}
			
			if (c == 'A')
			{
				poppedLetterA = true;
				aStack.push(c);
			}
			//Disqualify if 'B' comes after an 'A'
			else if( c == 'B')
			{	 
				if(poppedLetterA)
				{
					result = false;
				}
				bStack.push(c);
			} 
			
		}	
		
		//Disqualify if 'A' does not equal 'B'
		while (!aStack.isEmpty() || !bStack.isEmpty())
		{
			Character a = aStack.pop();
			Character b = bStack.pop();
			if (a == null || b == null)
			{
				result = false;
			}
			
		}
				
		return result;
	}
	
	/*
	 * This function tests whether or not the given string is in L3.
	 * L3 = { w: w is of the form AnB2n, for some n > 0 }  
	 * @param s String to test against L1 criteria
	 * @return result Boolean result of test.
	 */
	public static boolean testL3(String s)
	{
		boolean result = true; //Assume string passes test
		boolean newStack=true;//Check first item on top of stack
		boolean poppedLetterA=false;//Check if character is A
		
		//Declare stacks
		StrStacks L3Stack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks aStack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks bStack = new StrStacks(DEFAULT_STACK_SIZE);
							
		//Populate Stacks
		for (int index = 0; index < s.length(); index++)
		{
			Character c = s.charAt(index);
			L3Stack.push(c);
		}
		
		//Run language test		
		if (L3Stack.isEmpty())
		{
			result=false; 
		}
		
		while(!L3Stack.isEmpty())
		{
			Character c = L3Stack.pop();
			
			//Disqualify if top of fresh stack is not 'B'
			if(c!='B' && newStack)
			{
				result = false;
			}
			
			newStack = false;
			//Disqualify if top of stack is not 'A' or 'B'
			if(c!='A'&& c!='B')
			{
				result = false; 
			}
			//Pushes 'A' onto aStack
			if (c == 'A')
			{
				poppedLetterA = true;
				aStack.push(c);
			}
			//Disqualify if 'B' comes after an 'A'
			else if( c == 'B')
			{	 
				if(poppedLetterA)
				{
					result = false;
					
				}
				bStack.push(c);
			}
		}	
	
		//Disqualify if 'A' does not equal '2B'
		while (!aStack.isEmpty() || !bStack.isEmpty())
		{
			Character a = aStack.pop();
			Character b = bStack.pop();
			Character b2= bStack.pop();
			if (a == null || b == null || b2== null)
			{
				result = false;
			}
					
		}
			
		return result;
		
	}
	
	/*
	 * This function tests whether or not the given string is in L4.
	 * L4 = { w: w is of the form (AnBm)p, for some m,n,p > 0 } 
	 * @param s String to test against L1 criteria
	 * @return result Boolean result of test.
	 */
	
	public static boolean testL4(String s)
	{
		boolean result = true; //Assume string passes test
		boolean newStack=true;//Check first item on top of stack
		boolean poppedLetterA=false;//Check if character is A
		
		//Declare stacks
		StrStacks L3Stack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks aStack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks bStack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks rptStack= new StrStacks(DEFAULT_STACK_SIZE);
							
		//Populate Stacks
		for (int index = 0; index < s.length(); index++)
		{
			Character c = s.charAt(index);
			L3Stack.push(c);
		}
		
		//Run language test		
		if (L3Stack.isEmpty())
		{
			result=false; 
		}
		
		while(!L3Stack.isEmpty())
		{
			Character c = L3Stack.pop();
			
			//Disqualify if top of fresh stack is not 'B'
			if(c!='B' && newStack)
			{
				result = false;
			}
			
			newStack = false;
			//Disqualify if top of stack is not 'A' or 'B'
			if(c!='A'&& c!='B')
			{
				result = false; 
			}
			//Pushes 'A' and 'B' onto rptStack
			if (c == 'A' || c == 'B')
			{
				rptStack.push(c);
			}
		}	
		
		while(!rptStack.isEmpty())
		{
			Character c = rptStack.pop();
			if(c == 'A'){
				
			}
		}
	
		//Disqualify if 'A' does not equal '2B'
		while (!aStack.isEmpty() || !bStack.isEmpty())
		{
			Character a = aStack.pop();
			Character b = bStack.pop();
			Character b2= bStack.pop();
			if (a == null || b == null || b2== null)
			{
				result = false;
			}
					
		}
			
		return result;
		
	}
	
	public static boolean testL5(String s)
	{
		boolean result = true;
		//Do code here
		System.out.println("TODO: WRITE THIS FUNCTION!");		
		return result;
	}

}
