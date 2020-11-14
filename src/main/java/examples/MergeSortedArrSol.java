/**
 * 
 */
package examples;

/**
 * @author test
 *
 */
public class MergeSortedArrSol {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		int[] nums1 = {-1,3,0,0,0,0,0};//m
		int[] nums2 = {0,0,1,2,3};//n
		
		int[] expectedArr = {-1,0,0,1,2,3,3};
		
		merge(nums1, 2, nums2, 5);
		
		System.out.println("merged array answer");
		//boolean issuccess = false;
		for (int i = 0; i < nums1.length; i++) {
			if(nums1[i]!=expectedArr[i]) {
				System.out.println("Test case Failed not matching to expected");
				//System.out.println("Test case Passed");
			}else{
				//System.out.println("Test case Passed");
				//issuccess = true;
			}
			System.out.println(nums1[i]);
		}
		
		

	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
	    // Make a copy of nums1.
	    int [] nums1_copy = new int[m];
	    System.arraycopy(nums1, 0, nums1_copy, 0, m);

	    // Two get pointers for nums1_copy and nums2.
	    int p1 = 0;
	    int p2 = 0;

	    // Set pointer for nums1
	    int p = 0;

	    // Compare elements from nums1_copy and nums2
	    // and add the smallest one into nums1.
	    while ((p1 < m) && (p2 < n))
	      nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

	    // if there are still elements to add
	    if (p1 < m)
	      System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
	    if (p2 < n)
	      System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
	  }
	
	
	
	

}
