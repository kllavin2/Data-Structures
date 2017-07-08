
public class LanguageTests {

	static int DEFAULT_STACK_SIZE = 100; //Global default stack size
	/*
	 * This function tests whether or not the given string is in L1.
	 * Let L1= { w: w contains equal numbers of A's and B's (in any order) 
	 * and no other characters} 
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
	 * @param s String to test against L2 criteria
	 * @return result Boolean result of test.
	 */
	
	public static boolean testL2(String s)
	{
		boolean result = true; //Assume string passes test
		boolean newStack=true;//Check first item on top of stack
		boolean poppedLetterA=false;//Check if character is A
		
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
	 * @param s String to test against L3 criteria
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
	 * L4 = { w: w is of the form (AnBm)^p, for some m,n,p > 0 } 
	 * @param s String to test against L4 criteria
	 * @return result Boolean result of test.
	 */	
	public static boolean testL4(String s)
	{
		boolean result = true; //Assume string passes test
		boolean newStack=true;//Check first item on top of stack
		
		//Declare stacks
		StrStacks l4Stack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks aStack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks bStack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks aStack2 = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks bStack2 = new StrStacks(DEFAULT_STACK_SIZE);
		
		//Populate Stacks
		for (int index = 0; index < s.length(); index++)
		{
			Character c = s.charAt(index);
			l4Stack.push(c);
		}
		
		//Run language test
		//Check if empty
		if (l4Stack.isEmpty())
		{
			result=false; 
		}
		
		
		while(!l4Stack.isEmpty())
		{
			Character c = l4Stack.pop();
			
			//Disqualify if top of fresh stack is not 'B'
			if(c!='B' && newStack)
			{
				result = false;
			}			
			newStack = false;
			
			//Disqualify if character is not 'A' or 'B'
			if(c!='A'&& c!='B')
			{
				result = false; 
			}			
			
			//"New" P segment
			if (c == 'B' && !aStack.isEmpty())
			{
				//Start "P" check
				if (aStack2.isEmpty() && bStack2.isEmpty() 
						&& l4Stack.isEmpty())
				{
					//Do nothing, P == 1
					
				}
				else if (aStack2.isEmpty() && bStack2.isEmpty())
				{
					//Start of main stack
					while (!aStack.isEmpty())
					{
						aStack2.push(aStack.pop());
						
					}

					while (!bStack.isEmpty())
					{
						bStack2.push(bStack.pop());
					}
				}
				else
				{
					//Compare a/a2 and b/b2 stacks (P values)
					StrStacks aTemp = new StrStacks(DEFAULT_STACK_SIZE);
					StrStacks bTemp = new StrStacks(DEFAULT_STACK_SIZE);
					while (!aStack.isEmpty() 
							|| !bStack.isEmpty() 
							|| !aStack2.isEmpty() 
							|| !bStack2.isEmpty())
					{
						Character a, b, a2, b2;
						a = aStack.pop();
						b = bStack.pop();
						a2 = aStack2.pop();
						b2 = bStack2.pop();
						aTemp.push(a);
						bTemp.push(b);
						if (a != a2 || b != b2)
						{
							result = false;
						}						
					}
					
					//Repopulate Prev Stacks
					while (!aTemp.isEmpty())
					{
						aStack2.push(aTemp.pop());
						
					}
					while (!bTemp.isEmpty())
					{
						bStack2.push(bTemp.pop());
					}					
				}
			}
			
			//Populate stacks
			if (c == 'A')
			{
				aStack.push(c);
			}
			else if (c == 'B')
			{
				bStack.push(c);
			}
		}	
		return result;
		
	}
	
	/*
	 * This function tests whether or not the given string is in L5.
	 * L5 = { w: w follows a Fibonacci sequence for alternating A's and B's 
	 * for any string with length > 3. e.g. ABAABBBAAAAA } 
	 * @param s String to test against L5 criteria
	 * @return result Boolean result of test.
	 */
	public static boolean testL5(String s)
	{
		boolean result = true;
		boolean newStack=true;//Check first item on top of stack		
		Character f1;
		f1 = null;
		boolean singleRun = true;
		//Declare stacks
		StrStacks l5Stack = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks fib = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks fib1 = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks fib2 = new StrStacks(DEFAULT_STACK_SIZE);
		StrStacks fib3 = new StrStacks(DEFAULT_STACK_SIZE);
		
		//Populate Stacks
		for (int index = 0; index < s.length(); index++)
		{
			Character c = s.charAt(index);
			l5Stack.push(c);
		}
		
		//Character check for not A and not B, prep for fib sequence.
		while (!l5Stack.isEmpty())
		{
			Character c = l5Stack.pop();
			
			if (c != 'A' && c != 'B')
			{
				result = false;
			}			
			fib.push(c);
		}
		
		//Check for fibonacci and "alternating" AB 
		while (!fib.isEmpty())
		{			
			Character c = fib.pop();
			if (newStack)
			{
				f1 = c;
				newStack = false;
			}
			
			if (c == f1 && fib2.isEmpty())
			{
				fib1.push(c);
			}
			else if (c != f1)
			{
				fib2.push(c);
			}			
			else
			{
				singleRun = false;
				fib.push(c);
				while (!fib1.isEmpty())
				{
					fib1.pop();
					fib3.push(fib.pop());
				}

				StrStacks f2Temp = new StrStacks(DEFAULT_STACK_SIZE);
				while (!fib2.isEmpty())
				{
					f2Temp.push(fib2.pop());
					fib3.push(fib.pop());
				}
				
				while (!f2Temp.isEmpty())
				{
					fib.push(f2Temp.pop());
				}
				Character f3Top = fib3.peek();
				while(!fib3.isEmpty())
				{
					Character f3 = fib3.pop();
					if (f3 != f3Top)
					{
						result = false;
					}
					fib.push(f3);
				}
				//reset
				f1 = fib.peek();
				fib.pop();
			}
		}
		//Handle L2? edge case
		if (singleRun)
		{
			result = false;
		}
		return result;
	}

}
