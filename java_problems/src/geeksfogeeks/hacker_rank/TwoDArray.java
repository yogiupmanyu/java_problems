package java_problems.geeksfogeeks;

public class TwoDArray {
    static int hourglassSum(int[][] arr) {
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len-2;i++){
            for(int j=0;j<len-2;j++){
                int sum = singleHourGlassSum(arr,i,j);
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    static int singleHourGlassSum(int[][] arr,int i,int j){
        int sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]
                        + arr[i+1][j+1] +
                  arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
        return sum;
    }
}
