package String.operation;

import java.util.*;

public class Word_Ladder_II_2 {
    List<List<String>> result;
    Map<String,List<String>> map;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<String>(wordList);
        map=new HashMap<String, List<String>>();
        Map<String,Integer> ladder=new HashMap<String, Integer>();
        for(String str:set)
            ladder.put(str,Integer.MAX_VALUE);
        ladder.put(beginWord,0);
        Queue<String> queue=new ArrayDeque<String>();
        queue.add(beginWord);
        set.add(endWord);
        int min=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            String word=queue.poll();
            int step=ladder.get(word)+1;
            if(step>min) break;
            for(int i=0;i<word.length();i++){
                StringBuilder builder=new StringBuilder(word);
                for(char ch='a';ch<='z';ch++){
                    builder.setCharAt(i,ch);
                    String new_word=builder.toString();
                    if(ladder.containsKey(new_word)){
                        if(step>ladder.get(new_word))
                            continue;
                        else if(step<ladder.get(new_word)){
                            ladder.put(new_word,step);
                            queue.add(new_word);
                        }else;
                        if(map.containsKey(new_word)){
                            map.get(new_word).add(word);
                        }else{
                            List<String> list=new ArrayList<String>();
                            list.add(word);
                            map.put(new_word,list);
                        }
                        if(new_word.equals(endWord)) min=step;
                    }

                }
            }
        }
        result=new ArrayList<List<String>>();
        List<String> list=new LinkedList<String>();
        backTrace(endWord,beginWord,list);
        return result;
    }


    public void backTrace(String word,String beginWord,List<String>  list ){
        if(word.equals(beginWord)){
            list.add(0,word);
            result.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if(map.get(word)!=null){
            for(String str:map.get(word)){
                backTrace(str,beginWord,list);
            }
        }
        list.remove(0);
    }

    public static void main(String[] args){

    }

}

