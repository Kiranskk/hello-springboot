/**
 * 
 */
package examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author test
 * 238. Product of Array Except Self
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {1,2,3,4};
		int outputarr[] = {24,12,8,6};
		
		int[] resultarr = productExceptSelf(arr);
		

	}
	
	
	public static int[] productExceptSelf(int[] nums) {
		
		if(nums==null || nums.length==0) return null;
		
		int res[] = new int[nums.length];
		
		HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		List list = null;
		
		for(int i=0;i<=nums.length-1;i++) {
			if(map.isEmpty()) {
				list = new ArrayList<Integer>();
				list.add(nums[i]);
				map.put(i, list);
			}else {
				List fulllist = new ArrayList<Integer>();
				fulllist.addAll(map.get(i-1));
				fulllist.add(nums[i]);
				map.put(i, fulllist);
			}
		}
		
		System.out.println(" final map "+map);
		
		//TODO: need to add logic
		
//		Set<Integer> keys = map.keySet();
//		
//		HashMap<Integer,List<Integer>> finalmap = new HashMap<Integer,List<Integer>>();
//		
//		for(int i=0;i<=nums.length-1;i++) {
//			List finallist = new ArrayList<Integer>();
//			for (Integer key : keys) {
//			     if(key!=i) {
//			    	 finallist.addAll(map.get(key));
//			    	 finalmap.put(i, finallist );
//			     }
//			}
//			
//		}
//		
//		System.out.println("full  final map "+finalmap);
		
		
        return null;
    }
	
	

}
