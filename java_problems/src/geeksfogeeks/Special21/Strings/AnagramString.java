package java_problems.geeksfogeeks.Special21.Strings;

public class AnagramString {

    private static boolean checkAnagram(String s1,String s2){

        boolean res = false;
        if(s1.length()==s2.length()) {
            char[] s1Ar = s1.toCharArray();
            char[] s2Ar = s2.toCharArray();

            int cntS1 = 0;
            int cntS2 = 0;

            for (int i = 0; i < s1Ar.length; i++) {
                cntS1 = cntS1 + ((s1Ar[i])-(int) 'a');
            }

            for (int i = 0; i < s1Ar.length; i++) {
                cntS2 = cntS2 + ((s2Ar[i])-(int)'a');
            }
            if(cntS1==cntS2)
                res  = true;
        }

        return res;
    }
    public static  void main(String[] args){
        if(checkAnagram("GAINLO","LAYING"))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

