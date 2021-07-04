package functionalinterface;

import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		
		//this is the implementation of Predicate Functional interface test(obj) method
		Predicate predNotNullCheck = (val) -> val!=null;  
		
		boolean res = predNotNullCheck.test("testnotEmpty"); 
		
		System.out.println("Predicate not null i/p "+res); 
		
		boolean res2 = predNotNullCheck.test(null); 
		System.out.println("Predicate null i/p "+res2); 

		
		Predicate predNullCheck = predNotNullCheck.negate();
		
		System.out.println("Predicate negate "+predNullCheck.test(null));
		
		
	}

}
