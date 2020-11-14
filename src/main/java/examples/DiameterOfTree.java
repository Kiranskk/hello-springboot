/**
 * 
 */
package examples;

/**
 * @author test
 *
 */
public class DiameterOfTree {

	/**
	 * @param args
	 */
	
	static int number_of_nodes;
	
	public static void main(String[] args) {
	
		TreNode1 left = new TreNode1(2,new TreNode1(4),new TreNode1(5));
		
		TreNode1 right = new TreNode1(3,new TreNode1(6),new TreNode1(7));
		
		TreNode1 root = new TreNode1(1,left,right); 
		
		int result = diameterOfBinaryTree(root);
		System.out.println(" Diameter of tree "+result); 
		
	}
	
	
	public static int diameterOfBinaryTree(TreNode1 root) {
		number_of_nodes = 1;
		depth(root);
		return number_of_nodes-1;
    }
	
	
	public static int depth(TreNode1 node) {
        
		if(node==null) { return 0; }
		
		int leftDepth = depth(node.left);
		int rightDepth = depth(node.right);
		
		number_of_nodes = Math.max(number_of_nodes,leftDepth+rightDepth+1);
		
		return Math.max(leftDepth,rightDepth)+1;
    }
	

}

class TreNode1{
	
	int val;
	TreNode1 left;
	TreNode1 right;
	
	
	TreNode1(int val){
		this.val= val;
	}
	
	TreNode1(int val,TreNode1 left,TreNode1 right){
		this.val= val;
		this.left = left;
		this.right = right;
	}
	
	
	
	
}