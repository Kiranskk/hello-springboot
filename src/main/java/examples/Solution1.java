/**
 * 
 */
package examples;

/**
 * @author test
 *
 */
public class Solution1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int input=0;
		double finalval=0;
		int percent=0;
		
		input = 25;
		percent = 10;
		
		finalval = applyPercent(input,percent);
		
		System.out.println(percent+"% of "+input +" is "+finalval);
		System.out.printf("finalval %.2f\n",finalval);
		
		
		input = 356564678;
		percent = 50;
		
		finalval = applyPercent(input,percent);
		
		System.out.println(percent+"% of "+input +" is "+finalval);
		System.out.printf("finalval %.2f\n",finalval);
		
		input = 25;
		percent = 100;
		
		finalval = applyPercent(input,percent);
		
		System.out.println(percent+"% of "+input +" is "+finalval);
		System.out.printf("finalval %.2f\n",finalval);
	}
	
	public static double  applyPercent(int val, int per) {
		System.out.println(" multiply percent "+val+"*"+per+"/100.0=" +val*per/100.0) ;
		return val+val*per/100.0;
	}
	
	public static double  getPercentInc(int currval, int finalval) {
		//System.out.println(" multiply percent "+val+"*"+per+"/100.0=" +val*per/100.0) ;
		//return val+val*per/100.0;
		
		//finalval-currval
		
		
		return 0.0;
	}
	
	

}
