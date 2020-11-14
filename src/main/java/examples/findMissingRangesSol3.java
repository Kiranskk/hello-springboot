/**
 * 
 */
package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author test
 * Accepted 8ms, 37 MB
 * REfactoring to clean up 
 * Code clean up and readability missing
 *
 */
public class findMissingRangesSol3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	   int[] nums = {0,1,3,50,75}; 
	   int lower = 0; 
	   int upper = 99;
		
		List<String> result = findMissingRanges(nums,lower,upper);
		System.out.println("Result List --> "+result);
		
		
		int[] nums1 = {}; 
		int lower1 = 1; 
		int upper1 = 1;
		//exp1 = ["1"];
		List<String> result1 = findMissingRanges(nums1,lower1,upper1);
		System.out.println("Expected [\"1\"] Result List --> "+result1);
		
		int[] nums2 = {}; 
		int lower2= -3; 
		int upper2 = -1;
		//exp1 = ["-3->-1"];
		List<String> result2 = findMissingRanges(nums2,lower2,upper2);
		System.out.println("Expected [\"-3->-1\"] Result List --> "+result2);
		
		
		int[] nums3 = {-1}; 
		int lower3 = -1; 
		int upper3 = -1;
		//exp1 = [""];
		List<String> result3 = findMissingRanges(nums3,lower3,upper3);
		System.out.println("Expected [\"\"] Result List --> "+result3);
		
		
		int[] nums4 = {-1}; 
		int lower4 = -2; 
		int upper4 = -1;
		//exp1 = ["-2"];
		List<String> result4 = findMissingRanges(nums4,lower4,upper4);
		System.out.println("Expected [\"-2\"] Result List --> "+result4);
		
		
		int[] nums5 = {-1}; 
		int lower5 = -3; 
		int upper5 = -1;
		//exp1 = ["-2"];
		List<String> result5 = findMissingRanges(nums5,lower5,upper5);
		System.out.println("Expected [\"-3->-2\"] Result List --> "+result5);
		
		
		int[] nums6 = {-3}; 
		int lower6 = -3; 
		int upper6 = -1;
		//exp1 = ["-2"];
		List<String> result6 = findMissingRanges(nums6,lower6,upper6);
		System.out.println("Expected [\"-2->-1\"] Result List --> "+result6);
		
		
		int[] nums7 = {-2}; 
		int lower7 = -4; 
		int upper7 = -1;
		//exp1 = ["-2"];
		List<String> result7 = findMissingRanges(nums7,lower7,upper7);
		System.out.println("Expected [\"-4->-3, -1\"] Result List --> "+result7);
		
		
		int[] nums8 = {-1}; 
		int lower8 = -1; 
		int upper8 = 0;
		//exp1 = ["-2"];
		List<String> result8 = findMissingRanges(nums8,lower8,upper8);
		System.out.println("Expected [0] Result List --> "+result8);
		
		int[] nums9 = {1,2}; 
		int lower9 = 0; 
		int upper9 = 9;
		//exp1 = ["-2"];
		List<String> result9 = findMissingRanges(nums9,lower9,upper9);
		System.out.println("Expected [0, 3->9] Result List --> "+result9);
		
		int[] nums10 = {1,2}; 
		int lower10 = -3; 
		int upper10 = 9;
		//exp1 = ["-2"];
		List<String> result10 = findMissingRanges(nums10,lower10,upper10);
		System.out.println("Expected [-3->0, 3->9] Result List --> "+result10);
		
		
		int[] nums11 = {8,9}; 
		int lower11 = 0; 
		int upper11 = 9;
		//exp1 = ["-2"];
		List<String> result11 = findMissingRanges(nums11,lower11,upper11);
		System.out.println("Expected [0->7] Result List --> "+result11);
		
		
	}
	
	// formats range in the requested format
    static String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        } else {
            return lower + "->" + upper;
        }
    }
	
	
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
  
		int n = nums.length;
		
		if (n == 0) {
            return Collections.singletonList(formatRange(lower, upper));
        }
		
		List<String> missingRanges = new ArrayList<>();
		
		 // Edge case 1) Missing ranges at the beginning
        if (nums[0] > lower) {
            missingRanges.add(formatRange(lower, nums[0] - 1));
        }
		
     // Missing ranges between array elements
        for (int i = 1; i < n; ++i) {
            if (nums[i] - nums[i - 1] > 1) {
                missingRanges.add(formatRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        
		
     // Edge case 2) Missing ranges at the end
        if (nums[n - 1] < upper) {
            missingRanges.add(formatRange(nums[n - 1] + 1, upper));
        }  
        
		return missingRanges;
		
		
		
		
		
		
//		List<String> result = new ArrayList<String>();
//		
//		//1. Base Case empty list, return list
//		if(nums==null || nums.length ==0 ) {
//			
//			if(lower==upper) {
//				result.add(""+lower);
//				return result;
//			}else {
//				result.add(""+(lower)+"->"+(upper));
//				return result;
//			}
//		}
//		
//		//2. single element, negative ranges
//		
//		if(nums.length ==1 && upper>lower && upper!=0 && upper-lower==1) {
//			//result.add(""+(nums[0]-1));
//			result.add(""+(lower));
//			return result;
//		}
//		
//		//3. single element wide ranges , cleaning up 1->1 as a single method frees up lot of lines
//		if(nums.length ==1 && upper-lower>1) {
//			if(nums[0]==lower) {
//				result.add(""+(lower+1)+"->"+(upper));
//			}else if(nums[0]==upper) {
//				result.add(""+(lower)+"->"+(upper-1));
//			}
//			else {
//				if((nums[0]-1)==lower) {
//					result.add(""+(nums[0]-1));
//				}else {
//					result.add(""+lower+"->"+(nums[0]-1));
//				}
//				
//				if((nums[0]+1)==upper) {
//					result.add(""+(nums[0]+1));
//				}else {
//					result.add(""+(nums[0]+1)+"->"+(upper));	
//				}
//			}
//			return result;
//		}
//		
//		int start =0;
//		int end =0;
//		
//		//4. main logic comparing adjacent numbers
//		
//		int len = nums.length;
//		
//		for(int i=0;i<=nums.length-1;i++) {
//			
//			start = nums[i];
//			end = i<len-1? nums[i+1] : upper+1;
//			
//			if(i==0&&lower<start && lower==0 && start-lower==1) {
//				result.add(""+(lower));
//			}
//			
//			if(i==0&&lower<start && lower==0 && start-lower>1) {
//				result.add(""+(lower)+"->"+(start-1));
//			}
//			
//			if(i==0&&lower<start && lower<0) {
//				result.add(""+(lower)+"->"+(start-1));	
//			}
//			
//			if(lower<=nums[i] && nums[i]<=upper && end-start>1) {
//				//missing
//				
//				if((start+1)==(end-1)) {
//					result.add(""+(start+1));
//				}else{
//					result.add(""+(start+1)+"->"+(end-1));	
//				}
//				
//				
//			}
//			else {
//				continue;
//			}
//			
//			
//		}
//		
//		//System.out.println("Result List "+result); 
//		
//		return result;
	 }

}
