package cn.string.operation;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Valid_Parentheses {
    public boolean isValid(String s) {
        LinkedList<Character> list=new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='(')list.add(')');
           else if(s.charAt(i)=='[') list.add(']');
           else if(s.charAt(i)=='{') list.add('}');
           else if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){
              if(list.size()<=0|| !list.pollLast().equals(s.charAt(i))) return false;
           }
        }
        if(list.size()==0) return true;
        else return false;
    }

    public static void main(String[] args){
        System.out.println(new  Valid_Parentheses().isValid("()"));
    }
}
