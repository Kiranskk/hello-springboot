/**
 * 
 */
package examples;

/**
 * @author test
 *
 */
public class Solution8842 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void merge(int[] toArr, int m, int[] fromArr, int n) {
        //42/59 passed
        for (int i = 0; i <= fromArr.length - 1; i++) {
			// System.out.println(" oddarr["+i+"]"+ arr1[i]);
			for (int j = 0; j <= toArr.length - 1; j++) {
				// System.out.println(" evenarr["+j+"]"+ arr2[j]);
				if (fromArr[i] <= toArr[j]) {
					// System.out.println(" oddarr["+i+"]"+ arr1[i]+" < evenarr["+j+"]"+arr2[j]);
					movevalsfwd(toArr, j,m+n);
					insertval(toArr, j, fromArr[i]);
					break;
				}else if(fromArr[i] > toArr[j] && j >= n && toArr[j] == 0){
					insertval(toArr, j, fromArr[i]);
					break;
				}else if(fromArr[i] > toArr[j] && j>m && toArr[j] == 0) {
					insertval(toArr, j, fromArr[i]);
					break;
				}else if(fromArr[i] > toArr[j] && n==1 && toArr[j] == 0) {
                    insertval(toArr, j, fromArr[i]);
					break;
                }else if(fromArr[i] > toArr[j] && m==0 && toArr[j] == 0) {
					insertval(toArr, j, fromArr[i]);
					break;
				}else{
                    continue;
                }

			}

		}
    }
    
  static void movevalsfwd(int[] arr, int endindex, int startindex) {
		// System.out.println(" moving vals fwd from "+fromindex);
		for (int i = startindex-2; i>=endindex; i--) {
			arr[i + 1] = arr[i];
		}

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
