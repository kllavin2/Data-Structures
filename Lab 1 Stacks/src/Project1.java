/*----------------------------------------------------------------
 *  Project 1
 *  @author        Kristi Lavin
 *  @version       1.0			6/12/17
 *    
 *  Evaluates if a given string is in a Language L 
 *
 *  5 languages will be compared
 *
 *----------------------------------------------------------------*/


import java.io.*;
import java.io.IOException;

public class Project1 
{
	static int DEFAULT_STACK_SIZE = 100; //Global default stack size
	
	
   public static void main(String args[]) throws IOException 
   {
	   
	   StrStacks myStack= new StrStacks(DEFAULT_STACK_SIZE);
	   
	   //Variables to hold input and output files 
	   String infileName="Input.txt";
	   String outfileName="Output.txt";
	   
	   FileReader in=null;
	   FileWriter out=null;
	   try (BufferedReader br = new BufferedReader(new FileReader(infileName))) 
	   {
		   out= new FileWriter(outfileName);
		   String line = null;
		   while ((line = br.readLine()) != null) 
		   {
			   //Print current string
			   System.out.println("\nBeginning tests on string: \'" + line + "\'");
			   boolean L1Result = LanguageTests.testL1(line);
			   System.out.println(" >String in L1: " + String.valueOf(L1Result));
			   
			   boolean L2Result = LanguageTests.testL2(line);
			   System.out.println(" >String in L2: " + String.valueOf(L2Result));
			   
			   boolean L3Result = LanguageTests.testL3(line);
			   System.out.println(" >String in L3: " + String.valueOf(L3Result));
			   
			   boolean L4Result = LanguageTests.testL4(line);
			   System.out.println(" >String in L4: " + String.valueOf(L4Result));
			   
			   boolean L5Result = LanguageTests.testL5(line);
			   System.out.println(" >String in L5: " + String.valueOf(L5Result));
			   
			   //Test the StrStacks functionality
			   //Push characters to stack
			   for (int i = 0; i < line.length(); i++)
			   {
				   myStack.push(line.charAt(i));
			   }
			   
			   //Print stack object
//			   System.out.println(myStack);
			   
			   //Test stack by popping characters
			   while (!myStack.isEmpty())
			   {
				   Character poppedFromStack = myStack.pop();
//				   System.out.print(poppedFromStack);
//				   System.out.println(' ' + String.valueOf(poppedFromStack == 'C'));
			   }
			   
			   //Write to file
			   out.write(line+"\n");
		
		   }
		   
	   }	   
	   finally
	   {
		   if(in!=null)
		   {
			   in.close();
		   }
		   if(out!=null)
		   {
			   out.close();
		   }
	   }
	   
	   
   }
}

	   
	   	  