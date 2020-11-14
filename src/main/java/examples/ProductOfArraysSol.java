/**
 * 
 */
package examples;

import java.util.Arrays;
import java.util.List;

/**
 * @author test
 *
 */
public class ProductOfArraysSol {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4};
		int outputarr[] = {24,12,8,6};
		
		int[] resultarr = productExceptSelf2(arr);
		
		System.out.println("Ans arr ");
		
		for (int i = 0; i < resultarr.length; i++) {
			System.out.println("["+i+"]="+resultarr[i]);
			
			if(outputarr[i]!=resultarr[i]) {
				System.out.println("TEst Failed ["+i+"]="+resultarr[i]);
			}
			
		}
		
	}
	
	public static int[] productExceptSelf(int[] nums) {
	
		int L [] = new int [nums.length];
		int R [] = new int [nums.length];
		
		L[0] = 1;
		R[nums.length-1] = 1;
		
		int ans [] = new int [nums.length];
		
		for(int i=1;i<nums.length;i++) {
			L[i] = nums[i-1] * L[i-1];
		}
		
		System.out.println("Left arr ");
		
		for (int i = 0; i < L.length; i++) {
			System.out.println("["+i+"]="+L[i]);
		}
		
		
		for(int i=nums.length-2;i>=0;i--) {
			R[i] = nums[i+1] * R[i+1];
		}
		
		System.out.println("Right arr ");
		
		for (int i = 0; i < R.length; i++) {
			System.out.println("["+i+"]="+R[i]);
		}
		
		
		for (int i = 0; i < nums.length; i++) {
			
			ans[i] = L[i]*R[i];
			
		}
		
		return ans;
	   }
	
	
	public static int[] productExceptSelf2(int[] nums) {
		
		int[] ans = new int[nums.length];
		
		ans[0] =1;
		
		for(int i=1;i<nums.length;i++) {
			
			ans[i] = nums[i-1]*ans[i-1];
		}
		
		System.out.println("Left arr ");
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println("["+i+"]="+ans[i]);
		}
		
		int R = 1;
		
		for(int i=nums.length-1;i>=0;i--) {
			
			ans[i] = ans[i]*R;
			R*=nums[i];
		}
		
		
		return ans;
		
	   }
	
	

}
