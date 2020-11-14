/**
 * 
 */
package examples;

/**
 * @author test
 *
 */
public class RemoveDuplicatesInSortedArray {

	/**
	 * @param args
	 * leet 26
	 * [1,1,2] to [1,2]
	 * [0,0,1,1,1,2,2,3,3,4] to [0,1,2,3,4]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []arr = {0,0,1,1,1,2,2,3,3,4};
		
		int finalarr = moveDuplicatesToLast(arr);
		
		System.out.println("after deletion final array size:"+finalarr);
		
		for (int i = 0; i < finalarr; i++) {
			System.out.println(arr[i]);
		}
		
		
		
		int []arr1 = {};
		
		int finalarr1 = moveDuplicatesToLast(arr1);
		
		System.out.println("after deletion final array size:"+finalarr1);
		
		for (int i = 0; i < finalarr1; i++) {
			System.out.println(arr1[i]);
		}
		
		
	}
	
	
	static int removeDups(int[] arr) {
		
		int cnt = 0;
		
		for (int i = 1; i < arr.length-1; i++) {
			
			if(arr[i]!=arr[cnt]) {
				cnt++;
				arr[cnt]=arr[i];
			}
			
		}
		return cnt+1;
	}
	
static int removeDupswhile(int[] arr) {
		
	int j = 0;
	int i = 1;
 
	while (i < arr.length) {
		if (arr[i] != arr[j]) {
			j++;
			arr[j] = arr[i];
		}
 
                i++;
	}
 
	return j + 1;
	}
	
	
	static int removeDuplicates(int[] arr) {
		
		int cnt = 0;
		
		for (int i = 0; i < arr.length-1; i++) {
			
			if(arr[i]!=arr[i+1]) {
				//arr[i]=i;
				continue;
			}else {
				arr[i]=-320000000;//set a flag to ignore the duplicates
				cnt++;
			}
			
		}
		
		//arr = null;
		
		//arr = new Array[arr.length-cnt];
		
		return arr.length-cnt;
		
	}
	
static int moveDuplicatesToLast(int[] arr) {
	
	if(arr.length<2) {
		return arr.length;
	}
	
	int cnt = 0;
	
	for(int i=1;i<=arr.length-1;i++) {

		if(arr[cnt]!=arr[i]) {
			cnt++;
			arr[cnt] = arr[i];
		}
		
		
	}
	
	return cnt+1;

  }

}
