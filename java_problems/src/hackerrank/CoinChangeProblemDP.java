package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> Coins) {
    // Write your code here
		/*
		 * int[][] a = new int[c.size()][n+1];
		 * 
		 * for(int i=0;i < c.size();i++) { a[i][0] = 1; }
		 * 
		 * for(int i = 1; i < c.size() ;i++) { for(int j=0;j<=n;j++) { if(c.get(i) > j)
		 * { a[i][j] = a[i-1][j]; }else { a[i][j] = a[i-1][j] +
		 * a[i][j-c.get(i).intValue()]; } } }
		 * 
		 * return a[c.size()-1][n];
		 */
    	// Create the ways array to 1 plus the amount 
        // to stop overflow 
        long[] ways = new long[(int)n + 1];  
  
        // Set the first way to 1 because its 0 and 
        // there is 1 way to make 0 with 0 coins 
        ways[0] = 1;  
  
         // Go through all of the coins 
        for (int i = 0; i < Coins.size(); i++) { 
  
            // Make a comparison to each index value  
            // of ways with the coin value. 
            for (int j = 0; j < ways.length; j++) {  
                if (Coins.get(i) <= j) { 
       
                    // Update the ways array 
                    ways[j] += ways[(int)(j - Coins.get(i))];  
                } 
            } 
        } 
  
        // return the value at the Nth position 
        // of the ways array.     
        return ways[(int)n];  
    }

}

public class CoinChangeProblemDP {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);
        System.out.print(ways);
		/*
		 * bufferedWriter.write(String.valueOf(ways)); bufferedWriter.newLine();
		 */

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

