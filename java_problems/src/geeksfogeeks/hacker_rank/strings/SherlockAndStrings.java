package java_problems.geeksfogeeks.hacker_rank.strings;

public class SherlockAndStrings {
    public static String isValid(String s){

        char[] s_chars = s.toCharArray();
        int[] occur = new int[26];
        boolean removed_char = false;
        for(int i = 0; i < s.length(); i++ ){
            occur[s_chars[i] - 'a']++;
        }

        int max_occur =-1;
        for(int i =0; i < 26; i++){
            if(occur[i] == 0){
                continue;
            }else if(max_occur == -1){
                max_occur = occur[i];
                continue;
            }else if(occur[i] == max_occur){
                continue;
            }else if(!removed_char && (occur[i] == max_occur + 1 || occur[i] == 1)){
                removed_char = !removed_char;
                continue;
            }else{
                return "NO";
            }
        }

        return "YES";
    }

    public static  void main(String[] args){
        //String s = "abcdefghhgfedecba";
        String s = "aaabbccdd";
        System.out.println(isValid(s));
    }
}


