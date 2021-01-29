package java_problems.geeksfogeeks;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;


/* Name of the class has to be "Main" only if the class is public. */
public class ReverseNumber
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here

        // your code goes here
        try{
            InputStreamReader r=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(r);
            Integer s = 0;
            while(s!=0){
                br.readLine();
                int t = 0;
                StringBuilder str = new StringBuilder(""+t);
                System.out.println(str.reverse());
                s--;
            }
        }catch(Exception e){
            e.printStackTrace();
            return ;
        }
    }
}
