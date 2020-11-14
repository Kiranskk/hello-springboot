/**
 * 
 */
package examples;
import java.util.*;

/**
 * @author test
 *
 */
public class BinaryTreeRightSideView2 {

	/** 154/211 test cases passed.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TrNode left = new TrNode(2,null,new TrNode(5));
		
		TrNode right = new TrNode(3,null,new TrNode(4));
		
		TrNode root = new TrNode(1,left,right); 
		
		List<Integer> rightvals = rightSideView(root);	
		
		System.out.println(" Tree Right side view Nodes " + rightvals );
		
		// TEST CASE 2 Input:
		//i/p	[1,2]
		//out put err [1]
		//expected [1, 2]
		
		//TrNode left1 = new TrNode(2,null,new TrNode(5));
		
		TrNode right1 = new TrNode(2,null,null);
		
		TrNode root1 = new TrNode(1,null,right1); 
		
		List<Integer> rightvals1 = rightSideView(root1);	
		
		System.out.println(" Tree Right side view Nodes " + rightvals1 );
		
		System.out.println("--- Test 2 ---");
		
		ArrayList<Integer> expected2 = new ArrayList<Integer>();
		expected2.add(1);
		expected2.add(2);
		
		TrNode left2 = new TrNode(2,null,null);
		
		//TrNode right2 = new TrNode(2,null,null);
		
		TrNode root2 = new TrNode(1,left2,null); 
		
		List<Integer> rightvals2 = rightSideView(root2);	
		
		System.out.println(" Tree Right side view Nodes " + rightvals2 );
		if(expected2.equals(rightvals2)) {
			System.out.println(" Test Passed");
		}else {
			System.out.println(" Test FAILED! expected "+expected2);
		}
		
		System.out.println(" --- Test 3 ---");
		//input [1,2,3,4]
		//output [1,3]
		//expected [1,3,4]
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(3);
		expected.add(4);
		
		TrNode left3 = new TrNode(2,new TrNode(4),null);
		
		TrNode right3 = new TrNode(3,null,null);
		
		TrNode root3 = new TrNode(1,left3,right3); 
		
		List<Integer> rightvals3 = rightSideView(root3);	
		
		System.out.println(" Tree Right side view Nodes " + rightvals3);
		
		if(expected.equals(rightvals3)) {
			System.out.println(" Test Passed");
		}else {
			System.out.println(" Test FAILED! expected "+expected);
		}
		
		
	}

	public static List<Integer> rightSideView(TrNode root) {
		
		ArrayList<Integer>  rightsideview = new ArrayList<Integer>();
		
		if(root==null) return rightsideview;
		
		root.getRightViewNode(rightsideview,0);
		
		return rightsideview;
		
		
//		ArrayList<Integer>  result = new ArrayList<Integer>();
//		
//		if(root!=null) { 
//			root.getRightNode(result);
//		}
//		
//		System.out.println(" Right Side View" +result);
//		
//	return result;
   }
	
}


class TrNode{
	
	int val;
	TrNode left;
	TrNode right;
	
	TrNode(int val) {this.val = val;}
	
	TrNode(int val,TrNode left,TrNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	
	public void getRightViewNode(List<Integer> vals , int level){
		
		if(level==vals.size()) vals.add(this.val);
 		
		if(this.right!=null) {
			this.right.getRightViewNode(vals, level+1);
		}
		
		if(this.left!=null) {
			this.left.getRightViewNode(vals, level+1);
		}
		
	}
	
	
	public TrNode getRightNode(List<Integer> vals){
	
		vals.add(this.val);
		
//		if(this.right!=null) this.right.getRightNode(vals);
//		
//		if(this.left!=null) this.left.getRightNode(vals);
		
		if(this.right == null) {
			
			if(this.left!=null) {
				return this.left.getRightNode(vals);
			}else {
				return null;
			}
		}else {
			
			return this.right.getRightNode(vals);
		}
		
	}
	

}



