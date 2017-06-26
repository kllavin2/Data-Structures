
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
		while (!aStack.isEmpty() && !bStack.isEmpty())
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
	
	public static boolean testL2(String s)
	{
		boolean result = true;
		//Do code here
		System.out.println("TODO: WRITE THIS FUNCTION!");		
		return result;
	}
	
	public static boolean testL3(String s)
	{
		boolean result = true;
		//Do code here
		System.out.println("TODO: WRITE THIS FUNCTION!");		
		return result;
	}
	
	public static boolean testL4(String s)
	{
		boolean result = true;
		//Do code here
		System.out.println("TODO: WRITE THIS FUNCTION!");		
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
