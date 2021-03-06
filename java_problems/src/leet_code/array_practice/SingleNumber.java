package leet_code.array_practice;
/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


Approach 2: Hash Table

Approach 3: Math

Concept

2*(a+b+c) - ( a+a + b+ b+c ) = c

Approach 4: Bit Manipulation


    If we take XOR of zero and some bit, it will return that bit
        a XOR 0 = a
    If we take XOR of two same bits, it will return 0
        a XOR a = 0 
   a XOR b XOR c = ( a XOR a) XOR b = 0 XOR b = b

 
 * */
public class SingleNumber {
	
	public int singleNumber(int[] nums) {
	    int a = 0;
	    for (int i : nums) {
	      a ^= i;
	    }
	    return a;
	  }

}
