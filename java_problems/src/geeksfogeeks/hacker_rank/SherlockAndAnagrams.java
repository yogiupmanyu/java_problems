package java_problems.geeksfogeeks;

public class SherlockAndAnagrams {

    private static void checkString(String s) {
        char[] sa;
        int c = 0;
        sa = s.toCharArray();
        for (int index = 1; index < sa.length; index++) {
            for (int i = 0; i < sa.length - index + 1; i++) {
                String s1 = s.substring(i, index + i);
                //System.out.println(s1);
               for (int j = i + 1; j < sa.length - index + 1; j++) {
                    String s2 = s.substring(j, index + j);
                    System.out.println(s1 + " " + s2);
                }
            }
        }

    }

    public static void  main(String[] args){
        checkString("LAYING");
    }


}
