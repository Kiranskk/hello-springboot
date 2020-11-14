/**
 * 
 */
package examples;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author test
 * leet 20 : valid paranthesis
 */
public class MatchingBrackets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//question any spl char or only brackets? assume only brackets
		
		//marching brackets prb
		//stack datas tructe
		//push elm ins stack
		//if top ele is matching while curr ele pop  from stack
		//if any elemnts left out we return invalid string
		
		String bracketsStr = "[{()}]";
		
		boolean res = isValid(bracketsStr);
		
		System.out.println(" i/p str " + bracketsStr+" is valid  "+res); 
		
		bracketsStr = "[{(}]";
		
		res = isValid(bracketsStr);
		
		System.out.println(" i/p str " + bracketsStr+" is valid  "+res); 

	}
	
	
	 public static boolean isValid(String s) {
	     
		 HashMap<Character, Character> map = new HashMap<Character, Character>();
		 map.put(')', '(');
		 map.put('}', '{');
		 map.put(']', '[');
		 
		 Stack<Character> stack = new Stack<Character>();
		 
		 for(int i= 0;i<s.length();i++) {
			
			 char c = s.charAt(i); 
			 
			 if(map.containsKey(c)){
				
				 char topelement  =  stack.empty() ? '#' : stack.pop();
				 
				 if(topelement!=map.get(c)) {
					 return false;
				 }
				 
			 }else {
				 stack.push(c);
			 }
			 
		 }
		 
		 return stack.isEmpty();
		 
	 }

}
