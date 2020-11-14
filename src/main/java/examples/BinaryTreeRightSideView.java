/**
 * 
 */
package examples;
import java.util.*;

/**
 * @author test
 *
 */
public class BinaryTreeRightSideView {

	/** 154/211 test cases passed.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode left = new TreeNode(2,null,new TreeNode(5));
		
		TreeNode right = new TreeNode(3,null,new TreeNode(4));
		
		TreeNode root = new TreeNode(1,left,right); 
		
		List<Integer> rightvals = rightSideView(root);	
		
		System.out.println(" Tree Right side view Nodes " + rightvals );
		
		// TEST CASE 2 Input:
		//i/p	[1,2]
		//out put err [1]
		//expected [1, 2]
		
		//TreeNode left1 = new TreeNode(2,null,new TreeNode(5));
		
		TreeNode right1 = new TreeNode(2,null,null);
		
		TreeNode root1 = new TreeNode(1,null,right1); 
		
		List<Integer> rightvals1 = rightSideView(root1);	
		
		System.out.println(" Tree Right side view Nodes " + rightvals1 );
		
		System.out.println("--- Test 2 ---");
		
		ArrayList<Integer> expected2 = new ArrayList<Integer>();
		expected2.add(1);
		expected2.add(2);
		
		TreeNode left2 = new TreeNode(2,null,null);
		
		//TreeNode right2 = new TreeNode(2,null,null);
		
		TreeNode root2 = new TreeNode(1,left2,null); 
		
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
		
		TreeNode left3 = new TreeNode(2,new TreeNode(4),null);
		
		TreeNode right3 = new TreeNode(3,null,null);
		
		TreeNode root3 = new TreeNode(1,left3,right3); 
		
		List<Integer> rightvals3 = rightSideView(root3);	
		
		System.out.println(" Tree Right side view Nodes " + rightvals3);
		
		if(expected.equals(rightvals3)) {
			System.out.println(" Test Passed");
		}else {
			System.out.println(" Test FAILED! expected "+expected);
		}
		
		
	}

	public static List<Integer> rightSideView(TreeNode root) {
		
		ArrayList<Integer>  result = new ArrayList<Integer>();
		
		if(root!=null) { 
			root.getRightNode(result);
		}
		
		System.out.println(" Right Side View" +result);
		
		return result;
    }
	
}


class TreeNode{
	
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val) {this.val = val;}
	
	TreeNode(int val,TreeNode left,TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode getRightNode(List<Integer> vals){
	
		vals.add(this.val);
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



