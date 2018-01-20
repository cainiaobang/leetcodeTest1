package cn.Trie;

public class Implement_Trie {
    /** Initialize your data structure here. */
    TreeNode root;
    public Implement_Trie() {
        root=new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
         TreeNode p=root;
         for(int i=0;i<word.length();i++){
             if(p.map[word.charAt(i)-'a']==null){
                 p.map[word.charAt(i)-'a']=new TreeNode();
             }
             p=p.map[word.charAt(i)-'a'];
         }
         p.exits = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode p=root;
        for(int i=0;i<word.length();i++){
            if(p.map[word.charAt(i)-'a']==null){
                return false;
            }
            p=p.map[word.charAt(i)-'a'];
        }
        return p.exits;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode p=root;
        for(int i=0;i<prefix.length();i++){
            if(p.map[prefix.charAt(i)-'a']==null){
                return false;
            }
            p=p.map[prefix.charAt(i)-'a'];
        }
        return true;
    }

    /**
    public boolean remove(String word){
        TreeNode p=root;
        for(int i=0;i<word.length();i++){
            if(p.map[word.charAt(i)-'a']==null){
                return false;
            }
            p=p.map[word.charAt(i)-'a'];
        }

    }
     */
}

class TreeNode{
    boolean exits;
    TreeNode[] map;

    public TreeNode() {
        this.exits = false;
        this.map = new TreeNode[26];
    }

}
