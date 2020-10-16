/*
 * Eman Shah
 */
public class BST {
	
	protected Node root;
	
	public int counter(String x)
	{
		int count = 0;
		Node trav = root;
		
		while(trav != null)
		{
			if(trav.value.equalsIgnoreCase(x))
			{
				count++;
			}
				
				
			if(trav.value.compareToIgnoreCase(x)< 0)
			{
				trav = trav.left;
			}
			else
			{
				trav = trav.right;
			}
			
		}
		return count;
	}

	
	/*
	 * Add method to insert Strings into the binary tree 
	 * as new nodes
	 * @param: String x to insert
	 */
	public void add(String x)
	{
		Node node = new Node(x);
		
		if(root == null)
		{
			root = node;
		}
		else
		{
		Node current = root;
		Node parent = root;
		
		while(current!=null)
		{
			parent = current;
			if(current.value.compareToIgnoreCase(x) < 0)
			{
				current = current.left;
				if(current == null)
				{
					parent.left = node;
				}
			}
			else
			{
				current = current.right;
				if(current == null)
				{
					parent.right = node;
				}
			}
		}
		}
	}
	
	/*
	 * Print method to print out contents of the Binary tree
	 * @param: Node to print
	 */
	public void print(Node p)
	{
		if (p!=null)
		{
			print(p.left);
			System.out.print(" "+p.value);
			print(p.right);
		}
	}
	
	/* 
	 * Search method to find specific String value
	 * (Not case-sensitive)
	 * @param: x - String to match
	 */
	public boolean search(String x)
	{
		Node temp = root;
		while(temp != null)
		{
			if(temp.value.equalsIgnoreCase(x))
			{
				return true;
			}
			else if(temp.value.compareToIgnoreCase(x) < 0 )
			{
				temp = temp.left;
			}
			else
			{
				temp = temp.right;
			}
		}
		
		return false;
	}
	
	/*
	 * Method to return the successor
	 * of a particular node for deleting purposes
	 * @param: node
	 */
	public Node getSuccessor(Node node)
	{
		Node successor = null;
		Node successorP = null;
		Node current = node.right;
		
		while(current != null)
		{
			successorP = successor;
			successor = current;
			current = current.left;
		}
		
		if(successor != node.right)
		{
			successorP.left = successor.right;
			successor.right = node.right;
		}
		return successor;
	}
	
	/*
	 * Delete method
	 * utilizes getSuccessor method
	 * @param String to delete
	 */
	public boolean delete(String x)
	{
		Node parent = root;
		Node current = root;
		boolean isLC = false;
		while(!(current.value.equalsIgnoreCase(x)))
		{
			parent = current;
			if(current.value.compareToIgnoreCase(x) < 0 )
			{
				isLC = true;
				current = current.left;
			}
			else
			{
				isLC = false;
				current = current.right;
			}
			if(current == null)
			{
				return false;
			}
		}
		
		if(current.left == null && current.right == null)
		{
			if(current == root)
			{
				root = null;
			}
			if(isLC == true)
			{
				parent.left = null;
			}
			else
			{
				parent.right = null;
			}
		}
		
		else if(current.right == null)
		{
			if(current == root)
			{
				root = current.left;
			}
			else if(isLC)
			{
				parent.left = current.left;
			}
			else
			{
				parent.right = current.left;
			}
		}
		else if(current.left != null && current.right != null)
		{
			Node successor = getSuccessor(current);
			if(current == root)
			{
				root = successor;
			}
			else if(isLC)
			{
				parent.left = successor;
			}
			else
			{
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return true;
	}
	
}

