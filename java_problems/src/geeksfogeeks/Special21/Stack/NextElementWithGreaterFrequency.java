package java_problems.geeksfogeeks.Special21.Stack;

import java.util.HashMap;
import java.util.Map;

/**
    Given an array arr[ ] of n integers, for every element, find the closest element on it's right which has
    greater frequency than it. Frequency is the number of times the element appears in the array.

        Input:
        First line of input holds the number of test cases t. Then t test cases follow. In each test case, first
        line holds the integer n. Second line of test case holds the n elements of arr[ ].

        Output:
        Closest element on the right with greater frequency is printed for all array elements. If a number doesnt have an element
        on the right with greater frequency, -1 is printed for that particular value.

        Your task:
        Your task is to complete the function print_next_greater_freq(). This function prints the output array as
        explained above. Do not endline after printing.

        Constraints:
        T = 100
        1 <= n <= 104
        1 <= a[i] <= 104

        Example:
        Input:
        2
        10
        5 1 2 3 2 5 5 4 5 2
        6
        2 1 1 3 2 1
        Output:
        -1 2 5 2 5 -1 -1 5 -1 -1
        1 -1 -1 2 1 -1 */
/*
Solution
static void print_next_greater_freq(int arr[], int n)
        {
        HashMap <Integer,Integer> freq = new HashMap<>();
        for(int i=0 ; i<n ; i++ )
        if( freq.containsKey(arr[i]) )
        freq.put(arr[i], freq.get(arr[i])+1 );
        else
        freq.put(arr[i],1);

        Stack<Integer> stak = new Stack<Integer>();
        int ngf[] = new int[n];

        for(int i=0; i<n; i++)
        {
        int temp = freq.get(arr[i]);
        while(stak.empty()==false)
        if( temp > freq.get( arr[stak.peek()] ) )
        ngf[stak.pop()] = arr[i];
        else
        break;
        stak.push(i);
        }
        while(stak.empty()==false)
        ngf[stak.pop()] = -1;

        for(int i=0; i<n; i++)
        System.out.print(ngf[i]+" ");
        }*/
public class NextElementWithGreaterFrequency {

    static void print_next_greater_freq(int arr[], int n)
    {

        Map<Integer,Integer> cntMp = new HashMap<>();

        for(Integer l : arr){
            cntMp.put(l,cntMp.getOrDefault(l,0)+1);
        }
        //List<Integer> res = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        boolean temp = false;
        int pos = 0;
        for(int i=0;i<arr.length;i++){
            temp = false;
            pos = 0;
            for(int j=i+1;j<arr.length;j++){
                if(cntMp.get(arr[j])>cntMp.get(arr[i])) {
                    temp = true;
                    pos = j;
                    break;
                }
            }
            if(temp)
                res.append(arr[pos]+" ");
            else
                res.append(-1+" ");

        }
        System.out.print(res+" ");
    }

    public static void main(String[] args){
        int[] val = {5, 1 ,2, 3, 2, 5, 5, 4, 5, 2};

        print_next_greater_freq(val,val.length);
    }
}
