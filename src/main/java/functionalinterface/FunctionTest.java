package functionalinterface;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		
		//this is the implementation of Function Functional interface apply(obj) method
		Function<Integer, Integer> func = (param) -> param-2;   
		
		System.out.println("Function -2 apply "+func.apply(25));
		
		Function<Integer, Integer> func2 = (param) -> param+2;   
		
		System.out.println("Function +2 apply "+func2.apply(25));
	}

}
