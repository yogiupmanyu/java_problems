package java_problems.geeksfogeeks;

import java.util.Arrays;

// solution of Pairs problem with two pointer technique
public class TwoPointerTechnique {

    static void twoPointerTechnique(int[] A,int X){
        Arrays.sort(A);
        int i=0; int j=1; int cnt = 0;
        while(j < A.length){
            int diff = A[j]-A[i];
            if(diff == X ) {
                cnt++;
                j++;
            }
            else if( diff < X)
                j++;
            else
                i++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args){
        int[] a = {1,5,3,4,2};
        twoPointerTechnique(a,2);
    }
}
