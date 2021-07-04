package functionalinterface;

import java.util.function.BinaryOperator;

public class BinaryOperatorTest {

	public static void main(String[] args) {
		
		BinaryOperator<Integer> binaryOperator = (value1, value2) -> { return value1+value2; };
		System.out.println("binaryOperator "+ binaryOperator.apply(12, 13)) ;
	}

}
