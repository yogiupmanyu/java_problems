package hacker_earth;
import java.util.*;
/*
You are given an array of size , where the integer of the array is and its value ranges between 1 and 1000

inclusive. You are required to complete the following task:

Assume that you are provided with
additional numbers , , and . Your task is to report the number of unordered pairs of elements from this array, such that i < j < N
, (a[i]+a[j])%k==x ,  and (a[i]*a[j])%k==y

*/

class InAnArray {
    private static int inAnArray(int[] a,int k,int x,int y){
        int len = a.length;
        int cnt = 0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(conditionMatch(a[i],a[j],k,x,y)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private static boolean conditionMatch(int a,int b,int k,int x,int y){
        return ((((a+b) % k)==x) && (((a*b) % k)==y));
    }

    public static void main(String args[] ) throws Exception {

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();   
        }
        System.out.print(inAnArray(arr,k,x,y));

    }
}

