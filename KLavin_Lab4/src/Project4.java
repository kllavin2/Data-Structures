/*
 * Project 4
 * @author		Kristi Lavin
 * @version		1.0				8/17/2017
 * 
 * Entry Point of the application. It outlines the solution of the
 * project and handles input and output files. Compares HeapSort 
 * and shell sorts iteratively 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Project4 {

	public static void main(String[] args) throws IOException{
		RunTime timing = new RunTime();
		BufferedReader 	    br; //Used for input file
		FileReader     	    fr; //Used for input file
		PrintStream    		ps; //Used for output file
		FileOutputStream 	fos; //Used for output file
		File 				inFolder;
		
		//Check for command line arguments
		if(args.length != 2){
			System.out.println(
					"Usage: Java Project 4 [path to folder of input files]"
					+ "[path to output file]");
			System.exit(1);
		}
		
		try
		{
			//Open writer
			fos = new FileOutputStream(args[1]);
			ps = new PrintStream(fos);
			System.setOut(ps);
		}
		catch(Exception ioExcept)
		{
			System.err.println(ioExcept.toString());
			return;
		}
		
		try{
			inFolder = new File(args[0]);
		}
		catch (Exception e){
			System.err.println("Incorrect file path provided for input folder!");
			throw e;
		}		
		
		//Get list of files
		File inFiles[] = inFolder.listFiles();		
		
		//Notify user via console
		System.err.println("Running Project4");
		System.err.println(">All output redirected from console to :\n"
				+ args[1]);
		System.out.println("Running Project4");
		System.out.println("All output redirected from console to:\n"
				+ args[1]);
		
		//Iterate over files
		for (File file : inFiles){
			System.out.printf("Parsing: %s\n", file.getName());
			try
			{
				//Open Reader
				fr = new FileReader(file.getAbsolutePath());
				br = new BufferedReader(fr);
				//System.setOut(ps);
			}
			catch(Exception ioExcept)
			{
				System.err.println(ioExcept.toString());
				return;
			}
			//Get array size
			int n = 0;			
			while (br.readLine() != null){
				++n;
			}
			br.close();
			
			//Create array
			int arr[] = new int[n];

			//Open Reader
			fr = new FileReader(file.getAbsolutePath());
			br = new BufferedReader(fr);
			
			//Populate array
			int pos = 0;
			String currentLine;
			while ((currentLine = br.readLine()) != null){
				arr[pos] = Integer.parseInt(currentLine);
				++pos;
			}
			
			//Copy array for shell sort
			int ss0Arr[] = new int[n];
			int ss1Arr[] = new int[n];
			int ss2Arr[] = new int[n];
			int ss3Arr[] = new int[n];
			System.arraycopy(arr, 0, ss0Arr, 0, n);
			System.arraycopy(arr, 0, ss1Arr, 0, n);
			System.arraycopy(arr, 0, ss2Arr, 0, n);
			System.arraycopy(arr, 0, ss3Arr, 0, n);
			
			//Print original array
			System.out.println("ORIGINAL ARRAY FROM FILE:");
			printArray(arr);
			
			//Run and time Heap Sort			
			HeapSort HS = new HeapSort();
			long start = System.nanoTime();
			HS.heapSort(arr, n);
			long end = System.nanoTime();
			timing.append(end - start, n, "HS:"+file.getName());
			
			//Shell sort 0
			ShellSort SS = new ShellSort();
			start = System.nanoTime();
			SS.sort0(ss0Arr);
			end = System.nanoTime();
			timing.append(end - start, n, "SS0:"+file.getName());
			
			//Shell Sort 1
			start = System.nanoTime();
			SS.sort1(ss1Arr);
			end = System.nanoTime();
			timing.append(end - start, n, "SS1:"+file.getName());
			
			//Shell Sort 2
			start = System.nanoTime();
			SS.sort2(ss2Arr);
			end = System.nanoTime();
			timing.append(end - start, n, "SS2:"+file.getName());
			
			//Shell Sort 3
			start = System.nanoTime();
			SS.sort3(ss3Arr);
			end = System.nanoTime();
			timing.append(end - start, n, "SS3:"+file.getName());
			
			//Print status of sorted arrays
			System.out.println("HEAP SORT SORTED ARRAY:");
			printArray(arr);

			System.out.println("SHELL SORT 0 SORTED ARRAY:");
			printArray(ss0Arr);

			System.out.println("SHELL SORT 1 SORTED ARRAY:");
			printArray(ss1Arr);

			System.out.println("SHELL SORT 2 SORTED ARRAY:");
			printArray(ss2Arr);

			System.out.println("SHELL SORT 3 SORTED ARRAY:");
			printArray(ss3Arr);

			//Print timing for this file
			System.out.printf("\n>Size: %d\n>Time: %d\n>File: %s\n\n", n, end-start, file.getName());

			System.out.printf("FINISHED: %s\n\n", file.getName());
			
			//Close reader stream
			br.close();
		}
		//Display Timing
		System.out.println(timing);
		
		//Notify of completion
		System.err.println("Finished running Project4!");
		System.out.println("Finished running Project4!");

		//Close writer stream
		ps.close();
	}
	
	//Prints array status, or entire array if small enough
	static void printArray(int arr[]){
		if (arr.length <= 50){
			for(int i = 0; i < arr.length; ++i){
				System.out.printf("\t%d\n", arr[i]);
			}
		}
		else{
			System.out.println("\tArray size > 50, skipping printing of array.");
		}
		
		System.out.printf("\tSorted: %s\n", String.valueOf(isSorted(arr)));
	}
	
	//Checks if array is sorted
	static boolean isSorted(int[] a){
		for(int i = 0; i < a.length - 1; ++i){
			if (a[i] > a[i+1]){
				return false;
			}
		}		
		return true;
	}
}
