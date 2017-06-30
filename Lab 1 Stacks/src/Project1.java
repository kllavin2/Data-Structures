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


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Project1 
{		
   public static void main(String args[]) throws IOException 
   {
	   BufferedReader 	br; 	//Used for input file
	   FileReader 		fr;		//Used for input file
	   String 			line;	//Used to parse input file
	   PrintStream 		ps;		//Used for output file
	   FileOutputStream	fos;	//Used for output file

	   //Check for command line arguments.
       if (args.length != 2) 
       {
           System.out.println(
        		   "Usage: java Project1 [input file pathname] [output file "
        		   + "pathname]");
           System.exit(1);
       }
	   
	   //Attempt to open file IO
       try
       {
    	   //Open Reader
    	   fr = new FileReader(args[0]);
    	   br = new BufferedReader(fr);
    	   //Open writer
    	   fos = new FileOutputStream(args[1]);
    	   ps = new PrintStream(fos);
    	   System.setOut(ps);
       }
       catch (Exception ioExcept)
       {
    	   System.err.println(ioExcept.toString());
           return;
       }
       
       //Notify user via console
       System.err.println("Running Project1");
       System.err.println(" >All output redirected from console to:\n  >" 
       + args[1]);
       System.out.println("Running Project1");
       System.out.println("All output redirected from console to:\n >" 
       + args[1]);
	   
       // Process the input file 
	   while ((line = br.readLine()) != null) 
	   {
		   //Print current string
		   System.out.println("\nBeginning tests on string: \'" + line + 
				   "\'");
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
	   } 
	   
	   //Close reader stream
	   br.close();
	   
	   //Notify of completion
       System.err.println("Finished running Project1!");
       System.out.println("Finished running Project1!");
	   
   }
}

	   
	   	  