package geeksfogeeks.general;
/* 
 * Save this in a file called Main.java and compile it. To test it 
 * create the file `input.txt` in the workspace / Working Directory
 * (For Eclipse/VisualStudio, by default this is the top level project folder)
 */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */
// asked in Risemart technology 
public class Department {
    public static Map<String,Integer> processData(ArrayList<String> array) {
        /* 
         * Modify this method to process `array` as indicated
         * in the question. At the end, return a Map containing
         * the appropriate values
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
    	Map<String,Integer> cache = new HashMap<String,Integer>();
    	Map<String,Integer> retVal = new HashMap<String,Integer>();
        try{
        	
	        for(String val : array){
	        	String[] departmentInfo = val.split("[,]",0);
	        	String department = departmentInfo[2].trim();
	        	Integer salary = Integer.parseInt(departmentInfo[3].trim());
	        	Integer deptID = Integer.parseInt(departmentInfo[0].trim());
	        	if(cache.containsKey(department)){
	        		if(cache.get(department) < salary ){
	        			cache.put(department,salary);
	        			cache.put(department,deptID);
	        		}
	        	}else{
	        		cache.put(department,salary);
	        		retVal.put(department, deptID);
	        	}
	        		
	        }
        }catch(NumberFormatException numExc){
        	numExc.printStackTrace();
        }catch(Exception e){
        	e.printStackTrace();
        }
       
        
       return retVal;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while(in.hasNextLine())
                inputData.add(in.nextLine());
            Map<String,Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
