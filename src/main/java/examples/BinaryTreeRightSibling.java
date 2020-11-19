/**
 * 
 */
package examples;

import java.util.*;

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

	static NNode tempnode = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//2 level Tree 
		NNode left = new NNode(2,new NNode(4),new NNode(5));
		NNode right = new NNode(3, new NNode(6),new NNode(7));
		NNode root = new NNode(1, left,right);
		
		//1 level Tree 
//		NNode left = new NNode(2,null,null);
//		NNode right = new NNode(3, null,null);
//		NNode root = new NNode(1, left,right);
		
		//0 level only root
		//NNode root = new NNode(1, null,null);
		
		
		compute(root);
		if(root!=null)
			System.out.println("Tree with Siblings:\n"+root.toString());		
		else 
			System.out.println("Test Failed Tree with Siblings root is null ");
	}
	
	
	/**
	 * Modify the the Binary Tree and set Right Sibling 
	 * @param node
	 */
	static void compute(NNode node){
		
		 
		
		if(node!=null) {
			
			//setRightSiblingDFS(node, 0);
			
			//setRightSiblingBFS(node, 0);
			
			setRightSiblingLinkedList(node, 0);
			
			
		}
		
		
	}
	
	/**
	 * using recursion
	 * @param node
	 * @param level
	 */
	static void setRightSiblingDFS(NNode node, int level){
		
		if(node==null) {
			return;
		}
		
		if(level==0) {
			//root right sibling is null
			node.sibling = null;
		}
		
		if(node.right!=null && node.left!=null) {
			node.left.sibling = node.right;
		}
		
		if(level>=1 && node.right!=null) {
			//for testing
			node.right.sibling = new NNode(-1);
			//tempnode = node.right;
			
			
		}
		
		
		//Right most nodes right siblings are null 
		setRightSiblingDFS(node.left, level+1);
		
		setRightSiblingDFS(node.right, level+1);
		
		
	}
	
	
	/**
	 * Level order of Binary tree using Breadth first Search 
	 * @param node
	 * @param level
	 * working by using peek function
	 */
	static void setRightSiblingBFS(NNode node, int level){
		
		//TODO : add this check as node not equals 
		if(node==null) return ;
		
		Queue<NNode> queue = new LinkedList<NNode>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
		  
		  int size = queue.size();
		  
		  for(int i=0;i<size;i++) {
			  
			  NNode current = queue.remove();
			  
			  //last Node set sibling to null
			  if(i==size-1) {
				  current.sibling = null;
			  }
			  
			  if(level>=1) {
				  NNode nxtNode = queue.peek();
				  current.sibling = nxtNode;
			  }
			  
			  if(current.left!=null) {
				  queue.add(current.left);
			  }
			  
			  if(current.right!=null) {
				  queue.add(current.right);
			  }
			   
		  }
		  
		  level++; 
		
		}
		
	}
	
	
	static void setRightSiblingLinkedList(NNode node, int level){
		
		//TODO : add this check as node not equals 
		if(node==null) return ;
		
		LinkedList<NNode> linkedlist = new LinkedList<NNode>();
		linkedlist.add(node);
		
		while(!linkedlist.isEmpty()) {
		  
		  int size = linkedlist.size();
		  
		  for(int i=0;i<size;i++) {
			  
			  NNode current = linkedlist.remove();
			  
			  //last Node set sibling to null
			  if(i==size-1) {
				  current.sibling = null;
			  }
			  
			  if(level>=1) {
				  //NNode nxtNode = linkedlist.peek();
				  NNode nxtNode = linkedlist.get(i+1);
				  current.sibling = nxtNode;
			  }
			  
			  if(current.left!=null) {
				  linkedlist.add(current.left);
			  }
			  
			  if(current.right!=null) {
				  linkedlist.add(current.right);
			  }
			   
		  }
		  
		  level++; 
		
		}
		
	}
	
	
	

}

class NNode{
	//for testing
	int val;
	NNode left;
	NNode right;
	NNode sibling=null;
	
	NNode(int val, NNode left, NNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	NNode(int val){
		this.val = val;
	}
	
	@Override
	public String toString() {
		//return "Node{\n val:" + val +",\n sibling=" + (sibling==null ? sibling : sibling.val) + ",\n left:" + left + ",\n right:" + right + "}";
		return "{\n\"val\":" + val +",\n\"sibling\":" + (sibling==null ? sibling : sibling.val) + ",\n\"left\":" + left + ",\n\"right\":" + right + "\n}";
	}
	
	
//	NNode(NNode left,NNode right){
//	this.left= left;
//	this.right= right;
//	}
//	
	
}


