package java_problems.geeksfogeeks.hacker_rank.strings;

public class HighestValuePalindrome {
/*


    Make largest palindrome by changing at most K-digits

    Given a string containing all digits, we need to convert this string to a palindrome by changing at most K digits.
     If many solutions are possible then print lexicographically largest one.

    Examples:

    Input   : str = “43435”
    k = 3
    Output  : "93939"
    Lexicographically largest palindrome
    after 3 changes is "93939"

Solution
     We can solve this problem using two pointers method. We start from left and right and if both digits are not equal then
     we replace the smaller value with larger value and decrease k by 1. We stop when the left and right pointers cross each other,
     after they stop if value of k is negative, then it is not possible to make string palindrome using k changes. If k is positive,
     then we can further maximize the string by looping once again in the same manner from left and right and converting both the digits
     to 9 and decreasing k by 2. If k value remains to 1 and string length is odd then we make the middle character as 9 to maximize
     whole value.

     we have change each number to 9 if k is left after creating the current number palindrome also, and maintain the palindrome.
*/
    public static String highestValuePalindrome(String str, int n, int k) {
       char palin[] = str.toCharArray();
       String ans = "";
       // Iinitialize l and r by leftmost and
       // rightmost ends
       int l = 0;
       int r = str.length() - 1;

       // first try to make String palindrome
       while (l < r) {
           // Replace left and right character by
           // maximum of both
           if (str.charAt(l) != str.charAt(r)) {
               palin[l] = palin[r] = (char) Math.max(str.charAt(l),
                       str.charAt(r));
               k--;
           }
           l++;
           r--;
       }

       // If k is negative then we can't make
       // String palindrome
       if (k < 0) {
           return "Not possible";
       }

       l = 0;
       r = str.length() - 1;

       while (l <= r) {
           // At mid character, if K>0 then change
           // it to 9
           if (l == r) {
               if (k > 0) {
                   palin[l] = '9';
               }
           }


       }


           return  "";
   }
   public static  void main(String[] args){
        String s = "092282";
       // System.out.println(highestValuePalindrome(s,s.length(),3));
    }
}
