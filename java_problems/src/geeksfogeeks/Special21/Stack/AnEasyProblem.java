package java_problems.geeksfogeeks.Special21.Stack;

import java.util.Stack;



/**
    Given an array Arr of Integers of size N . You have to check whether a subsequence Arr[i] , Arr[j] , Arr[k]
    such that i < j < k and Arr[i] < Arr[k] < Arr[j]  is present in the array or not.

        Input: First line of input consists of an integer T denoting number of test cases. For each test case, the first line
        contains an integer N denoting the size of the array. Next line contains N space separated integers .
        Output:
        For each test case , print "True" if a subsequence found following the given condition else print "False".
        Your Task:
        Since it is a functional problem you don't need to take input just complete the function
        CheckSub() which accepts given array and its size as parameters and returns a boolean value.
        Constraints:
        1 <= T <= 100
        1 <= N <= 104
        1 <= Arr[i] <= 105
        Example:
        Input:
        2
        6
        4 7 11 5 13 2
        4
        11 11 12 9
        Output:
        True
        False
        Explanation:
        Test Case 1:  [ 4 , 7, 5 ] satisfies i < j < k && Arr[i] < Arr[k] < Arr[j]
        Test Case 2 : No such sub sequence found.
*/


public class AnEasyProblem {


    /**
    boolean res = false;
            for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            for(int k=j+1;k<n;k++){
                if( ( arr[i] < arr[j] ) && ( arr[j] < arr[k]) ){
                    res = true;
                    break;
                }
            }
        }
    }
            return res;*/

    static boolean CheckSub(int [] arr , int n)
    {
        if (n < 3)
            return false;
        Stack< Integer > stack = new Stack < > ();
        int[] minn = new int[n];
        minn[0] = arr[0];
        for(int i = 1; i <n; i++)
            minn[i] = Math.min(minn[i - 1], arr[i]);

        for (int j = n - 1; j >= 0; j--)
        {
            if (arr[j] > minn[j])
            {
                while (!stack.empty() && stack.peek() <= minn[j])
                    stack.pop();
                if (!stack.empty() && stack.peek() < arr[j])
                    return true;
                stack.push(arr[j]);
            }
        }
        return false;
    }

    public  static  void main(String[] args){
        int[] arr = {4,7,11,5,13,2};

        if(CheckSub(arr,arr.length))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
