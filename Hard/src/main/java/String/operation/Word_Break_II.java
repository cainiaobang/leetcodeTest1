package String.operation;

import java.util.*;

public class Word_Break_II {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(wordDict.size()<=0) return new ArrayList<String>();
        Set<String> set=new HashSet<String>(wordDict);
        List<String> result=new ArrayList<String>();
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        List<List<Integer>> map=new ArrayList<List<Integer>>(s.length());
        for(int i=0;i<s.length();i++){
            map.add(new ArrayList<Integer>());
        }
        for(int i=0;i<s.length();i++){
            for(int j=i;j>=0;j--){
                if(dp[j]&&set.contains(s.substring(j,i+1))){
                   dp[i+1]=true;
                   List<Integer> list=map.get(i);
                   list.add(j);
                }
            }
        }
        if(!dp[s.length()]) return result;
        addUtil(map,result,s,s.length()-1,new StringBuilder());
        return result;
    }
    public void addUtil(List<List<Integer>> map, List<String> result,String s,int pos,StringBuilder temp){
        if(pos<0){
            String[] str=temp.toString().split(",");
            StringBuilder tempString=new StringBuilder();
            for(int i=str.length-1;i>=0;i--){
                tempString.append(str[i]);
                tempString.append(" ");
            }
            tempString.delete(tempString.length()-1,tempString.length());
            result.add(tempString.toString());
            return;
        }
        List<Integer> list=map.get(pos);
        Iterator<Integer> iterator=list.iterator();
        while(iterator.hasNext()){
            Integer num=iterator.next();
            temp.append(s.substring(num,pos+1));
            temp.append(",");
            addUtil(map,result,s,num-1,temp);
            temp.delete(temp.length()-(pos-num+2),temp.length());
        }
    }

    public static void main(String[] args){
        String[] str={"cat", "cats", "and", "sand", "dog"};
        List<String> list=Arrays.asList(str);
        System.out.println(new Word_Break_II().wordBreak("catsanddog",list));
        System.out.println("asdf".substring(2));
    }

}
