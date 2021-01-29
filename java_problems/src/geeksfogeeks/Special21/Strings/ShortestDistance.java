package java_problems.geeksfogeeks.Special21.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ShortestDistance {

    static Vector<Integer> shortestDistance(String S, char X)
    {
        // Your code goes here
        Vector<Integer> res = new Vector<>();
        Map<Character,Integer> posMp = new HashMap<>();
        for(int i=0;i<S.length();i++){
            if(!posMp.containsKey((Character)S.charAt(i))){
                posMp.put((Character)S.charAt(i),i);
            }
        }
        Integer t1 = posMp.get((Character)X);
        for(int i=0;i<S.length();i++){
            Integer t2 = posMp.get((Character)S.charAt(i));
            res.add(Math.abs(t1-t2));
        }
        return res;
    }

    public static void main(String[] args){
        String s = "geeksforgeeks";
        char X = 'e';
        System.out.println(shortestDistance(s,X).toString());
    }
}
