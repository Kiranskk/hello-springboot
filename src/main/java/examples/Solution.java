package examples;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("  Trying binary search Tree ");

		Node root = new Node(6); 
		
		/*
		 * root.insert(2);
		 * 
		 * root.insert(1);
		 * 
		 * root.insert(9);
		 * 
		 * root.insert(9);
		 */
		System.out.println("insert Node 2 ");
		root.insert(2);
		System.out.println("insert Node 2 .1 ");
		root.insert(2);
		System.out.println("insert Node 2 .2 ");
		root.insert(2);
		System.out.println("insert Node 2 .3 ");
		root.insert(2);
		
		System.out.println("Root Node "+ root.toString());
	}
}

class Node{
	
	int data;
	Node left;
	Node right;
	
	Node(int val){
		this.data = val;
		this.left = null;
		this.right = null;
	}
	
	
	void insert(int val){
		
		if(val<data) {
			
			if(left==null) {
				System.out.println("--left is null ---");
				left= new Node(val);
			}else {
				System.out.println("--left is not null  ---");
				left.insert(val);	
			}
			
			
		}else
		//only else create duplicates in tree
		//if(val>data){
			
			if(right==null) {
				System.out.println("--right is null ---");
				right = new Node(val);
			}else {
				System.out.println("--right is not null ---");
				right.insert(val);	
			}
			
		//} 
		/*
			 * else { System.out.println("--value is equal to cureent node value ---"); }
			 */
		
		
	}
	
	
	public String toString(){
		return "data "+data+" left Node "+left+" right Node "+right;
	}
	
	
}
