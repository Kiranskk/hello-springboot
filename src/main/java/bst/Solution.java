/**
 * 
 */
package bst;

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
		root.insert(4);
		root.insert(8);
		root.insert(3);
		root.insert(5);
		root.insert(7);
		root.insert(9);
		//root.insert(1);
		//root.insert(20);
		
		
		System.out.println("In Order Traversal ");
		root.printInOrder();
		
		System.out.println("Pre Order Traversal ");
		root.printPreOrder();
		
		
		System.out.println("Post Order Traversal ");
		
		root.printPostOrder();
		
	}

}

class Node{
	
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data =data;
	}
	
	
	public void insert(int value){
		if(value<=data) {
			if(left==null) {
				left = new Node(value);
			}else {
				left.insert(value);
			}
		}else{//duplicate nodes prb
			if(right==null) {
				right= new Node(value);
			}else {
				right.insert(value); 
			}
		}
	}
	
 public boolean contains(int value) {
	 if(value==data) {
		 return true;
	 }else if(value<data) {
		 if(left==null) {
			 return false;
		 }else {
			 return left.contains(value);
		 }
	 }
	 else {
		 
		 if(right==null) {
			 return false;
		 }else {
			 return right.contains(value);
		 }
		 
	 }
	 
	 
 }
	
 public void printInOrder() {
	 if(left!=null) {
		 left.printInOrder();
	 }
	 System.out.println(data);
	 if(right!=null) {
		 right.printInOrder();
	 }
	 
 }
 
 public void printPreOrder() {
	 
	 System.out.println(data);
	 
	 if(left!=null) {
		 left.printInOrder();
	 }
	 
	 if(right!=null) {
		 right.printInOrder();
	 }
	 
 }
 
 
 public void printPostOrder() {
	 if(left!=null) {
		 left.printInOrder();
	 }
	 
	 if(right!=null) {
		 right.printInOrder();
	 }
	 
	 System.out.println(data);
	 
 }
 	
}

