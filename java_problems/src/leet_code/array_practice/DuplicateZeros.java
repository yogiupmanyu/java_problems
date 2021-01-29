package leet_code.array_practice;

public class DuplicateZeros {
	
	 public void duplicateZeros_Solution(int[] arr) {
	        int possibleDups = 0;
	        int length_ = arr.length - 1;

	        // Find the number of zeros to be duplicated
	        // Stopping when left points beyond the last element in the original array
	        // which would be part of the modified array
	        for (int left = 0; left <= length_ - possibleDups; left++) {

	            // Count the zeros
	            if (arr[left] == 0) {

	                // Edge case: This zero can't be duplicated. We have no more space,
	                // as left is pointing to the last element which could be included  
	                if (left == length_ - possibleDups) {
	                    // For this zero we just copy it without duplication.
	                    arr[length_] = 0;
	                    length_ -= 1;
	                    break;
	                }
	                possibleDups++;
	            }
	        }

	        // Start backwards from the last element which would be part of new array.
	        int last = length_ - possibleDups;

	        // Copy zero twice, and non zero once.
	        for (int i = last; i >= 0; i--) {
	            if (arr[i] == 0) {
	                arr[i + possibleDups] = 0;
	                possibleDups--;
	                arr[i + possibleDups] = 0;
	            } else {
	                arr[i + possibleDups] = arr[i];
	            }
	        }
	    }
	
	public static void duplicateZeros(int[] arr) {
        int cnt = 0;
        int len = arr.length;
        int length_ = len-1;
        for (int left = 0; left <= length_ - cnt ; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included  
                if (left == length_ - cnt) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                cnt++;
            }
        }
        
        int i = len-cnt-1;
        int j = (len-1);
       
        if(cnt > 0) 
        	while( i >= 0 ) {
            	if(arr[i]==0) {
            		arr[j]=0;
            		arr[j-1]=0;
            		j-=2;i--;
            	}else if(arr[i]!=0){
            		arr[j]=arr[i];
            		i--;j--;
            	}
            }
        
        for(Integer val : arr) {
        	System.out.print(val+", ");
        }
        
    }
	
	
	public static void main(String[] args) {
		int[] arr = {0,1,7,6,0,2,0,7};
		
		duplicateZeros(arr);
	}
}
