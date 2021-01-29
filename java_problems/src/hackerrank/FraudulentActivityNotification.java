package hackerrank;

import java.util.*;

public class FraudulentActivityNotification {
	
	static List<Integer> sortedList = new ArrayList<>();
	static Integer d = 0;
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int count = 0;
        for(Integer val : expenditure) {
        	sortedList.add(val);
        }
        Collections.sort(sortedList);
       
        for(int k=d;k<expenditure.length;k++){
        	int j = k-1;
        	int i = j-(d-1);
        	int exp = expenditure[k];
           
            double median = findMedian(i,j);
            if( exp >= median*2 ){
                count++;
            }
            
        }

        return count;
    }

    static double findMedian(int i , int j){
        int size = FraudulentActivityNotification.d;
        int middle = ((j-i+1)/2);
        if( size % 2 != 0 ){
            return (double)(sortedList.get(i+middle));
        }else{
            int first = sortedList.get(i+(middle-1));
            int second = sortedList.get(i+middle);
            return (double)(first+second)/2;
        }
    }

   
    
    public static void main(String[] args)  {
    	int t1 = 5;
    	int d = 3;
    	FraudulentActivityNotification.d = d;
    	int [] expenditure = {10,20,30,40,50};
    	System.out.print(activityNotifications(expenditure, d));
    }

}
