package java_problems.geeksfogeeks;
/*

Lapindrome is defined as a string which when split in the middle, gives two halves having the same characters and same frequency of
 each character. If there are odd number of characters in the string, we ignore the middle character and check for lapindrome.
 For example gaga is a lapindrome, since the two halves ga and ga have the same characters with same frequency. Also, abccab, rotor
 and xyzxy are a few examples of lapindromes. Note that abbaab is NOT a lapindrome. The two halves contain the same characters but
 their frequencies do not match.
        Your task is simple. Given a string, you need to tell if it is a lapindrome.
        Input:
        First line of input contains a single integer T, the number of test cases.
        Each test is a single line containing a string S composed of only lowercase English alphabet.
        Output:
        For each test case, output on a separate line: "YES" if the string is a lapindrome and "NO" if it is not.
        Constraints:

        1 ≤ T ≤ 100
        2 ≤ |S| ≤ 1000, where |S| denotes the length of S

        Example:
        Input:

        6
gaga
abcde
rotor
xyzxy
abbaab
ababc


        Output:

        YES
        NO
        YES
        YES
        NO
        NO

*/


import java.util.*;

public class Lapindrome {

    static void findPalindrome(String s){
        Map<Character,Integer> firstHalfCnt = new HashMap<>();
        Map<Character,Integer> secondHalfCnt = new HashMap<>();

        int halfLen = (int)(s.length()/2); // 5/2 -- 2 and 4/2 -- 2
        char[] str = s.toCharArray();

        for(int i=0;i<str.length;i++){
            if(s.length()%2==0){
                if(i <= halfLen-1){
                    firstHalfCnt.put(str[i],firstHalfCnt.getOrDefault(str[i],0)+1);
                }else {
                    secondHalfCnt.put(str[i],secondHalfCnt.getOrDefault(str[i],0)+1);
                }
            }else{
                if(i <= halfLen-1){
                    firstHalfCnt.put(str[i],firstHalfCnt.getOrDefault(str[i],0)+1);
                }else if(i==halfLen) {

                } else {
                    secondHalfCnt.put(str[i],secondHalfCnt.getOrDefault(str[i],0)+1);
                }
            }

        }

        boolean res = true;
        for(int j=0;j<str.length/2;j++){
            if(!(secondHalfCnt.containsKey(str[j]) && firstHalfCnt.get(str[j]).equals(secondHalfCnt.get(str[j])))){
                res = false;
                break;
            }
        }
        if(res)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        //String s = "abcde";
       //findPalindrome(s);
        List<String> input = new ArrayList<>();
        Scanner in  = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        if(t>=1 && t<=100) {
            while (t != 0) {
                String s = in.nextLine();
                int len = s.length();
                if(len >=2 && len <=1000){
                   input.add(s);
                    t--;
                }
            }
        }
        for(String s : input){
            findPalindrome(s);
        }

    }
}
