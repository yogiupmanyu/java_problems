package java_problems.geeksfogeeks;
import java.util.*;
import java.util.Scanner;

// Write your code here. DO NOT use an access modifier in your class declaration.
class Parser {
    public boolean isBalanced(String s){
        boolean res = true;
        if( s.length()<50){
            char[] str = s.toCharArray();
            Stack<Character> chrCnt = new Stack<>();
            for(Character c : str){
                if((c.equals('{') || c.equals('}') || c.equals('(') || c.equals(')'))){
                    if(c.equals('{') || c.equals('(')){
                        chrCnt.push(c);
                    }else if(c.equals('}')){
                        if(chrCnt.empty()){
                            res = false;
                            break;
                        }else{
                            if(!chrCnt.pop().equals('{')){
                                res = false;
                                break;
                            }
                        }
                    }else if(c.equals(')')){
                        if(chrCnt.empty()){
                            res = false;
                            break;
                        }else{
                            if(!chrCnt.pop().equals('(')){
                                res = false;
                                break;
                            }
                        }
                    }
                }else{
                    res = false;
                }
            }
            if(chrCnt.size()>0){
                res = false;
            }
        }else{
            res = false;
        }
        return res;
    }
}
public class HackerRank2 {


    public static void main(String[] args) {
        Parser parser = new Parser();

//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNext()) {
//            System.out.println(parser.isBalanced(in.next()));
//        }
//
//        in.close();

       System.out.println(parser.isBalanced("{}()"));
    }
}
