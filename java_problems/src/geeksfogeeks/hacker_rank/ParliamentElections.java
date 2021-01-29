package java_problems.geeksfogeeks;

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



class Result2 {

    /*
     * Complete the 'parliamentParties' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY votes as parameter.
     */


    public static List<String> parliamentParties(List<String> votes) {
        // Write your code here
        List<String> res = new ArrayList<>();
        Map<String,Integer> cnt = new HashMap<>();
        for (String vote : votes) {
            cnt.put(vote,cnt.getOrDefault(vote,0)+1);
        }
        final double total = votes.size();
        cnt.forEach((k,v)->{
            double percent = (v/total*100);
            //System.out.println("k:"+k+"  v:"+v+" percent:"+percent+" total"+total+" v/total:"+v/total);
            if(percent > 5){
                res.add(k);
            }
        });

        return  res;
    }

}

public class ParliamentElections {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int votesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> votes = IntStream.range(0, votesCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .collect(toList());
//
//        List<String> result = Result.parliamentParties(votes);
//
//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();

        int count = 20;
        List<String> t = new ArrayList<>();
        t.add("Republican");
        t.add("Democratic");
        t.add("Republican");
        t.add("Democratic");
        t.add("Republican");
        t.add("Democratic");
        t.add("Republican");
        t.add("Democratic");
        t.add("Republican");
        t.add("Democratic");
        t.add("Republican");
        t.add("Democratic");
        t.add("Republican");
        t.add("Democratic");
        t.add("Republican");
        t.add("Democratic");
        t.add("Republican");
        t.add("Democratic");
        t.add("Republican");
        t.add("Libertarian");

        Result2.parliamentParties(t);


    }
}

