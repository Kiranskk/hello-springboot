/**
 * 
 */
package examples;

/**
 * @author test LeetCode 88
 *
 */
public class MergeSortedArrayFull {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long startime5 = System.currentTimeMillis();

		// leetcode test data 2
		
		int[] oddFromArr4 = {-1,1,1,1,2,3};//n 6
		int[] evenToArr4 = {0,0,3,0,0,0,0,0,0};//m 3
		
		int[] expectedArr4 = {-1,0,0,1,1,1,2,3,3};
		
		callMerge(oddFromArr4,6,evenToArr4,3,expectedArr4);

		
		int[] oddFromArr5 = {1, 3, 5, 7, 9};
		int[] evenToArr5 = {2, 4, 6, 8, 10, 0, 0, 0, 0, 0};
		
		int[] expectedArr5 = {1,2,3,4,5,6,7,8,9,10};
		
		callMerge(oddFromArr5,5,evenToArr5,5,expectedArr5);
		
		
		int[] oddFromArr6 = {1, 2, 5, 8, 9};
		int[] evenToArr6 = {2, 4, 6, 8, 10, 0, 0, 0, 0, 0};
		
		int[] expectedArr6 = {1,2,2,4,5,6,8,8,9,10};
		
		callMerge(oddFromArr6,5,evenToArr6,5,expectedArr6);
		
		int[] oddFromArr7 = { 2, 5, 6};
		int[] evenToArr7 = {1, 2, 3, 0, 0, 0};
		int[] expectedArr7 = {1,2,2,3,5,6};
		
		callMerge(oddFromArr7,3,evenToArr7,3,expectedArr7);
		
		System.out.println("total time " + (System.currentTimeMillis() - startime5));
		
		
		int[] oddFromArr8 = { 2, 5, 6};
		int[] evenToArr8 = {1, 7, 8, 0, 0, 0};
		int[] expectedArr8 = {1,2,5,6,7,8};
		
		callMerge(oddFromArr8,3,evenToArr8,3,expectedArr8);
		
		
		int[] oddFromArr9 = {1};
		int[] evenToArr9 = {0};
		int[] expectedArr9 = {1};
		
		callMerge(oddFromArr9,1,evenToArr9,0,expectedArr9);
		
		
		int[] oddFromArr10 = {4,5,6};
		int[] evenToArr10 = {1,2,3,0,0,0};
		int[] expectedArr10 = {1,2,3,4,5,6};
		
		//callMerge(oddFromArr10,evenToArr10,expectedArr10);
		
		
		int[] oddFromArr11 = {1,2,3,4,5,6};
		int[] evenToArr11 = {0,0,0,0,0,0};

		int[] expectedArr11 = {1,2,3,4,5,6};
		
		callMerge(oddFromArr11,6,evenToArr11,0,expectedArr11);
		
		System.out.println("-- 42 test case --");//(j>m) passed
		int[] oddFromArr12 = {1,2,3,5,6};
		int[] evenToArr12 = {4,0,0,0,0,0};

		int[] expectedArr12 = {1,2,3,4,5,6};
		
		callMerge(oddFromArr12,5,evenToArr12,1,expectedArr12);

		System.out.println("-- 43 test case --");//(j>m) failed
		int[] oddFromArr13 = {2,3,4,5,6};
		int[] evenToArr13 = {1,0,0,0,0,0};

		int[] expectedArr13 = {1,2,3,4,5,6};
		
		callMerge(oddFromArr13,5,evenToArr13,1,expectedArr13);
		
		System.out.println("-- 37 test case --");//(j>m)passed
		int[] oddFromArr14 = {0,0,1,2,3};
		int[] evenToArr14 = {-1,3,0,0,0,0,0};

		int[] expectedArr14 = {-1,0,0,1,2,3,3};
		
