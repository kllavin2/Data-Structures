
public class Node {
	int row; // the row the node is in
	int col; // the column this node is in
	int value; //value to be stored	
	Node next; // pointer that points to the next non-zero number to the right
	
	public Node(int row, int col, int value, Node next)
	{
		this.row = row;
		this.col = col;
		this.value = value;
		this.next = next;
	}
	

}
