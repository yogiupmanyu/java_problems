package hackerrank;

public class FraudulentActivityNotification2 {
	
	 static int activityNotifications(int[] expenditure, int d) {
		 int[] countSortArray = new int[201];
		 int end = d;
		 
		 // perform counting sort 
		 for(int i=0;i<end;i++) {
			 countSortArray[expenditure[i]] += 1;
		 }
		 
		 int medianPosition = 0;
		 int current = 0;
		 int totalNotification = 0;
		 if(d % 2 == 0)
			 medianPosition = (int)(d/2);
		 else
			 medianPosition = (int)(d/2) + 1;
		 
		 
		 
		 return 0;
	 }

}
