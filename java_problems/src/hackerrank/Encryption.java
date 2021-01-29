package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        String withOutSpace = s.replaceAll("\\s", "");
        int len = withOutSpace.length();
        double L = Math.sqrt(len);
        int R = ((Double)Math.floor(L)).intValue();
        int C = ((Double)Math.ceil(L)).intValue();

        StringBuilder res = new StringBuilder();
        for(int i = 0;i<C;i++){
            for(int j= i;j<withOutSpace.length();j+=C){
                res.append(withOutSpace.charAt(j));
            }
            res.append(" ");
        }

        String r = "strawberries";
        System.out.println(r.substring(2,5));
        if(r instanceof  Object){
            System.out.println("oinksdfnh");
        }
        return res.toString();
    }

    public static void main(String[] args){
        String s = "if man was meant to stay on the ground god would have given us roots";
        System.out.println(encryption(s));
    }
}
