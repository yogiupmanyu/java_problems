package geeksfogeeks;
/*

        You have to design a new model which maps an even length palindromic number to some digit between 0 to 9.
        The number is mapped to a digit on the basis of following criteria:
        1. should appear maximum number of times in the palindromic number, that is, among all digits in the number,
         should appear maximum number of times.
        2. If more than one digit appears maximum number of times, should be the smallest digit among them.
        Given an integer , you have to find the digit for the
        even length palindromic number.
        Note- First 9 even length palindromic numbers are:
        11, 22, 33, 44, 55, 66, 77, 88, 99
        Input :
        First line contains T, number of test cases.
        Each of the next T lines contains an integer N.
        Output:
        For each test case, print the digit to which the
        even length palindromic number is mapped.
        Answer for each test case should come in a new line.

        Constraints:
        SAMPLE INPUT

        3
        1
        2
        10
        SAMPLE OUTPUT
        1
        2
        0
        Explanation
        For case 1:
        1st even length palidromic number is 11 , so answer is 1 as 1 appears most number of times in the number.
        For case 2:
        2nd even length palidromic number is 22 , so answer is 2 as 2 appears most number of times in the number.
        For case 3:
        10th even length palindromic number is 1001, here both 0 and 1 appears same number of times but 0<1 so answer is 0.
*/


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvenLengthPalindromicNumber {

    public static Integer mxCnt = Integer.MIN_VALUE;
    public static Character mxVal = 'd';

    static Character findX(String str){
        mxCnt = Integer.MIN_VALUE;
        mxVal = ' ';

        char[] chr = str.toCharArray();
        Map<Character,Integer> chrCnt = new HashMap<>();
        for(Character c : chr){
           chrCnt.put(c,chrCnt.getOrDefault(c,0)+1);
        }


        chrCnt.forEach((k,v)->{
            if( mxCnt == v ){
                mxVal = (char)Math.min((int)mxVal,(int)k);
            }else if (mxCnt < v){
                mxCnt = v;
                mxVal = k;
            }
        });

        return mxVal;
    }

    static Character findEvenLengthPalindrome(Integer n){

        StringBuilder nStr = new StringBuilder(""+n);
        StringBuilder revStr = nStr.reverse();
        nStr.append(revStr);
        return findX(nStr.toString());
    }

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

    */
//        //Scanner
        Scanner s = new Scanner(System.in);
        Integer t = s.nextInt();

        while(t!=0){
            Integer val = s.nextInt();
            System.out.println(findEvenLengthPalindrome(val));
            t--;
        }

        System.out.println(findEvenLengthPalindrome(10));


    }
}
