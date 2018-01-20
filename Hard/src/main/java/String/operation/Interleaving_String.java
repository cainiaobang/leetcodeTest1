package String.operation;

import java.util.Arrays;

public class Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleaveUtil(s1,s2,s3,0,0,0);
    }
    public boolean isInterleaveUtil(String s1, String s2, String s3,int pos1,int pos2,int pos3) {
        while(pos3<=s3.length()){
            if(pos1==s1.length()){
                return s3.substring(pos3,s3.length()).equals(s2.substring(pos2,s2.length()));
            }
            if(pos2==s2.length()){
                return s3.substring(pos3,s3.length()).equals(s1.substring(pos1,s1.length()));
            }
            if(s3.charAt(pos3)==s1.charAt(pos1)&&s3.charAt(pos3)==s2.charAt(pos2)){
                return isInterleaveUtil(s1,s2,s3,pos1+1,pos2,pos3+1)||isInterleaveUtil(s1,s2,s3,pos1,pos2+1,pos3+1);
            }else if(s3.charAt(pos3)!=s1.charAt(pos1)&&s3.charAt(pos3)==s2.charAt(pos2)){
                pos3++;pos2++;
            }else if(s3.charAt(pos3)==s1.charAt(pos1)&&s3.charAt(pos3)!=s2.charAt(pos2)){
                pos3++;pos1++;
            }else
                return false;

        }
        return true;
    }

    public boolean is_Interleave(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
        if (memo[i][j] >= 0) {
            System.out.println(i+"   "+j);
            return memo[i][j] == 1 ? true : false;
        }
        boolean ans = false;
        if (s3.charAt(k) == s1.charAt(i) && is_Interleave(s1, i + 1, s2, j, s3, k + 1, memo)
                || s3.charAt(k) == s2.charAt(j) && is_Interleave(s1, i, s2, j + 1, s3, k + 1, memo)) {
            ans = true;
        }
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
    public boolean isInterleave2(String s1, String s2, String s3) {
        int memo[][] = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return is_Interleave(s1, 0, s2, 0, s3, 0, memo);
    }

    public static void main(String[] args){
        System.out.println(new Interleaving_String().isInterleave2("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));

    }
}
