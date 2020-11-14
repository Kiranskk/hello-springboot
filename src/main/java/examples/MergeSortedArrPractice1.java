/**
 * 
 */
package examples;

/**
 * @author test
 * nums1 m
 * nums2 n
 * merge nums2 into nums1
 */
public class MergeSortedArrPractice1 {

	public static void main(String[] args) {
	
		int nums1[] = {1,2,3,0,0}; 
		int m=3;
		int nums2[] = {4,5};
		int n=2;
	
		int expected[] = {1,2,3,4,5};
		
		//mergeNoCpy(nums1, m, nums2, n);
		
		mergeFromBckP1(nums1, m, nums2, n);
		
		for(int i =0;i<nums1.length;i++) {
			System.out.println(nums1[i]);
			if(nums1[i]!=expected[i]) System.out.println("Test case failed actual not match with expected");
		}
		
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums1_copy = new int[m];
		System.arraycopy(nums1, 0, nums1_copy, 0, m);
		
		int p=0;
		int p1=0;
		int p2=0;
		
		for(p1=0,p2=0;p1<m && p2<n;) {
			
			nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++] ;
			
			
//			if(nums1_copy[p1] < nums2[p2]) {
//				nums1[p] = nums1_copy[p1];
//				p1++;
//				p++;
//			}else {
//				nums1[p] = nums2[p2];
//				p2++;
//				p++;
//			}
			
		}
		
		if(p1 < m) {
			System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
		}
		
		if(p2 < n) {
			System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
		}
		
	}
	
	public static void mergeNoCpy(int[] nums1, int m, int[] nums2, int n) {
        int [] nums1_copy = new int[m];
		//System.arraycopy(nums1, 0, nums1_copy, 0, m);
		
		for(int i=0;i<m;i++) nums1_copy[i] = nums1[i];
		
		int p=0;
		int p1=0;
		int p2=0;
		
		for(p1=0,p2=0;p1<m && p2<n;) {
			
			nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++] ;
			
			
//			if(nums1_copy[p1] < nums2[p2]) {
//				nums1[p] = nums1_copy[p1];
//				p1++;
//				p++;
//			}else {
//				nums1[p] = nums2[p2];
//				p2++;
//				p++;
//			}
			
		}
		
		for (;p1 < m; p1++,p++) nums1[p] = nums1_copy[p1];
		for (;p2 < n; p2++,p++)nums1[p] = nums2[p2];
		
		
//		  if(p1 < m) { 
//			  System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 -p2); 
//		   }
//		  
//		  if(p2 < n) { 
//			  System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2); 
//		  }
//		 
		
	}
	
	
	public static void mergeFromBck(int[] nums1, int m, int[] nums2, int n) {
        int [] nums1_copy = new int[m];
		//System.arraycopy(nums1, 0, nums1_copy, 0, m);
		
		for(int i=0;i<m;i++) nums1_copy[i] = nums1[i];
		
		int p=0;
		int p1=0;
		int p2=0;
		
		for(p1=0,p2=0;p1<m && p2<n;) {
			
			nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++] ;
			
			
//			if(nums1_copy[p1] < nums2[p2]) {
//				nums1[p] = nums1_copy[p1];
//				p1++;
//				p++;
//			}else {
//				nums1[p] = nums2[p2];
//				p2++;
//				p++;
//			}
			
		}
		
		for (;p1 < m; p1++,p++) nums1[p] = nums1_copy[p1];
		for (;p2 < n; p2++,p++)nums1[p] = nums2[p2];
		
		
//		  if(p1 < m) { 
//			  System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 -p2); 
//		   }
//		  
//		  if(p2 < n) { 
//			  System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2); 
//		  }
//		 
		
	}
	
	
	/**
	 * algo with out temp arr
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void mergeFromBckP1(int[] nums1, int m, int[] nums2, int n) {
       
		//nums1  m p1 
		//nums2  n p2
		//last index p
		//1. if p1 > p2, move p1 val to last and move p and p1 
		//2.else p1 < p2 , put p2 to p index and move p and p2
		
		int p = m+n-1;
		int p1=m-1;
		int p2=n-1;
		
		
		for(;p1>=0 && p2>=0;p--) {
			
			if(nums1[p1]>nums2[p2]) {
				nums1[p] = nums1[p1];
				p1--;
			}else {
				nums1[p] = nums2[p2];
				p2--;
			}
			
		}
		
		
	}
	
	
}
