/*
 * Eman shah
 */
public class Node {
	String value;
	Node left, right;
	
	Node(String val)
	{
		value = val;
		left = null;
		right = null;
	}
	
	Node(String val, Node leftC, Node rightC)
	{
		value = val;
		left = leftC;
		right = rightC;
	}
}
