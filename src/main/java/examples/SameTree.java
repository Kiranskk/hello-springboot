/**
 * 
 */
package examples;

/**
 * @author test Leetcode 100 Given two binary trees, write a function to check
 *         if they are the same or not. Two binary trees are considered the same
 *         if they are structurally identical and the nodes have the same value.
 *         Input: 1 1 / \ / \ 2 3 2 3
 * 
 *         [1,2,3], [1,2,3]
 * 
 *         Output: true
 */
public class SameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean areSame;
		
		/*
		 * Tree t1 = new Tree(4); t1.insert(2); t1.insert(3);
		 * 
		 * Tree t2 = new Tree(4); t2.insert(2); t2.insert(3);
		 * 
		 * boolean areSame = checkUnBalancedTrees(t1, t2);
		 * 
		 * System.out.println("Both unblanced Trees Same? " + areSame);
		 */
		
		
		Tree t3 = new Tree(4);
		t3.insert(2);
		t3.insert(5);

		Tree t4 = new Tree(4);
		t4.insert(2);
		t4.insert(5);

		System.out.println("Checking balanced Trees ");
		
		areSame = checkBalancedTrees(t3, t4);

		System.out.println("Both balanced Trees Same? " + areSame);
		
		//if(areSame) System.out.println("Test case Failed! expected false but actual " + areSame);
		
		
		Tree t5 = new Tree(1);
		t5.insert(2);
		t5.insert(3);

		Tree t6 = new Tree(1);
		t6.insert(2);
		t6.insert(3);

		System.out.println("Checking unbalanced Trees ");
		
		areSame = checkBalancedTrees(t5, t6);

		System.out.println("Both unbalanced Trees Same? " + areSame);
		
		
		

	}

	static boolean checkUnBalancedTrees(Tree t1, Tree t2) {

		if (t1.data == t2.data) {
			System.out.println("Data same checking nodes t1 "+t1.data+" t2 "+t2.data);
			if (t1.left == null && t1.right == null && t2.left == null && t2.right == null) {
				return true;
			} else if (t1.left != null && t2.left != null) {
				System.out.println("checking left nodes");
				//boolean leftSame = checkTrees(t1.left, t2.left);
				return checkUnBalancedTrees(t1.left, t2.left);
				
			} else if (t1.right != null && t2.right != null) {
				System.out.println("checking right nodes");
				//boolean rightSame = checkTrees(t1.right, t2.right);
				return checkUnBalancedTrees(t1.right, t2.right);
			} else {
				return false;
			}

		} 
		else { 
			System.out.println("Data not same returning false"); return false; 
		}
		//return false;

	}
	
	
	static boolean checkBalancedTrees(Tree t1, Tree t2) {

		if (t1.data == t2.data) {
			System.out.println("Data same checking nodes t1 "+t1.data+" t2 "+t2.data);
			if (t1.left == null && t1.right == null && t2.left == null && t2.right == null) {
				return true;
			} else if (t1.left != null && t2.left != null) {
				System.out.println("checking left nodes");
				boolean leftSame = checkBalancedTrees(t1.left, t2.left);
				if(leftSame && t1.right!=null && t2.right!=null) return checkBalancedTrees(t1.right, t2.right);
				return leftSame;
				
			} else if (t1.right != null && t2.right != null) {
				System.out.println("checking right nodes");
				boolean rightSame = checkBalancedTrees(t1.right, t2.right);
				if(rightSame && t1.left!=null && t2.left!=null ) checkBalancedTrees(t1.left, t2.left); 
				return rightSame;
			} else {
				return false;
			}

		} 
		else { 
			System.out.println("Data not same returning false"); return false; 
		}
		//return false;

	}
	
	
	

	/*
	 * static boolean checkdata(Tree t1,Tree t2){
	 * 
	 * if(t1.data==t2.data && t1.left==null && t2.left==null && t1.right==null &&
	 * t2.right==null ) {
	 * System.out.println("Root is same check left and right nodes");
	 * 
	 * 
	 * if(t1.left!=null && t2.left!=null) {
	 * System.out.println("left nodes are not same"); checkdata(t1.left, t2.left);
	 * }else{
	 * 
	 * }
	 * 
	 * if(t1.right!=null && t2.right!=null) {
	 * System.out.println("right nodes are not same"); checkdata(t1.right,
	 * t2.right); }
	 * 
	 * 
	 * return true;
	 * 
	 * }else if(t1.left!=null && t2.left!=null) { checkdata(t1.left, t2.left); }else
	 * if(t1.right!=null && t2.right!=null) { checkdata(t1.right, t2.right); } else
	 * { System.out.println(" Root is not same return false");
	 * 
	 * //checkdata(t1.left, t2.left);
	 * 
	 * 
	 * return false; } return false;
	 * 
	 * }
	 */

}

class Tree {

	int data;
	Tree left;
	Tree right;

	Tree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	void insert(int val) {

		if (val > data) {

			if (right == null) {
				right = new Tree(val);
			} else {
				right.insert(val);
			}

		}

		if (val < data) {

			if (left == null) {
				left = new Tree(val);
			} else {
				left.insert(val);
			}

		}

	}

}
