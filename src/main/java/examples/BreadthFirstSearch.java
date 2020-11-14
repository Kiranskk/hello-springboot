/**
 * 
 */
package examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author test
 *
 */
public class BreadthFirstSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TreNode left = new TreNode(2,new TreNode(4),new TreNode(5));
		
		TreNode right = new TreNode(3,new TreNode(6),new TreNode(7));
		
		TreNode root = new TreNode(1,left,right); 
		
		ArrayList<Integer> result =  new ArrayList<Integer>();
		
		result = traverseBFS(root,result);
		
		System.out.println(" Breadth First Search view Nodes " + result );
		
		
		ArrayList<Integer> resultdfs =  new ArrayList<Integer>();
		
		traverseDFS(root,resultdfs);
		
		System.out.println(" Depth First Search view Nodes " + resultdfs );
		
		
		
	}
	
	/**
	 * Using Queue
	 * 1. Add node to Queue
	 * 2. 
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> traverseBFS(TreNode root,ArrayList<Integer> result){
		
		
		Queue<TreNode> queue =  new LinkedList<TreNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			TreNode node = queue.remove();
			//System.out.println(node.val);
			result.add(node.val);
			
			if(node.left!=null) {
				queue.add(node.left);
			}
			
			if(node.right!=null) {
				queue.add(node.right);
			}
			
		}
		
		return result;
	}
	
	
	/**
	 * Using Recursion
	 * 1. PRE Order traversal
	 * 2. 
	 * @param root
	 * @return
	 */
	public static void traverseDFS(TreNode node,ArrayList<Integer> result){
		
		if(node == null) return; 
		result.add(node.val);
		
		traverseDFS(node.left, result);
		traverseDFS(node.right, result);
		
	}
	
	
	
}

class TreNode{
	
	int val;
	TreNode left;
	TreNode right;
	
	
	TreNode(int val){
		this.val= val;
	}
	
	TreNode(int val,TreNode left,TreNode right){
		this.val= val;
		this.left = left;
		this.right = right;
	}
	
	
	
	
}
