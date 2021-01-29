package hackerrank;

import java.util.Arrays;
import java.util.stream.Stream;

public class RemoveDuplicate {
    int remove_duplicate(int a[], int N)
    {
        // Your code here

        Object[] t = Stream.of(a).distinct().toArray();
        for(Object v : t){
            System.out.print(v + " ");
        }
        return 0;
    }
}
