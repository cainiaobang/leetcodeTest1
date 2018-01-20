package cn.lists.cn.String;

import java.util.LinkedList;
import java.util.List;

public class Longest_Valid_Parentheses {

    //
    public int longestValidParentheses(String s) {
        int count=0;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+2;j<=s.length();j=j+2){
                if(isValid(s.substring(i,j))&&(j-i)>count) count=j-i;
            }
        }
        return count;
    }

    public boolean isValid(String s){
        LinkedList<Character> list=new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);
            if(s.charAt(i)=='(')list.add(')');
            else {
                if(list.size()<=0|| !list.removeLast().equals(s.charAt(i))) return false;
            }
        }
        return  list.isEmpty();
    }

    public int longestValidParentheses2(String s) {
        int count=0,numLeft=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') numLeft++;
            else {
                if(numLeft>0) count++;
                numLeft--;
            }
        }
        return count*2;
    }

    public static void main(String[] args){
        String ss="(()()(";
        System.out.println(new  Longest_Valid_Parentheses().longestValidParentheses2(ss));
    }

}
