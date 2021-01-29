package hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class FindAllOfAString {

    public Set<String> permute(char input[]) {
        Map<Character, Integer> countMap = new HashMap<>();
        // create a map with key is each character and value is its count in the string
        for (char ch : input) {
        	countMap.put(ch, countMap.getOrDefault(ch, 0)+1);
        }
        
        char chrs[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        
        
        // fill each chrs and count with
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
        	chrs[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        
       // contains list of each possible string can be generate  
        Set<String> resultList = new HashSet<>();
        
        // temporary array used to store the specific result 
        char result[] = new char[input.length];
        findAnagramUtil(chrs, count, result, 0, resultList);
        return resultList;
    }

    public void findAnagramUtil(char str[], int count[], char result[], int level, Set<String> resultList) {
        if (level == result.length) {
        	resultList.add(new String(result));
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            findAnagramUtil(str, count, result, level + 1, resultList);
            count[i]++;
        }
    }



    public static void main(String args[]) {
    	FindAllOfAString sp = new FindAllOfAString();
        //sp.permute("AABC".toCharArray()).forEach(s -> System.out.println(s));
        
        File file = new File("E:\\wordlist2.txt");
		List<String> inStrList = new ArrayList<>();
		
		try(Scanner sc = new Scanner(file)){ 
		    while (sc.hasNextLine()) {
		    	String res = sc.nextLine().trim();
		    	if(!res.isEmpty()) {
		    		inStrList.add(res);
		    	}
		    }
		    //System.out.println("File Read Successfully !!!");
		    for(String str : inStrList) {
		    	sp.permute(str.toCharArray()).forEach(eachRes->{
		    		System.out.print(eachRes+" ");
		    	});
		    	System.out.println();
		    }
		    
		}catch(FileNotFoundException e ) {
			e.printStackTrace();
		}
    }
}
