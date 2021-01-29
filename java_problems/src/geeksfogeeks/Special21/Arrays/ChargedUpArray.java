package java_problems.geeksfogeeks.Special21.Arrays;

import java.io.*;
import java.util.*;

public class ChargedUpArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            long[] A = new long[N];
            for(int i_A=0; i_A<arr_A.length; i_A++)
            {
                A[i_A] = Long.parseLong(arr_A[i_A]);
            }

            int out_ = solve(A,N);
            System.out.println(out_);
            System.out.println("");
        }

        wr.close();
        br.close();
    }
    static int solve(long[] A,int N){
        // Write your code here
/*
NOT OPTIMIZED SOLUTION
    List<Map<Long,Integer>> fnl = new ArrayList<>();
        for(int i=0;i<N;i++){
            Map<Long,Integer> subset = new HashMap<>();
            for(int j=0;j<N;j++){
                subset.put(A[i],subset.getOrDefault(A[i],0)+1);
            }
            fnl.add(subset);
        }
        int summation_of_all_charged = 0;
        boolean isCharged = false;
        int total_no_subsets = 0;
        for(int i=0;i<N;i++){
            isCharged  = false;
            total_no_subsets = 0;
            for(Map<Long,Integer> sub : fnl ){
                if()
            }

        }*/

        return 0;
    }
}