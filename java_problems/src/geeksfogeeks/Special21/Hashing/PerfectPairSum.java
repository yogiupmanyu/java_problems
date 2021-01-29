package java_problems.geeksfogeeks.Special21.Hashing;

public class PerfectPairSum {


    static boolean isNoOfDigitEqual(Integer x,Integer y){
        System.out.println("x:"+x+", y: "+y);
        Integer xNo = (""+x).length();
        System.out.println("xNo:"+xNo);
        Integer yNo = (""+y).length();
        System.out.println(xNo.equals(yNo));
        return  xNo.equals(yNo);
    }
    static int PerfectMatch(int arr[], int n) {
        // your code goes here
        int max = Integer.MIN_VALUE;
        boolean notFound = false;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isNoOfDigitEqual(arr[i],arr[j])) {
                    max = Math.max(max, (arr[i] + arr[j]));
                    if(!notFound)
                        notFound = true;
                }
            }
        }

        return notFound==true?max:-1;
    }

    public static void  main(String[] args){

    }
}
