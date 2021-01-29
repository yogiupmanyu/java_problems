package hackerrank;
/** 
 * Use a array contains if each we find each character or not and check this in complete given string 
 * */
public class HackerrankInAString {
	
	/** Edge case is to consider if we find complete string in given string then stop there : at line 18 (if( i == a.length ) )*/
	
	 // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {

    	boolean res = true;
    	
    	char[] b = s.toCharArray();
    	String test = "hackerrank";
    	int[] a = new int[test.length()];
    	
    	int i = 0;
    	for(int j = 0;j < b.length ;j++) {
    		if( i == a.length ) {
    			break;
    		}
    		char cur = test.charAt(i);
    		if( b[j] == cur ) {
    			a[i] = 1;
    			i++;
    		}
 
    	}
    	if(i != a.length) {
    		res = false;
    	}
     	
    	return res==true?"YES":"NO";
    }
	
	public static void main(String[] args) {
		String test = "hereiamstackerrank";
		System.out.println(hackerrankInString(test));
	}

}
