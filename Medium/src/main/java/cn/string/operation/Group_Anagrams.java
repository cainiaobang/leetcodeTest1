package cn.string.operation;

import java.util.*;

public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return null;
        List<List<String>> result=new LinkedList<List<String>>();
        List<String> list=new LinkedList<String>();
        list.add(strs[0]);
        result.add(list);
        boolean flag=false;
        for(int i=1;i<strs.length;i++){
            ListIterator<List<String>> iterator=result.listIterator();
            flag=false;
            while(iterator.hasNext()){
                List<String> temp=iterator.next();
                String  tempString=temp.get(0);
                if(flag=isEqualString(tempString,strs[i])){
                    temp.add(strs[i]);break;
                }
            }
            if(!flag){
                List<String> newList=new LinkedList<String>();
                newList.add(strs[i]);
                result.add(newList);
            }
        }
        return result;
    }

    public boolean isEqualString(String s,String p){
        if(s.length()!=p.length()) return false;
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for(int j=0;j<p.length();j++){
            if(map.containsKey(p.charAt(j))){
                int value=map.get(p.charAt(j));
                if(value==1){
                    map.remove(p.charAt(j));
                }else{
                    map.put(p.charAt(j),value-1);
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] ab=new int[2];
        System.out.println(Arrays.toString(ab));
    }

}
