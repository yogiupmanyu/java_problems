package java_problems.geeksfogeeks;

import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String,Integer> magazineWrdCnt = new HashMap<>();
        boolean resp = true;
        for(String wrd : magazine){
            magazineWrdCnt.put(wrd,(magazineWrdCnt.getOrDefault(wrd,0)+1));
        }
        for(String wrd : note){
            int cnt = magazineWrdCnt.getOrDefault(wrd,0);
            if(cnt==0){
                System.out.println("No");
                resp = false;
                break;
            }else{
                magazineWrdCnt.put(wrd,--cnt);
            }
        }
        if(resp){
            System.out.println("Yes");
        }

    }

   // private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        String[] mn = scanner.nextLine().split(" ");
//
//        int m = Integer.parseInt(mn[0]);
//
//        int n = Integer.parseInt(mn[1]);
//
//        String[] magazine = new String[m];
//
//        String[] magazineItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < m; i++) {
//            String magazineItem = magazineItems[i];
//            magazine[i] = magazineItem;
//        }
//
//        String[] note = new String[n];
//
//        String[] noteItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            String noteItem = noteItems[i];
//            note[i] = noteItem;
//        }

        String[] note = {"two","times","three","is","not","four"};
        String[] magazine = { "two" , "times","two","four" };
        checkMagazine(magazine, note);

        //scanner.close();
    }
}
