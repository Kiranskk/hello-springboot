/**
 * 
 */
package examples;

/**
 * @author test
 *
 */
public class MergeArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] oddarr = {1,3,5,7,9}; 
		int[] evenarr = {2,4,6,8,10,0,0,0,0,0};
		
		//TODO: expected out put to put in even arr
		int[] mergedarr = {1,2,3,4,5,6,7,8,9,10};
		
		
		/**
		 * 1. check the value
		 * 2. move the existing vals
		 * 3. insert value
		 */
		
		//int indx=0;
		getInsertIndex(oddarr, evenarr);
		//movevalsfwd(evenarr, indx);		
		
		System.out.println("merged array ");
		for (int i = 0; i < evenarr.length; i++) {
			System.out.println(evenarr[i]);
		}
		
		//duplicates
		int[] oddarr1 = {1,2,5,8,9}; 
		int[] evenarr1 = {2,4,6,8,10,0,0,0,0,0};
		
		//int indx=0;
				getInsertIndex(oddarr1, evenarr1);
				//movevalsfwd(evenarr, indx);		
				
				System.out.println("merged array with Duplicates");
				for (int i = 0; i < evenarr1.length; i++) {
					System.out.println(evenarr1[i]);
				}
		
		
	}
	
	
	static int getInsertIndex(int[] oddarr,int[] evenarr) {
		
		for (int i = 0; i <= oddarr.length-1; i++) {
			System.out.println(" oddarr["+i+"]"+ oddarr[i]);
			for(int j = 0; j < evenarr.length-1; j++) {
				System.out.println(" evenarr["+j+"]"+ evenarr[j]);
				/*if(oddarr[i]>=evenarr[j] && evenarr[j]!=0) {
					System.out.println(" oddarr["+i+"]"+ oddarr[i]+" >= evenarr["+j+"]"+evenarr[j]);
					movevalsfwd(evenarr,j);
					insertval(evenarr,j,oddarr[i]);
					break;
					//return j;
				}*/
				//else
					
					if(oddarr[i]<evenarr[j] && evenarr[j]!=0){
					System.out.println(" oddarr["+i+"]"+ oddarr[i]+" < evenarr["+j+"]"+evenarr[j]);
					movevalsfwd(evenarr,j);
					insertval(evenarr,j,oddarr[i]);
					break;
				}//else {
					//System.out.println(" ELSE ");
				//}
				
			}
			
		}
		
		
		return 0;
	}
	
	
	static void movevalsfwd(int[] arr,int fromindex) {
		System.out.println(" moving vals fwd from "+fromindex);
		for (int i = arr.length-1; i >= fromindex; i--) {
			if(arr[i]!=0) {
				//System.out.println(" moving["+i+"] "+arr[i]+" to ["+(i+1)+"]"+arr[i+1]);
				arr[i+1]=arr[i];
				//System.out.println(" moved val["+(i+1)+"] "+arr[i+1]);
			}
		}
		
		System.out.println(" moved array vals");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("["+i+"]"+arr[i]);
		}
	}
	
	static void insertval(int[] arr,int index,int val) {
		System.out.println("inserting at index "+index+ " val "+val);
		arr[index]=val;
		
		System.out.println(" inserted array vals");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("["+i+"]"+arr[i]);
		}
		
		
	}
	

}
