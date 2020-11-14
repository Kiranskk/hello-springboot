/**
 * 
 */
package examples;

/**
 * @author test LeetCode 88
 *
 */
public class MergeSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr1 = { 1, 3, 5, 7, 9 };
		int[] arr2 = { 2, 4, 6, 8, 10, 0, 0, 0, 0, 0 };

		// expected out put to put arr1 into arr2
		// int[] arr2 = {1,2,3,4,5,6,7,8,9,10};

		/**
		 * 1. check the value 2. move the existing vals 3. insert value
		 */

		long startime = System.currentTimeMillis();
		
		merge(arr1, arr2);

		System.out.println("merged array ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		System.out.println("total time "+(System.currentTimeMillis()-startime));
		
		long startime2 = System.currentTimeMillis();
		
		// duplicates
		int[] oddarr1 = { 1, 2, 5, 8, 9 };
		int[] evenarr1 = { 2, 4, 6, 8, 10, 0, 0, 0, 0, 0 };

		// int indx=0;
		merge(oddarr1, evenarr1);
		// movevalsfwd(evenarr, indx);

		System.out.println("merged array with Duplicates");
		for (int i = 0; i < evenarr1.length; i++) {
			System.out.println(evenarr1[i]);
		}

		System.out.println("total time "+(System.currentTimeMillis()-startime2));
		
	}

	/**
	 * merge arr1 into arr2
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	static void merge(int[] arr1, int[] arr2) {

		for (int i = 0; i <= arr1.length - 1; i++) {
			// System.out.println(" oddarr["+i+"]"+ arr1[i]);
			for (int j = 0; j < arr2.length - 1; j++) {
				// System.out.println(" evenarr["+j+"]"+ arr2[j]);
				if (arr1[i] < arr2[j] && arr2[j] != 0) {
					// System.out.println(" oddarr["+i+"]"+ arr1[i]+" < evenarr["+j+"]"+arr2[j]);
					movevalsfwd(arr2, j);
					insertval(arr2, j, arr1[i]);
					break;
				}

			}

		}

	}

	static void movevalsfwd(int[] arr, int fromindex) {
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
