package cn.lists.String.operation;

import java.util.*;


public class Substring_with_Concatenation_of_All_Words {

    // 方法一，运算很缓慢。
    public List<Integer> findSubstring(String s, String[] words) {
        Set<Integer> result=new HashSet<Integer>();
        List<Integer> end=new LinkedList<Integer>();
        findString(result,"",words,s);
        Iterator<Integer> iterator=result.iterator();
        while(iterator.hasNext()){
            end.add(iterator.next());
        }
        return end;
    }
     public void  findString(Set list,String sb,String[] words,String s){
            if(words.length==1){
                String mm=sb+words[0];
                int pos=s.indexOf(mm);
                while(pos!=-1){
                    list.add(pos);
                    pos=s.indexOf(mm,pos+1);
                }
            }else{
                 int length;
                String[] word=new String[words.length-1];
                for(int i=0;i<words.length;i++){
                    length=0;
                    for(int j=0;j<words.length;j++){
                        if(j!=i)word[length++]=words[j];
                    }
                    findString(list,sb+words[i],word,s);
                }
            }
     }


 //非常巧妙的方法
    public List<Integer> findSubstring2(String s, String[] words) {
         Map<String,Integer> count=new HashMap<String, Integer>();
         for(String word: words){
             count.put(word,count.getOrDefault(word,0)+1);
         }
         List<Integer> result=new LinkedList<Integer>();
         int n=s.length(),num=words.length,len=words[0].length();
         for(int i=0;i<n-len*num+1;i++){
             int j=0;
             Map<String,Integer> seen=new HashMap<String, Integer>();
             while(j<num){
                 String subString=s.substring(i+j*len,i+(j+1)*len);
                 if(count.containsKey(subString)){
                     seen.put(subString,seen.getOrDefault(subString,0)+1);
                     if(seen.get(subString)>count.get(subString)) break;
                     j++;
                 }else{
                     break;
                 }
             }
             if(j==num) result.add(i);
         }
         return result;
    }

    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> ret = new ArrayList<Integer>();
        int lenS = s.length();
        if (lenS == 0) return ret;
        int size = words[0].length(), lenW = words.length;
        if (size * lenW > lenS) return ret;
        HashMap<String, Integer> map = new HashMap<String ,Integer>();
        int[][] table = new int[2][lenW];
        int index = 0, count = 0;
        for (String str : words) {
            Integer p = map.get(str);
            if (p == null) {
                count++;
                map.put(str, index);
                p = index;
                index++;
            }
            table[0][p]++;
        }
        int[] mapping = new int[lenS - size + 1];
        for (int i = 0; i <= lenS - size; i++) {
            String tmp = s.substring(i, i + size);
            Integer p = map.get(tmp);
            if (p == null) mapping[i] = -1;
            else mapping[i] = p;
        }
        for (int i = 0; i < size; i++) {
            int len = count;
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            while (right <= lenS - size) {
                while (len > 0 && right <= lenS - size) {
                    int p = mapping[right];
                    if (p != -1) {
                        table[1][p]++;
                        if (table[1][p] == table[0][p]) len--;
                    }
                    right += size;
                }
                System.out.println(right+"     "+i );
                while (len == 0 && left < right) {
                    int p = mapping[left];
                    if (p != -1) {
                        if (table[1][p] == table[0][p]) len++;
                        table[1][p]--;
                        if ((right - left) == (size * lenW)) ret.add(left);
                    }
                    left += size;
                }
                System.out.println(left+"     "+i);
            }
        }
        return ret;
    }

     public static void main(String[] args){
         //"fosbafo"6
         // oobafo"12
         //
         String s1="fosbafo" +
                 "oobafo";
         String[] words={"fo","ba"};
         System.out.println(new  Substring_with_Concatenation_of_All_Words().findSubstring3(s1,words));

     }
}
