package java_problems.geeksfogeeks.Special21.Stack;


import java.util.Stack;

/**
 Merry and Pippin have invented a new game called String Reduction. A random string S consisting of lowercase albhabets will be given. A player can choose any pair of similar consecutive characters and erase them in his turn.
 Merry has won the toss so he always goes first. Help decide who is the winner if the first person to give up loses.

        Input:
        First line of input contains number of testcases T. For each testcase, there will be one string input.

        Output:
        Print the name of the winner.

        Your Task:
        Complete the function findWinner() that takes the given string S as input and returns the name of the winner.

        Constraints:
        1 <= T <= 100
        1 <= S.length <= 10^5

        Example:

        Sample Input:
        3
        tooth
        abc
        aabaab

        Sample Output:
        Pippin
        Pippin
        Merry

        Explanation:
        Testcase 1:
        Merry will go first and reduce the stirng to tth.
        Pippin will go second and reduce the string to h.
        Since Merry can not reduce the string any further he loses and Pippin wins.

        Testcase 2:
        Since the given string can not be reduced any further Merry wont be able to start the game and Pippin will win.
*/


public class StringReductionGame {

    static String twoCharRemoveAt(String str, int p) {
        String r = str.substring(0, p) + str.substring(p + 2);
       // System.out.println("Removed String : "+r);
        return r;
    }

    static String reducedString(String s){
        char[] arr = s.toCharArray();
        for(int i=0;i < arr.length;i++){
            if(i == ( arr.length-1)){
                if( arr[i-1]!=arr[i] ){
                    s = s.concat(""+arr[i]);
                }
            }else{
                if(arr[i]==arr[i+1]){
                    s = twoCharRemoveAt(s,i);
         //           System.out.println("Removed String at index : "+i);
                    break;
                }
            }
        }

        return s;
    }

    public static String findWinner2(String s){

        Stack<Character> st = new Stack<>();



        return "";
    }

    static String findWinner(String s)
    {
        // Your code goes here
        // even - Pippin , odd - Merry
        String winner = "Default";
        int i = 0;
        int initialLength = 0;
        int reducedLength = 0;
        while(true){
            initialLength = s.length();

            if(s.length()!=1)
                s = reducedString(s);
            else
                break;

            reducedLength = s.length();

            if(initialLength!=reducedLength)
                i++;
            else
                break;
        }
        if(i % 2 == 0)
            winner = "Pippin";
        else
            winner = "Merry";
        return winner;
    }

    public  static  void main(String[] args){
        String test = "tooth";

        System.out.println(findWinner(test));
    }
}
