package java_problems.geeksfogeeks;

import java.io.*;
import java.util.*;


public class PairsHavingSimilarElements {
    private static int[] arr =  {1,3,5,7,8,2,5,7};
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter wr = new PrintWriter(System.out);
//        int N = Integer.parseInt(br.readLine().trim());
//        String[] arr_A = br.readLine().split(" ");
//        int[] A = new int[N];
//        for(int i_A=0; i_A<arr_A.length; i_A++)
//        {
//            A[i_A] = Integer.parseInt(arr_A[i_A]);
//        }

        //long out_ = SimilarElementsPairs(A,N);
        long out_ = SimilarElementsPairs(arr,8);
        System.out.println(out_);

//        wr.close();
//        br.close();
    }
    static long SimilarElementsPairs(int[] A,int N){
        // Write your code here
        int cnt = 0;
        List<Integer> l = new ArrayList<>(N);
        for(Integer a : A){
            l.add(a);
        }

        for(Integer a : A){
            if(l.contains(a-1) || l.contains(a+1)){
                cnt++;
            }
        }
        return cnt;
    }
}
