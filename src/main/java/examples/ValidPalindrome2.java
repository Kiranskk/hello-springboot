/**
 * 
 */
package examples;

/**
 * @author test
 *
 */
public class ValidPalindrome2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
        //remove c
		System.out.println("valid palindrome abca "+validPalindromeVer2("abca"));
		
		//remove a
		System.out.println("valid palindrome abaa "+validPalindromeVer2("abaa"));
		
		
		
		
	}
	
	
	public static boolean validPalindrome(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		
		for(int i=0;i<sb.length();i++) {
			
			char ch = sb.charAt(i);
			
			sb.deleteCharAt(i);
			
			if(isPalindrome(sb)) return true;
			
			sb.insert(i, ch);
		}
		
		return isPalindrome(s);
    }
	
 public static boolean isPalindrome(CharSequence s) {
		
	   for(int i=0;i<s.length()/2;i++) {
		   
		   if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
		   
	   }	
	   
		return true;
    }
 
 
 //approach 2 
 
 public static boolean validPalindromeVer2(String s) {
		
		for(int i= 0;i<s.length()/2;i++) {
			
			if(s.charAt(i)!= s.charAt(s.length()-1) ) {
				int j = s.length()-i-1;
				
				return ( checkPalindrome(s,i,j) || checkPalindrome(s,i,j) );
				
				
			}
			
		}
		
		
		return false;
		
 }
 
 
 public static boolean checkPalindrome(String s,int start,int end) {
	 
	 for(int k = start;k<start+(end-start)/2 ;k++) {
		 
		 if (s.charAt(k) != s.charAt(end - k + start)) return false;
		 
	 }
	 
	 return true;
	 
 }
 
 

}
