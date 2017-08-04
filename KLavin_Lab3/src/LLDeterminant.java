/*
 * Calculates the determinate of a sparse matrix using linked list.
 * @Version 1.0 
 * @Author K. Lavin
 */
public class LLDeterminant
{
	Node TopLeftCorner;// points to the top left corner
	int maxRow; // number of rows
	int maxCol; // number of columns
	

		
		public LLDeterminant(int rowSize, int colSize)
		{
			maxRow = rowSize;
			maxCol = colSize;
			//Creates a dummy node TopLeftCorner points down to
			Node lastrow = new Node(rowSize + 1, 0, 0, null, null);
			//Creates a dummy node TopLeftCorner points right to
			Node lastcol = new Node(0, colSize + 1, 0, null, null);
			//TopLeftCorner node 
			TopLeftCorner = new Node(0,0,0, lastrow, lastcol);
		}
		//getElement returns the integer value stored at the coordinate
		public int getValue(int row, int col)
		{
			Node current; // the node that will traverse the matrix
			int value = 0;// the value of the element 
			current = findValue(row,col);
			
			if (current != null)// the node was found
			{
				value = current.value;// returns the value
			}
			return value;
		}
		//Set a value to a particular coordinate in the matrix to a certain value
		public void setValue(int row, int col, int newEntry)
		{
			
			Node prev = null;// previous node to manage links
			Node current; //current node
			
			
			current = findValue(row,col); //makes current the old node if one exists
			 if(current != null)// if one exists, changes the value stored
			 {
				 current.value = newEntry;
				 if(current.value == 0)//if it changes the value to 0 the node is removed
				 {
					 findDown(row, col).down = current.down;//bypasses the node in the column
					 findRight(row,col).right = current.right;//bypasses the node in its row
					 if(isRowEmpty(row))
					 deleteRow(row);
					 if(isColEmpty(col))
					 deleteCol(col);
				 }
			 }
			 else
			 {
				 if(findValue(row,0)== null)//if the row doesn't exist it is created
				 createRow(row);
				 if(findValue(0,col)==null)//if the column doesn't exists it is created
				 createCol(col);
				 
				 current = TopLeftCorner;
				 
				 //traverse the linked list until current is pointing
				 //to the node after the node to create
				 //prev points to the node before it
				 while(current.row < row)
					 current = current.down;
				 while(current.col < col)
				 {
					 prev = current;
					 current = current.right;
				 }
				 
				 //makes the new node pointed to by the left node
				 prev.right = new Node (row, col, newEntry, findDown(row,col).down, current);
				 
				 //creates a link from the node above it to the node just created
				 findDown(row, col).down = prev.right;
				 
					 
			 }
		}
		//returns the value of the specified node
		private Node findValue(int row, int col)
		{
			Node current = TopLeftCorner;
			Node found = null; // node to be returned. If not found will remain null
			while(current.row < row)//moves to row 
				current = current.down;
			if(current.row == row)
			{
				while(current.col < col)
					current = current.right;
				if(current.col == col)// if the column exists we have found the node 
				found = current; 
			}
			
		return found;
		}
		//used to find the node above a certain value
		private Node findDown(int row, int col)
		{
			Node current = TopLeftCorner; 
			Node prev = null;
			//traverse right to the correct column
			while(current.col < col)
				current = current.right;
			//then traverse down
			while(current.row < row)
			{
				prev = current;
				current = current.down;
			}
			return prev;
		}
		//used to find the node left of a specified node
		private Node findRight(int row, int col)
		{
			Node current = TopLeftCorner;
			Node prev = null;
			
			//traverses down to the correct row
			while (current.row <row)
				current = current.down;
			//traverses right until current is right of the node and prev is left
			while(current.col < col)
			{
				prev = current;
				current = current.right;
			}
			return prev;
		}
		//delete rows
		private void deleteRow(int row)
		{
			Node prev = null;
			Node current = TopLeftCorner; 
			//traverse down to the row header to be deleted
			while(current.row < row)
			{
				prev = current;
				current = prev.down;
			}
			//bypass the empty row
			prev.down = current.down;
		}
		//delete a column
		private void deleteCol(int col)
		{
			Node prev = null;
			Node current = TopLeftCorner;
			
			//Traverse right to the correct column to delete
			while(current.col < col)
			{
				prev = current;
				current = current.right;
			}
			//bypass the empty column
			prev.right = current.right;
		}
		//create a row
		private void createRow(int row)
		{
			Node prev = null;
			Node current = TopLeftCorner;
			
			//traverse down to create a row
			while(current.row < row)
			{
				prev = current;
				current = current.down;
			}
			//create a new header node that points to a trailer node
			//that points to nothing
			prev.down = new Node(row, 0,0, current, new Node(row, maxCol +1, 0, null, null));
		}
		
		//create a new column
		private void createCol(int col)
		{
			Node prev = null;
			Node current = TopLeftCorner;
			//traverse right
			while(current.col < col)
			{
				prev = current;
				current = current.right;
			}
			
			prev.right = new Node (0, col, 0, new Node (maxRow +1, col, 0, null, null), current);
		
		}
		private boolean isRowEmpty(int row)
		{
			boolean rowEmpty = true;
			Node test = TopLeftCorner;
			//traverse row header
			while(test.row  < row)
				test = test.down;
			//if the correct header is found determine if there are only two nodes
			if(test.row == row)
			//if so return false
			if(test.right.right != null) rowEmpty = false;
			
			return rowEmpty;
		}
		//check if the column is empty
		private boolean isColEmpty(int col)
		{
			boolean colEmpty = true;
			Node test = TopLeftCorner;
			//traverse row header
			while(test.col  < col)
				test = test.right;
			//if the correct header is found determine if there are only two nodes
			if(test.col == col)
			//if so return false
			if(test.down.down != null) colEmpty = false;
			
			return colEmpty;
		}
		
		

public class Node {
	int row; // the row the node is in
	int col; // the column this node is in
	int value; //value to be stored
	
	//can be a trailer dummy nodes
	Node down; // pointer that points to the next non-zero number below it
	Node right; // pointer that points to the next non-zero number to the right
	
	public Node(int row, int col, int value, Node down, Node right)
	{
		this.row = row;
		this.col = col;
		this.value = value;
		this.down = down;
		this.right = right;
	}
	

}
//	//Calculate determinant recursively
//	public int determinant()
//	{
//		int det = 0;
//		//For 1x1 Matrix
//		if (N == 1)
//			det = A[0][0];
//		//For 2x2 Matrix
//		else if (N == 2)
//			det = A[0][0]*A[1][1]-A[1][0]*A[0][1];
//		//NxN matrix
//		else
//		{
//			for(int j = 0; j < N; j++)
//			{
//				M = SubArray(A, N, j);
//				det += Math.pow(-1, 1+j+1)*A[0][j]*determinant();
//			}
//		}
//		return det; 
//	}
}
