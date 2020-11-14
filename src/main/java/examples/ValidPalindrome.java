/**
 * 
 */
package examples;

/**
 * @author test
 *
 */
public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "A man, a plan, a canal: Panama";
		//output : True
		//Input: "race a car"
		//Output: false
		
		//boolean expected = true;
		
		boolean result = isPalindrome(str);
		System.out.println(" is Palindrome "+ result); 
		
		if(result) System.out.println(" Test Passed "+result); 
		else System.out.println(" Test Failed "+result); 
		
		System.out.println(" is Palindrome null "+ isPalindrome(null)); 
		
		System.out.println(" is Palindrome @@@##$$@@@ "+ isPalindrome("@@@##$$@@@")); 
		
		System.out.println(" is Palindrome Empty String "+ isPalindrome("")); 
		
		System.out.println(" is Palindrome Space String "+ isPalindrome(" "));
		
		System.out.println(" is Palindrome race a car String "+ isPalindrome("race a car"));
		
		
	}
	
	
	 public static boolean isPalindrome(String s) {
		 
		 if(s==null) return false;
		 
		 if(s.isEmpty()) return true;
		 
		 StringBuilder sb = new StringBuilder(); 
		  
		 for(int i=0;i<s.length();i++) {
		
			 if(Character.isLetterOrDigit(s.charAt(i))){
				 sb.append(Character.toLowerCase(s.charAt(i)));
			 }
		 }
		 
		 //System.out.println(" final String :"+sb.toString()); 
		 
		 int len = sb.length();
		 
		 if(len==0) return false;
		 if(sb.toString().isEmpty()) return true;
		 
		 int start = 0;
		 int end = len-1;
		 int mid = len/2;
		 
		 while(len!= 0&& start>=0 && end<len && start<=mid){
			 if(sb.charAt(start) != sb.charAt(end)) return false;
			 start++;
			 end--;
		 }
		 
		 return true;
	 }
	 
	 
	 public static boolean isPalindromev1(String s) {
		 
		if(s==null) return false;
		 
		if(s.isEmpty()) return true;
		
		StringBuilder sb = new StringBuilder();
		
		for(char ch : s.toCharArray()) {
			if(Character.isLetterOrDigit(ch)) sb.append(Character.toLowerCase(ch));
		}
		 
		String filterredStr  = sb.toString();
		String reverseStr  = sb.reverse().toString();
		
		return filterredStr.equals(reverseStr);
		
	 }
	 
	 
	 public static boolean isPalindromeStreams(String s) {
		 
			StringBuilder sb = new StringBuilder();
			
			s.chars()
			.filter(ch -> Character.isLetterOrDigit(ch))
			.mapToObj(c -> Character.toLowerCase((char) c))
			.forEach(sb::append);
			
			return sb.toString().equals(sb.reverse().toString());
			
		 }
	 
	 

}
