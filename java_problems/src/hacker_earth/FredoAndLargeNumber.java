package hacker_earth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
*/
import java.util.*;
import java.util.Map.Entry;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class FredoAndLargeNumber {
	public static void main(String args[]) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			Map<Integer, Integer> cnt = new LinkedHashMap<>();
			for (Integer v : arr) {
				cnt.put(v, cnt.getOrDefault(v, 0) + 1);
			}
			int noOfQuery = sc.nextInt();
			while (noOfQuery-- > 0) {
				int type = sc.nextInt();
				int f = sc.nextInt();
				Set<Entry<Integer, Integer>> entries = cnt.entrySet();
				for (Entry<Integer, Integer> entry : entries) {
					Integer key = entry.getKey();
					Integer value = entry.getValue();
					//System.out.printf("key: %s, value: %d %n", key, value);

					if (type == 0) {
						if (value >= f) {
							System.out.println(key);
							break;
						}
					} else if (type == 1) {
						if (value == f) {
							System.out.println(key);
							break;
						}
					}
				}
			}
		}
	}
}

