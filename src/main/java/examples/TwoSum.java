/**
 * 
 */
package examples;

import java.util.HashMap;

/**
 * @author test
 *
 */
public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int nums1[] = {2,7,11,15};	
	int result[] = twoSum(nums1, 9);
		
	for (int i = 0; i < result.length; i++) {
		System.out.println(result[i]);
	}
	
	
	int nums2[] = {3,2,4};	
	int result2[] = twoSum(nums2, 6);
	
	System.out.println("----");
	
	for (int i = 0; i < result2.length; i++) {
		System.out.println(result2[i]);
	}
	
	
	
	}
	
	
	 public static int[] twoSum(int[] nums, int target) {
	     
		 HashMap<Integer,Integer> store = new HashMap<Integer,Integer>();
		 
		 for(int i=0;i<nums.length;i++) {
			 if(nums[i]<target) {
				 store.put(nums[i],i); 
			 }
		 }
		 
		 for(int i=0;i<nums.length;i++) {
			 int complement = target - nums[i];
			 if(store.containsKey(complement) && store.get(complement) != i) {
				 return new int[] {i, store.get(complement)};
			 }
		 }
		return null;
		 
	    }

}
