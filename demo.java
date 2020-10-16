
public class demo {

	public static void main(String[] args)
	{
		BST bst = new BST();
		bst.add("this");
		bst.add("is");
		bst.add("a");
		bst.add("test");
		bst.add("to");
		bst.add("test");
		bst.add("text");
		bst.add("added");
		bst.add("in");
		bst.add("a");
		bst.add("tree");
		bst.add("made");
		bst.add("to");
		bst.add("test");
		bst.add("this");
		
		int test = bst.counter("test");
		int to = bst.counter("to");
		int a = bst.counter("a");
		int made = bst.counter("made");
		
		System.out.print("test: "+test+"\nto: "+to+"\na: "+a+"\nmade:"+made);
		
	}
}
