/**
 * 
 */
package examples;

/**
 * @author test
 * Add Strings
 * "1789" "15" = "1804" 
 */
public class AddStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String nums1 = "1789";
		
//		int i= 0;
//		
//		while(i<nums1.length()) {
//			System.out.println(" Char At " +i+ " = "+ (nums1.charAt(i)-'0'));
//			int v = nums1.charAt(i)-'0';
//			System.out.println(" INT val " +v);
//			i++;
//		}
//		
//		System.out.println(" INT 12%10 val " +(12%10));//remainder
//		System.out.println(" INT 12/10 val " +(12/10));//remainder
//		System.out.println(" INT 12/10.0 val " +(12/10.0));//remainder
//		
		String nums2 = "15";
		
		String result = addStrings(nums1,nums2);
		
		System.out.println(" Add String result "+nums1+" + "+nums2+" = "+result);

		if(result.equals("1804")) {
			System.out.println(" Add String Test Passed " +result);
		}else {
			System.out.println(" Add String Test Failed  " +result);
		}
		
		nums1 = "123";
		nums2 = "10";
		
		result = addStrings(nums1,nums2);
		
		System.out.println(" Add String result "+nums1+" + "+nums2+" = "+result);

		if(result.equals("133")) {
			System.out.println(" Add String Test Passed " +result);
		}else {
			System.out.println(" Add String Test Failed  " +result);
		}
		
		
		
	}
	
	
	public static String addStrings(String nums1,String nums2) {
		
		StringBuilder res = new StringBuilder(); 
		
		int p1  = nums1.length()-1;
		int p2  = nums2.length()-1;
		
		int carry = 0;
		
		for(;p1>=0 || p2>=0;p1--,p2--) {
			int v1 = p1>=0 ? nums1.charAt(p1) -'0': 0;
			int v2 = p2>=0 ? nums2.charAt(p2) -'0': 0;
			
			int value = (v1+v2+carry)%10;
			carry = (v1+v2+carry)/10;
			
			res.append(value);
		}
		
		if(carry!=0) {
			res.append(carry);
		}
		
		return res.reverse().toString();
	}
	
	

}
