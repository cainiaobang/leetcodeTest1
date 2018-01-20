package String.operation;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        int length=t.length();
        while(length<=s.length()){
            for(int i=0;i<=s.length()-length;i++){
                if(containString(s.substring(i,i+length),t))
                    return s.substring(i,i+length);
               // System.out.println(s.substring(i,i+length)+containString(s.substring(i,i+length),t));
            }
            length++;
        }
        return "";
    }
    public boolean containString(String s,String p){
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else
                map.put(s.charAt(i),1);
        }
        for(int i=0;i<p.length();i++){
            if(map.containsKey(p.charAt(i))){
                Integer value=map.get(p.charAt(i));
                if(value==0) return false;
                else map.put(p.charAt(i),value-1);
            }else
                return false;
        }
        return true;
    }

    public String minWindow2(String s, String t) {
        int[] char_num=new int[128];
        Arrays.fill(char_num,0);
        int begin=0,end=0,counter=t.length(),header=0,d= Integer.MAX_VALUE;
        for(int i=0;i<t.length();i++){
            char_num[t.charAt(i)]++;
        }
        while(end<s.length()){
            if(char_num[s.charAt(end++)]-->0) counter--;
            while(counter==0){
                if(end-begin<d){
                    header=begin;
                    d=end-begin;
                }
                if(char_num[s.charAt(begin++)]++==0) counter++;
            }
        }
        return (d==Integer.MAX_VALUE)? "" : s.substring(header,header+d);
    }

    public static void main(String[] args){
        System.out.println(new Minimum_Window_Substring().minWindow2("abc","c"));
    }
}
