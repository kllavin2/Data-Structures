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
					+ "[path to folder of output files]");
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
			System.err.println("Incorrect file paths provided for input folder!");
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
			int ssArr[] = new int[n];
			System.arraycopy(arr, 0, ssArr, 0, n);
			
			//Print original array
			System.out.println("ORIGINAL ARRAY FROM FILE:");
			printArray(arr);
			
			//Run and time Heap Sort			
			HeapSort HS = new HeapSort();
			long start = System.nanoTime();
			HS.heapSort(arr, n);
			long end = System.nanoTime();
			timing.append(end - start, n, "HS:"+file.getName());
			
			ShellSort SS = new ShellSort();
			start = System.nanoTime();
			SS.sort(ssArr);
			end = System.nanoTime();
			timing.append(end - start, n, "SS:"+file.getName());
			
			//Print sorted array
			System.out.println("HEAP SORT SORTED ARRAY:");
			printArray(arr);

			System.out.println("SHELL SORT SORTED ARRAY:");
			printArray(ssArr);

			//Print timing for this file
			System.out.printf("\nSize: %d\nTime: %d\nFile: %s\n", n, end-start, file.getName());
			
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

	static void printArray(int arr[]){
		for(int i = 0; i < arr.length; ++i){
			System.out.println(arr[i]);
		}
	}
}
