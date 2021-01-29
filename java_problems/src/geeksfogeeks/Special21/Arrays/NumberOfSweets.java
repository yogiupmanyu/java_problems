package java_problems.geeksfogeeks.Special21.Arrays;

import java.util.*;

public class NumberOfSweets {
    // function to find minimum
    // number of given operations
    // to convert m to n
    static int convert(int m, int n , ArrayList<String>s)
    {
        if (m == n)
            return 0;

        // only way is to do
        // -1 (m - n) times
        if (m > n)
        {
            // adding "eat" in arraylist
            for(int i=0;i<(m-n);i++)
                s.add("eat");
            return m - n;
        }


        // not possible
        if (m <= 0 && n > 0)
            return -1;

        // n is greater and n is odd
        if (n % 2 == 1)
        {
            // perform '-1' on m
            // (or +1 on n)
            s.add("eat");
            return 1 + convert(m, n + 1,s);
        }

        // n is even
        else
        {
            // perform '*2' on m
            // (or n / 2 on n)
            s.add("overflow")   ;
            return 1 + convert(m, n / 2,s);
        }
    }


    static ArrayList<String>getDecision(int a , int b)
    {
        ArrayList<String> ans = new ArrayList<String>();
        convert(a,b,ans);
        Collections.reverse(ans);
        return ans;
    }

    public static  void main(String[] args){
        getDecision(5,8);
    }
}
