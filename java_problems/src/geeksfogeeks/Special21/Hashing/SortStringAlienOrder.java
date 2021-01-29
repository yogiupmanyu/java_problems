package java_problems.geeksfogeeks.Special21.Hashing;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//
//Sort strings lexicographically according to given sequence of characters
//Given a string of lower case letters alphabets representing alphabetical order in an alien language. Sort the given list of words lexicographically according to that order.
//        Words will contain only those letters which are the in the alphabets string.
//
//        Input:
//        First line of input consists of number of test cases t. Then t test cases follow. In each test case first line consists of the string alphabets. Second line of test case consists of an integer n, representing the number of words to be sorted. Third line holds the n space separated strings which are to be sorted.
//
//        Output:
//        Output contains the n sorted strings in a single line separated by spaces.
//
//        Constraints:
//        Your task is to complete the function sort_by_order(), which sorts the words as explained. Do not print anything.
//
//        Example:
//        Input:
//        1
//        qwerty
//        5
//        we qwer erer qw errr
//        Output:
//        qw qwer we erer errr

public class SortStringAlienOrder {


    private  static String sortTheString(String s){
        StringBuilder res = new StringBuilder();
        char[] chr = s.toCharArray();
        List<Integer> t = new ArrayList<>();
        for(Character c : chr){
            t.add((int)c);
        }
        Collections.sort(t);
        for(int var : t){
            res.append((char)var);
        }
        return  res.toString();
    }
    public String[] sortByOrder(String[] words, String alphabets )
    {
        // Write your code here
        HashMap<Integer,Character> chrPos = new HashMap<>();
        int i = 0;
        for(Character c : alphabets.toCharArray()){
            chrPos.put(i,c);
            i++;
        }
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String[] res = new String[words.length];
        int j = 0;
        for(String wrd : words){
            j = 0;
            for(Character al : alphabet){
                wrd = wrd.replaceAll("a",chrPos.get(j)+"");
            }
        }
        int k = 0;
        for(String wr : words){
            res[k] = sortTheString(wr);
            k++;
        }
        return res;
    }
}
