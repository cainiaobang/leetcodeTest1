package cn.string.operation;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        String[] map={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result=new LinkedList<String>();
        if(digits.length()>=1) {
            String str1=map[digits.charAt(0)-'2'];
            for(int i=0;i<str1.length();i++){
                result.add(str1.charAt(i)+"");
            }
        }
        for(int i=1;i<digits.length();i++){
            String  str=map[digits.charAt(i)-'2'];
            Object[] array=result.toArray();
            result.clear();
            for(int j=0;j<str.length();j++){
                for(int k=0;k<array.length;k++){
                    result.add((String)array[k]+str.charAt(j));
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        /**
        List<String> staff=new LinkedList<String>();
        staff.add("amy");staff.add("Bob");staff.add("Carl");
        ListIterator<String> iterator=staff.listIterator();
        int i=0;
        while(iterator.hasNext()){
            iterator.next();
            iterator.remove();
            iterator.add("add"+i++);
        }
        System.out.println(staff);
         */
        String ss="23";
        System.out.println(new LetterCombinations().letterCombinations(ss) );
    }
}
