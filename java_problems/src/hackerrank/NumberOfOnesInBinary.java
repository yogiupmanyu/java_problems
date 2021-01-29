package hackerrank;
/** 
 * Find the number of 1s in the binary representation of a number.
 * e.g ones(7)  = 3
 * 
 * 
 * */

public class NumberOfOnesInBinary {

		private static int ones(int x) {
			int sum = 0;
			
			while(x > 0) {
				sum = sum + (x^1);// ex 1 - b001 7 - b111 001 ^ 111 = 001 means only the last will match comes 1 if sum is odd otherwise
							// 0 similar to x % 2
				
				x >>= 1; // shift x bitwise by 1 to right direction
			}
			return sum;
		}
		
		public static void main(String[] args) {
			int x = 7;
			System.out.print(ones(x));
		}
}