		callMerge(oddFromArr14,5,evenToArr14,2,expectedArr14);

	}

	/**
	 * 
	 * @param FromArr n
	 * @param ToArr m
	 * @param expectedArr
	 */
	private static void callMerge(int [] FromArr,int n, int [] ToArr,int m, int[] expectedArr) {
		
		// int indx=0;
		//merge(FromArr, FromArr.length, ToArr, ToArr.length - FromArr.length);
		// movevalsfwd(evenarr, indx);
		
		//mergeSol(ToArr, m, FromArr, n);
		//mergeSolFor(ToArr, m, FromArr, n);
		
		mergeFromBckP1(ToArr, m, FromArr, n);

		System.out.println("merged array answer");
		//boolean issuccess = false;
		for (int i = 0; i < ToArr.length; i++) {
			if(ToArr[i]!=expectedArr[i]) {
				System.out.println("Test case Failed not matching to expected");
				//System.out.println("Test case Passed");
			}else{
				//System.out.println("Test case Passed");
				//issuccess = true;
			}
			System.out.println(ToArr[i]);
		}
	}
	
	/**
	 * Real Solution
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void mergeSol(int[] nums1, int m, int[] nums2, int n) {
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
	
	public static void mergeSolFor(int[] nums1, int m, int[] nums2, int n) {
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
	
	public static void mergeFromBckP1(int[] nums1, int m, int[] nums2, int n) {
	       
		//nums1  m p1 
		//nums2  n p2
		//last index p
		//1. if p1 > p2, move p1 val to last and move p and p1 
		//2.else p1 < p2 , put p2 to p index and move p and p2
		
		int p = m+n-1;
		int p1=m-1;
		int p2=n-1;
		
		
		for(;p1>=0 && p2>=0;) {
			
			if(nums1[p1]<nums2[p2]) {
				nums1[p--] = nums2[p2--];
			}else {
				nums1[p--] = nums1[p1--];
			}
			
		}
		
//		 while ((p1 >= 0) && (p2 >= 0))
//			 nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
		
		//System.arraycopy(nums2, 0, nums1, 0, p2+1);
		
		 for(int i=0;i<p2+1;i++) { 
			  nums1[i] = nums2[i]; 
		  }
		 
		
		
	}
	

	/**
	 * merge arr1 into arr2
	 * 
	 * @param fromArr
	 * @param toArr
	 * @return
	 */
	static void merge(int[] fromArr, int fromArrlen, int[] toArr, int toArrlen) {

		for (int i = 0; i <= fromArr.length - 1; i++) {
			// System.out.println(" oddarr["+i+"]"+ arr1[i]);
			for (int j = 0; j <= toArr.length - 1; j++) {
				// System.out.println(" evenarr["+j+"]"+ arr2[j]);
				if (fromArr[i] <= toArr[j] ) {//&& toArr[j] != 0
					movevalsfwd(toArr, j,fromArrlen+toArrlen);//j toArrlen
					insertval(toArr, j, fromArr[i]);
					break;
				}else if(fromArr[i] > toArr[j] && j>=fromArrlen && toArr[j] == 0) {
					insertval(toArr, j, fromArr[i]);
					break;
				}else if(fromArr[i] > toArr[j] && j>toArrlen && toArr[j] == 0) {//w
					insertval(toArr, j, fromArr[i]);
					break;
				}else if(fromArr[i] > toArr[j] && fromArrlen==1 && toArr[j] == 0) {
					insertval(toArr, j, fromArr[i]);
					break;
				}else if(fromArr[i] > toArr[j] && toArrlen==0 && toArr[j] == 0) {
					insertval(toArr, j, fromArr[i]);
					break;
				}else if(fromArr[i] > toArr[j] && toArrlen==1) {//t43 failed all 8/59
					//insertval(toArr, j+1, fromArr[i]);
					for(int k=1;k<fromArrlen-1;k++) {
						toArr[k]=fromArr[i];
						i=k;
					}
					break;
				}else {
					continue;
					//System.out.println("--else--");
				}
				
				
				
				
//				else if(fromArr[i] > toArr[j] && j >= toArrlen - 1 && toArr[j] == 0) {
//					insertval(toArr, j, fromArr[i]);
//					break;
//				}else {
//					continue;
//				}
				
//				else {
//					insertval(toArr, j, fromArr[i]);
//					break;
//				}
				
//				if (fromArr[i] < toArr[j] && j<toArrlen-1) {
//					// System.out.println(" oddarr["+i+"]"+ arr1[i]+" < evenarr["+j+"]"+arr2[j]);
//					movevalsfwd(toArr, toArrlen);
//					insertval(toArr, j, fromArr[i]);
//					break;
//				}
				
				//this new case
				 //if(fromArr[i] > toArr[j] && j >= toArrlen - 1 && toArr[j] == 0){
				 //movevalsfwd(toArr, j,fromArrlen+toArrlen);
				 //insertval(toArr, j, fromArr[i]);
				// break; 
				 //}
				

			}

		}

	}

	static void movevalsfwd(int[] arr, int endindex, int startindex) {
		// System.out.println(" moving vals fwd from "+fromindex);
		
		for(int i = startindex-2; i>=endindex; i--) {
			arr[i + 1] = arr[i];
		}
			
		
		//for (int i = arr.length - 1; i >= fromindex; i--) {
			//if (arr[i] != 0) {
				// System.out.println(" moving["+i+"] "+arr[i]+" to ["+(i+1)+"]"+arr[i+1]);
			//	arr[i + 1] = arr[i];
				// System.out.println(" moved val["+(i+1)+"] "+arr[i+1]);
			//}
			
		}

		/*
		 * System.out.println(" moved array vals"); for (int i = 0; i < arr.length; i++)
		 * { System.out.println("["+i+"]"+arr[i]); }
		 */

	static void insertval(int[] arr, int index, int val) {
		// System.out.println("inserting at index "+index+ " val "+val);
		arr[index] = val;

		// System.out.println(" inserted array vals");
		/*
		 * for (int i = 0; i < arr.length; i++) { System.out.println("["+i+"]"+arr[i]);
		 * }
		 */

	}

}
