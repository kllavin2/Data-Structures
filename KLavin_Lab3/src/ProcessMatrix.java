//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//public class ProcessMatrix {
//	public static int[][] created2DMfromtxt(String filename) throws Exception{
//	int [][] m = null;
//	InputStream stream = ClassLoader.getSystemResourceAsStream(filename);
//	BufferedReader buffer = new BufferedReader(new InputStreamReader (stream));
//	
//	String line;
//	int row = 0;
//	int size = 0;
//	
//	while ((line = buffer.readLine()) != null)
//	{
//		String[] vals = line.trim().split("\\s+");
//		
//		if (m == null)
//		{
//			size = vals.length;
//			m = new int[size][size];
//		}
//		for (int col = 0; col < size; col++)
//		{
//			m[row][col] = Integer.parseInt(vals[col]);
//		}
//		row++;
//	}
//
//	return m; 
//}
//	public static void printMatrix(int[][]m){
//		String str = "";
//		int size = m.length;
//		
//		if(m != null)
//		{
//			for(int row = 0; row< size; row++)
//			{
//				str += " ";
//				for(int col = 0; col < size; col++)
//				{
//					str += String.format("%d",  m[row][col]);
//					if(col <size-1)
//					{
//						str += "|";
//					}
//				}
//				if(row < size -1)
//				{
//					str +="\n";
//					for(int col = 0; col < size; col++)
//					{
//						for(int i =0; i < 4; i++){
//							str += "-";	
//						}
//					if (col< size-1)
//					{	
//						str +="+";
//					}
//				}
//				str +="\n";
//				}
//				else
//				{
//					str +="\n";
//				}
//			}
//		}
//		System.out.println(str);
//	}
//
//}	