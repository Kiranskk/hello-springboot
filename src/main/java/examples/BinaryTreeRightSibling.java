/**
 * 
 */
package examples;

/**
 * @author test
 * 
 * 1. Tried with Breadth First Search with a Queue,
 * 2. Level order nodes in to a ArrayList
 * 3. From the ArrayList first node is root and last node is right most node, we can set the sibling to null
 * 4. other elements Arr[1] sibling is Arr[2]
 * 5. elements Arr[2] sibling is Arr[3]
 * 6. iterate step 4 and 5 till end of list
 * 7. Challenge is how to convert this ArrayList of Level order nodes to a Binary Tree back??    
 *    but Node in line updates needs
 * 8. Hint , may be need level info
 * 
 *  other question
 *  LinkedList vs ArrayList both are list interface
 *  Linked List is more performance then ArrayList       
 * 
 * 
 * FB Interview question 11/13/2020
 * 
 *        1  --> null
 *     /      \
 *  2->3	    3 --> null
 * /   \	   /   \
 *4->5  5->6  6->7  7 --> null
 * 
 * 
 *
 */
public class BinaryTreeRightSibling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NNode root = new NNode();
		
		compute(root);
		
		
		

	}
	
	
	/**
	 * Modify the the Binary Tree and set Right Sibling 
	 * @param node
	 */
	static void compute(NNode node){
		
		if(node!=null) {
			
			setRightSiblingDFS(node, 0);
			
		}
		
		
	}
	
	/**
	 * using recursion
	 * @param node
	 * @param level
	 */
	static void setRightSiblingDFS(NNode node, int level){
		
		if(level==0) {
			//root right sibling is null
			node.Sibling = null;
		}
		
		//Right most nodes right siblings are null 
		
		setRightSiblingDFS(node.right, level+1);
		
		setRightSiblingDFS(node.right, level+1);
		
	}
	
	
	
	

}

class NNode{
	
	NNode left;
	NNode right;
	NNode Sibling=null;
	
}


