package String.operation;

import java.util.*;

public class Word_Ladder_II {

    /**
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> deque=new LinkedList<String>();
        Set<String> map=new HashSet<String>(wordList);
        Set<String> visited=new HashSet<String>();
        List<List<String>> result=new LinkedList<List<String>>();
        List<List<String>> tempList=new LinkedList<List<String>>();
        deque.add(beginWord);
        List<String> list=new LinkedList<String>();
        list.add(beginWord);
        tempList.add(list);
        boolean flag=false;
        int count=1;
        while(!deque.isEmpty()){
            int size=deque.size();
            List<List<String>> tempList2=new LinkedList<List<String>>();
            for(int num=0;num<size;num++){
                String word=deque.poll();
                char[] arrray=word.toCharArray();
                for(int i=0;i<word.length();i++){
                    char cha=arrray[i];
                    for(char ch='a';ch<='z';ch++){
                        arrray[i]=ch;
                        String temp=String.valueOf(arrray);
                        if(map.contains(temp)&&!visited.contains(temp)){
                            visited.add(temp);
                            deque.add(temp);
                            /**
                            Iterator<List<String>> iterator=tempList.listIterator();
                                while(iterator.hasNext()){
                                List<String> stringList=iterator.next();
                                stringList.add(temp);
                                tempList2.add(new ArrayList<String>(stringList));
                                if(temp.equals(endWord)) {
                                    result.add(new ArrayList<String>(stringList));
                                }
                            }

                        }
                    }
                    arrray[i]=cha;
                }
            }
           // System.out.println(tempList2);
            tempList=tempList2;
            if(flag) return result;
            count++;
        }
        System.out.println(count);
        return result;
    }
    */

    public static void main(String[] args){
        /**
       String beginWord = "hit";
       String endWord = "cog";
       String[]  wordList = {"hot","dot","dog","lot","log","cog"};
       List<String> list=Arrays.asList(wordList);
       System.out.println(new Word_Ladder_II().findLadders(beginWord,endWord,list));
         */
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MIN_VALUE);
    }
}
