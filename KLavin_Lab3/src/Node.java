
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
