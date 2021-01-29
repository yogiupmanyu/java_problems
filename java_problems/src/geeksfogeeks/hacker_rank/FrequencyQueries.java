package geeksfogeeks;

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

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    List<Integer> res = new ArrayList<>();
    Map<Integer,Integer> cntMap = new HashMap<>();
    for(List<Integer> val : queries){
        int z = val.get(0);
        int t = val.get(1);
        switch (z){
            case 1 :
                cntMap.put(t,cntMap.getOrDefault(t,0)+1);
                break;
            case 2 :
                if(cntMap.containsKey(t))
                    cntMap.put(t,cntMap.get(t)-1);
                break;
            case 3:
                if(cntMap.containsKey(t)){
                    if(cntMap.get(t).equals(t))
                        res.add(1);
                    else
                        res.add(0);
                }
                break;
        }
    }

    return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

