package java_problems.geeksfogeeks.Special21.LinkedList;

import java.io.IOException;
import java.util.*;

/** Question find triplet from array having GP  triplets should follow i < j < k position */
public class CountTriplets {
    /** solution : pseudo code
     * optimized one :
     * traverse complete array and add note of count , position of that number (first) in Map
     * count map to check if that number is used or not
     * pos map to check if it follows i < j < K
     * then check for cur value if cur*r , cur*r*r is present and in order (i<j<k) with cntPos map
     * */
    public static boolean checkGP(int i,int j,int k,List<Long> arr,long r){
        boolean res = false;

        long l1 = arr.get(i);
        long l2 = arr.get(j);
        long l3 = arr.get(k);
        if((l1*r==l2) && (l2*r==l3)){
            res = true;
        }
        return res;
    }
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long cnt = 0;
        int n = arr.size();

        /** SOLUTION 1 */
//        for(int i=0;i<arr.size();i++){
//            for(int j=i+1;j<arr.size();j++){
//                for(int k=j+1;k<arr.size();k++){
//                   // System.out.println("i: "+arr.get(i)+" j: "+arr.get(j)+" k: "+arr.get(k));
//                    if(checkGP(i,j,k,arr,r))
//                        cnt++;
//                }
//            }
//        }
        /** SOLUTION 2 */
       /* Map<Long,Long> cntMp = new HashMap<>();
        Map<Long,Long> posMp = new HashMap<>();
        long k = 0;
        for(Long l : arr){
            cntMp.put(l,cntMp.getOrDefault(l,0L));
            posMp.put(l,posMp.getOrDefault(l,k));
            k++;
        }
        k = 0;
        for(Long l : arr){
            if(cntMp.get(l*r)>k){
                long j = k;
                if(cntMp.get(l*r*r)>0){

                }

            }
            k++;
        }*/
        /** SOLUTION 3 ( Using Stack ) */



        return cnt;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

//        int n = Integer.parseInt(nr[0]);
//
//        long r = Long.parseLong(nr[1]);
//
//        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Long::parseLong)
//                .collect(toList());
        List<Long> arr = new ArrayList<>();
        arr.add(1L);
        arr.add(3L);
        arr.add(9L);
        arr.add(9L);
        arr.add(27L);
        arr.add(81L);
        long ans = countTriplets(arr,3);
        System.out.println(ans);
//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
