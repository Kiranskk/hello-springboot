/**
 * 
 */
package trees;

/**
 * @author test
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node root = new Node(6);
		BinarySearchTree binarySearchTree = new BinarySearchTree(root);
		binarySearchTree.addNewValue(4);
		binarySearchTree.addNewValue(8);
		binarySearchTree.addNewValue(3);
		binarySearchTree.addNewValue(5);
		binarySearchTree.addNewValue(7);
		binarySearchTree.addNewValue(9);
		binarySearchTree.addNewValue(1);
		binarySearchTree.addNewValue(20);
		
		System.out.println(" Binary Search Tree  " + binarySearchTree);
		
	}

}


class BinarySearchTree {
	
	Node root;
	
	BinarySearchTree(Node parent){
		this.root = parent;
	}
	
	private Node addNewNode(Node current,int value) {
		
		if(current==null) return new Node(value) ; 
		
		if(value < current.val) {
			//go to left
			current.left = addNewNode(current.left, value); 
			
		}else if(value > current.val) {
			//go to right
			current.right = addNewNode(current.right, value);
			
		}else {
			//value already exists
			return current;
		}
		
		return current;
		
	}
	
	public void addNewValue(int val) {
		addNewNode(root, val);
	}

	@Override
	public String toString() {
		return "BinarySearchTree [root=" + root + "]";
	}
  	
}



class Node {
	int val;
	Node left;
	Node right;
	
	Node(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
	
	
}
