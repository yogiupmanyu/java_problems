package hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


// pseudo code 
/** 
 * 
 * 1. maintain a list which contains partial anagrams ( example , start from 0 only a is anagram then , i=1 'ab' , 'ba' similary 
 * when i=2 all the possible is our answer
 * 2. traverse each character of string ( start from second character i=1 )
 * 3. and insert each character at each possible position available in each strings of partial list ( partial = [a] then i=1 ( b ) in how 
 * many position we can insert b in partial = [a] , at 0 , then ba , at 1 then ab  
 * 4. in this way at last iteration of for(i=0 _ loop we have the list of all anagrams possible in partial list
 * */
public class FindAllAnagramOfStringIterative {

	// Iterative function to generate all anagrams of a String in Java
	// using Collections
	public static void anagrams(String s)
	{
		// create an empty ArrayList to store (partial) anagram
		List<String> partial = new ArrayList<>();

		// initialize the list with the first character of the string
		partial.add(String.valueOf(s.charAt(0)));

		// do for every character of the specified string
		for (int i = 1; i < s.length(); i++)
		{
			// consider previously constructed partial anagram one by one

			// (iterate backwards to avoid ConcurrentModificationException)
			for (int j = partial.size() - 1; j >= 0 ; j--)
			{
			
				String str = partial.remove(j);

				// Insert next character of the specified string in all
				// possible positions of current partial permutation. Then
				// insert each of these newly constructed string in the list

				for (int k = 0; k <= str.length(); k++)
				{
			
					partial.add(str.substring(0, k) + s.charAt(i) +
								str.substring(k));
				}
			}
		}

		System.out.println(partial);
	}
	
	// Iterative program to generate all anagrams of a String in Java
		public static void main(String[] args)
		{
			 File file = new File("E:\\wordlist2.txt");
				List<String> inputStrList = new ArrayList<>();
				
				try(Scanner sc = new Scanner(file)){ 
				    while (sc.hasNextLine()) {
				    	String res = sc.nextLine().trim();
				    	if(!res.isEmpty()) {
				    		inputStrList.add(res);
				    	}
				    }
				    
				    for(String str : inputStrList) {
				    	//anagrams(str);
				    }
				    anagrams("abc");
				    
				}catch(FileNotFoundException e ) {
					e.printStackTrace();
				}
		}

}

