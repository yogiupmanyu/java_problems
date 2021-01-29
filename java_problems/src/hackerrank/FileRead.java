package hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRead {

	public static void main(String[] args) {
		File file = new File("E:\\wordlist.txt");
		List<String> input = new ArrayList<>();
		
		try(Scanner sc = new Scanner(file)){ 
		    while (sc.hasNextLine()) {
		    	String res = sc.nextLine().trim();
		    	if(!res.isEmpty()) {
		    		input.add(res);
		    	}
		    }
		    
		}catch(FileNotFoundException e ) {
			e.printStackTrace();
		}
	}
}
