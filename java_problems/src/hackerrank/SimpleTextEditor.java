package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/** In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, . 
 * You must perform operations of the following

types:

    append

- Append string to the end of
.
delete
- Delete the last characters of
.
print
- Print the character of
.
undo
- Undo the last (not previously undone) operation of type or , reverting to the state it was in prior to that 
Output Format

Each operation of type
must print the

character on a new line.

Sample Input

8
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1

Sample Output

c
y
a
*/
public class SimpleTextEditor {
	
	//static StringBuilder s = new StringBuilder();
	static String s = "";
	static Stack<Map<Integer,String>> cache = new Stack<>();
	
	static void push(String str) {
		Map<Integer,String> op1 = new HashMap<>();
		op1.put(1, str);
		cache.add(op1);
		s = s.concat(str);
	}
	
	static void delete(int pos) {
		Map<Integer,String> op2 = new HashMap<>();
		op2.put(2, s);
		cache.add(op2);
		s = s.substring(0,(s.length()-pos));
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		List<Character> res = new ArrayList<>();
		
		while(test-- > 0) {
			int option = sc.nextInt();
			switch(option) {
				case 1 :
					String str2 = sc.nextLine();
					push(str2.trim());
					break;
				case 2 : 
					int pos = sc.nextInt();
					delete(pos);
					break;
				case 3 :
					//res.add(s);
					int pos1 = sc.nextInt();
					//System.out.println(s.charAt(pos1-1));
					res.add(s.charAt(pos1-1));
					break;
				case 4 :
					Map<Integer,String>temp = cache.pop();
					if(temp.containsKey(1)) {
						// append in last operation now remove the last str substring
						String str = temp.get(1);
						s = s.substring(0,s.length()-str.length());
					}else {
						// delete in last operation now change to the inital string
						s = temp.get(2);
					}
			}
		}
		
		sc.close();
		
		for(Character c : res) {
			System.out.println(c);
		}

	}

}
