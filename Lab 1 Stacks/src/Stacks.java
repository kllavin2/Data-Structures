/*----------------------------------------------------------------
 *  Author:        Kristi Lavin
 *  Written:       6/12/17
 *  Last updated:  6/12/17
 *    
 *  Evaluates if a given string is in a Language L 
 *
 *  5 languages will be compared
 *
 *----------------------------------------------------------------*/

import java.io.*;
public class Stacks {

   public static void main(String args[]) throws IOException {
	   try (BufferedReader br = new BufferedReader(new FileReader("Input.txt"))) {
		   String line = null;
		   while ((line = br.readLine()) != null) {
		       System.out.println(line);
		   }
		}
   }
   }