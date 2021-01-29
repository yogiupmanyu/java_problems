package java_problems.geeksfogeeks;

public class MaxContiguosDecreasingArray {

    private static Integer[] arr =  {8,7,3,5,2,9};

    public static  void main(String[] args){
        int max = Integer.MAX_VALUE;
        int cnt = 0;
        int i = 0;
        for(Integer a : arr){
            if((i == 0 || i == 1) && ( a <= max )){
                cnt ++ ;
                max = a;
            }else if(a > max) {
                if(i==0){
                    i++;
                    cnt ++ ;
                    max = a;
                }else if(i==1){
                    break;
                }
            }
        }

        System.out.println("Result is :: " + (cnt-1));
    }
}
