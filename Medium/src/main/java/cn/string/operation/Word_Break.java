package cn.string.operation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<String>(wordDict);
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && set.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }


     class TrieNode {
        boolean isWord;
        TrieNode[] c;

        public TrieNode(){
            isWord = false;
            c = new TrieNode[128];
        }
    }

    public void addWord(TrieNode t, String w) {
        for (int i = 0; i < w.length(); i++) {
            int j = (int)w.charAt(i);
            if (t.c[j] == null) t.c[j] = new TrieNode();
            t = t.c[j];
        }
        t.isWord = true;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        TrieNode t = new TrieNode(), cur;
        for (String i : wordDict) addWord(t, i);
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[] f = new boolean[len + 1];
        f[len] = true;

        for (int i = len - 1; i >= 0; i--) {
            //System.out.println(str[i]);
            cur = t;
            for (int j = i; cur != null && j < len ; j++) {
                cur = cur.c[(int)str[j]];
                if (cur != null && cur.isWord && f[j + 1]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[0];
    }
}
