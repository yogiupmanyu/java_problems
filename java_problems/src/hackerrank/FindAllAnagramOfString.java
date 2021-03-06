package hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/** 
 * 1. traverse each character of remaining ( to select ) and move into candidate side
 * 2. make this recursive call to each character of remaining string
 *  use PermutaionOfStringRecursiveApproachSolution.jpg to get recursive diagram
 * */

public class FindAllAnagramOfString {
	// main function use to return complete result list of anagram to a specific string
	 public static Set<String> findAllAnagrams(String input) {
	       // contains list of each possible string can be generate  
	        Set<String> resultList = new HashSet<>();
	        
	        findAnagram("", input, resultList);
	        return resultList;
	    }

		// Recursive function to generate all anagrams of a String
		private static void findAnagram(String candidate, String remaining,Set<String> resultList)
		{
			if (remaining.length() == 0) {
				//System.out.println(candidate);
				resultList.add(candidate);
			}

			for (int i = 0; i < remaining.length(); i++)
			{
				String newCandidate = candidate + remaining.charAt(i);

				String newRemaining = remaining.substring(0, i) +
									  remaining.substring(i + 1);

				findAnagram(newCandidate, newRemaining,resultList);
			}
		}
		
		 public static void main(String args[]) {
		    	
		        
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
//				    for(String str : inStrList) {
//				    	findAllAnagrams(str).forEach(eachRes->{
//				    		System.out.print(eachRes+" ");
//				    	});
//				    	System.out.println();
//				    }
				    
				    findAllAnagrams("abc").forEach(eachReslt->{
				    	System.out.print(eachReslt+" ");
				    });;
				}catch(FileNotFoundException e ) {
					e.printStackTrace();
				}
		    }
}


