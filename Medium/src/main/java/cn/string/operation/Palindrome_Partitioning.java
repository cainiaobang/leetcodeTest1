package cn.string.operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<List<String>>();
        partitionUtil(s,result,new ArrayList<String>());
        return result;
    }
    public void partitionUtil(String s, List<List<String>> result,List<String> list){
        if(s.length()==0){
            result.add(new ArrayList<String>(list));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String temp=s.substring(0,i);
            if(isPalindrome(temp)){
                list.add(temp);
                partitionUtil(new String(s.substring(i)),result,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        int length=s.length();
        if(length%2==0){
            return isPalindromeUtil(s,(length>>1)-1,length>>1);
        }else{
            return isPalindromeUtil(s,length>>1,length>>1);
        }
    }
    public boolean isPalindromeUtil(String s,int posLeft,int posRight){
        while(posLeft>=0){
            if(s.charAt(posLeft--)!=s.charAt(posRight++)) return false;
        }
        return true;
    }

    public static void main(String[] args){
      System.out.println(new Palindrome_Partitioning().partition("ltsqjodzeriqdtyewsrpfscozbyrpidadvsmlylqrviuqiynbscgmhulkvdzdicgdwvquigoepiwxjlydogpxdahyfhdnljshgjeprsvgctgnfgqtnfsqizonirdtcvblehcwbzedsmrxtjsipkyxk"));
    }
}
