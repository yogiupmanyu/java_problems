package java_problems.geeksfogeeks;
import java.io.*;
        import java.util.*;


public class MaximumSimilarity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int testcase = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<testcase; t_i++)
        {
            String S = br.readLine();
            String T = br.readLine();

            int out_ = Maximum(S, T);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }
    static int Maximum(String S, String T){
        // Write your code here

//        int k = 0;
//        int cnt = 0;
//        for(int i=0;i<sarr.length;i++){
//            k=i;
//            while(sarr[i]!=tarr[k] && (k < tarr.length)){
//                k++;
//            }
//            int pos = S.indexOf(sarr[i]);
//            if(pos!=-1){
//                char temp = tarr[i];
//                tarr[i]=tarr[k];
//                tarr[k]=temp;
//                cnt++;
//            }
//
//
//        }
//        char[] sarr = S.toCharArray();
//        char[] tarr = T.toCharArray();
//        int cnt = 0;
//        for(int i=0;i<sarr.length;i++){
//            if(i<tarr.length){
//                int pos = T.indexOf(sarr[i],i);
//                if(pos!=-1) {
//                    char temp = tarr[i];
//                    tarr[i] = tarr[pos];
//                    tarr[pos] = temp;
//                    cnt++;
//                }
//            }else{
//                break;
//            }
//
//        }
//        return cnt;
//        int cnt = 0;
//        int len = Math.min(S.length(),T.length());
//        HashSet<Character> hs = new HashSet<>();
//        for(int i=0;i<len;i++){
//            hs.add(S.charAt(i));
//        }
//        for(int i=0;i<len;i++){
//            if(hs.contains(T.charAt(i))){
//                cnt++;
//            }
//        }
//        return cnt;
//
//        return 0;
        int cnt = 0;
        int len = Math.min(S.length(),T.length());
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<len;i++){
            hm.put(S.charAt(i),hm.getOrDefault(S.charAt(i),0)+1);
        }
        for(int i=0;i<len;i++){
            if(hm.containsKey(T.charAt(i)) && hm.get(T.charAt(i)) > 0){
                hm.put(T.charAt(i),hm.get(T.charAt(i))-1);
                cnt++;
            }
        }

        return cnt++;
    }

}
