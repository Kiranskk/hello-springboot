/**
 * 
 */
package examples;

/**
 * @author test LeetCode 88
 *
 */
public class MergeSortedArray88 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long startime5 = System.currentTimeMillis();

		// leetcode test data 2
		int[] oddFromArr4 = {-1,1,1,1,2,3};//6
		int[] evenToArr4 = {0,0,3,0,0,0,0,0,0};
		//3
		
		//expected [-1,0,0,1,1,1,2,3,3]
		
		// int indx=0;
		merge(oddFromArr4, oddFromArr4.length, evenToArr4, evenToArr4.length - oddFromArr4.length);
		// movevalsfwd(evenarr, indx);

		System.out.println("merged array answer");
		for (int i = 0; i < evenToArr4.length; i++) {
			System.out.println(evenToArr4[i]);
		}

		System.out.println("total time " + (System.currentTimeMillis() - startime5));
		
		
		
//		long startime = System.currentTimeMillis();
//
//		// leetcode test data
//		int[] oddFromArr = { 1, 3, 5, 7, 9 };
//		int[] evenToArr = {  2, 4, 6, 8, 10, 0, 0, 0, 0, 0};
//
//		merge(oddFromArr, oddFromArr.length, evenToArr, evenToArr.length - oddFromArr.length);
//		
//		System.out.println("merged array answer");
//		for (int i = 0; i < evenToArr.length; i++) {
//			System.out.println(evenToArr[i]);
//		}
//
//		System.out.println("total time " + (System.currentTimeMillis() - startime));
//		
//		
//		long startime1 = System.currentTimeMillis();
//
//		// leetcode test data
//		int[] oddFromArr1 = { 1, 2, 5, 8, 9 };
//		int[] evenToArr1 = { 2, 4, 6, 8, 10, 0, 0, 0, 0, 0  };
//
//		
//		merge(oddFromArr1, oddFromArr1.length, evenToArr1, evenToArr1.length - oddFromArr1.length);
//		
//		System.out.println("merged array answer");
//		for (int i = 0; i < evenToArr1.length; i++) {
//			System.out.println(evenToArr1[i]);
//		}
//
//		System.out.println("total time " + (System.currentTimeMillis() - startime1));
//		
//		
//		
//		long startime3 = System.currentTimeMillis();
//
//		// leetcode test data
//		int[] oddFromArr2 = { 2, 5, 6 };
//		int[] evenToArr2 = { 1, 2, 3, 0, 0, 0 };
//
//		
//		merge(oddFromArr2, oddFromArr2.length, evenToArr2, evenToArr2.length - oddFromArr2.length);
//		
//
//		System.out.println("merged array answer");
//		for (int i = 0; i < evenToArr2.length; i++) {
//			System.out.println(evenToArr2[i]);
//		}
//
//		System.out.println("total time " + (System.currentTimeMillis() - startime3));
//
//		
//		long startime4 = System.currentTimeMillis();
//
//		// leetcode test data 2
//		int[] oddFromArr3 = { 1,2,2 };
//		int[] evenToArr3 = {-1,0,0,3,3,3,0,0,0};
//		//expected [-1,0,0,1,2,2,3,3,3]
//		
//		
//		merge(oddFromArr3, oddFromArr3.length, evenToArr3, evenToArr3.length - oddFromArr3.length);
//		
//
//		System.out.println("merged array answer");
//		for (int i = 0; i < evenToArr3.length; i++) {
//			System.out.println(evenToArr3[i]);
//		}
//
//		System.out.println("total time " + (System.currentTimeMillis() - startime4));

		
		
		
		
		

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
			// System.out.println(" fromArr["+i+"]"+ fromArr[i]);
			for (int j = 0; j <= toArr.length - 1; j++) {
				// System.out.println(" toArr["+j+"]"+ toArr[j]);
				if (fromArr[i] < toArr[j] ) {//&& j<fromArrlen-1 && toArr[j] != 0 && toArr[j] != 0
					// System.out.println(" fromArr["+i+"]"+ fromArr[i]+" < toArr["+j+"]"+toArr[j]);
					movevalsfwd(toArr, j,toArrlen);
					insertval(toArr, j, fromArr[i]);
					break;
				}

				if (fromArr[i] > toArr[j] && j >= toArrlen - 1 && toArr[j] == 0) {
					movevalsfwd(toArr, j,toArrlen);
					insertval(toArr, j, fromArr[i]);
					break;
				}
				//new case--failing
				//if (fromArr[i] > toArr[j] && j < toArrlen - 1 && toArr[j] == 0) {
				//movevalsfwd(toArr, j,toArrlen); insertval(toArr, j, fromArr[i]); break; 
				//}
				
				

			}

		}

	}

	static void movevalsfwdold(int[] arr, int fromindex) {
		// System.out.println(" moving vals fwd from "+fromindex);
		for (int i = arr.length - 1; i >= fromindex; i--) {
			if (arr[i] != 0) {
				// System.out.println(" moving["+i+"] "+arr[i]+" to ["+(i+1)+"]"+arr[i+1]);
				arr[i + 1] = arr[i];
				// System.out.println(" moved val["+(i+1)+"] "+arr[i+1]);
			}
		}

		/*
		 * System.out.println(" moved array vals"); for (int i = 0; i < arr.length; i++)
		 * { System.out.println("["+i+"]"+arr[i]); }
		 */
	}
	
	static void movevalsfwd(int[] arr, int fromindex,int toArrlen) {
		// System.out.println(" moving vals fwd from "+fromindex);
		for (int i = arr.length - 1; i >= fromindex; i--) {
			if (arr[i] != 0 ) {//arr[i] != 0 || i<toArrlen-1
				// System.out.println(" moving["+i+"] "+arr[i]+" to ["+(i+1)+"]"+arr[i+1]);
				arr[i + 1] = arr[i];
				// System.out.println(" moved val["+(i+1)+"] "+arr[i+1]);
			} 
			else if(arr[i] == 0 && i<toArrlen){
				  System.out.println("--arr "+i+" = "+arr[i]); 
				  arr[i + 1] = arr[i]; 
			}else {
				System.out.println("--dead code--"); 
				continue;
				  
			}
				 
		}

		/*
		 * System.out.println(" moved array vals"); for (int i = 0; i < arr.length; i++)
		 * { System.out.println("["+i+"]"+arr[i]); }
		 */
	}

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
