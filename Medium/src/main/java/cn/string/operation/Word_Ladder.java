package cn.string.operation;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.*;

public class Word_Ladder {

    private int result;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] mark=new boolean[wordList.size()];
        ladderUtil(beginWord,endWord,wordList,mark,0);
        return result;
    }

    public void  ladderUtil(String currentword,String endword,List<String> wordList,boolean[] mark,int count){
        if(count>wordList.size()) return ;
        if(currentword.equals(endword)){
            if(result==0 || result>count+1 ){
                result=count+1;
            }
            return;
        }
        for(int i=0;i<wordList.size();i++){
            if(!mark[i]){
                String temp=wordList.get(i);
                if(isSimilar(currentword,temp)){
                    mark[i]=true;
                    ladderUtil(temp,endword,wordList,mark,count+1);
                    mark[i]=false;
                }
            }
        }
    }

    public boolean isSimilar(String s1,String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) count++;
        }
        return count==1;
    }


    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList<String>();
        queue.add(beginWord);
        boolean[] mark=new boolean[wordList.size()];
        Iterator<String> it=wordList.iterator();
        int countNum=0;
        while(it.hasNext()){
            if(it.next().equals(beginWord)) {mark[countNum]=true;}
            countNum++;
        }
        int result=1;
        while(!queue.isEmpty()){
            int count=queue.size();
            for(int i=0;i<count;i++){
                String temp=queue.poll();
                if(temp.equals(endWord)) return result;
                ListIterator<String> iterator=wordList.listIterator();
                countNum=0;
                while(iterator.hasNext()){
                    String str=iterator.next();
                    if(!mark[countNum]&&isSimilar(temp,str)){
                        queue.add(str);
                        mark[countNum]=true;
                    }
                    countNum++;
                }
            }
            result++;
        }
        return 0;
    }

    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> head=new LinkedList<String>();
        LinkedList<String> tail=new LinkedList<String>();
        LinkedList<String> pHead,pTail;
        head.add(beginWord);
        if(!wordList.contains(endWord))  return 0;
        tail.add(endWord);
        int count=2;
        while(!head.isEmpty()&&!tail.isEmpty()){
            if(head.size()<tail.size()){
                pHead=head;
                pTail=tail;
            }else{
                pHead=tail;
                pTail=head;
            }
           LinkedList<String> list=new LinkedList<String>();
            Iterator<String> iterator=pHead.iterator();
            while(iterator.hasNext()){
                StringBuilder word=new StringBuilder(iterator.next());
                wordList.remove(word.toString());
                for(int i=0;i<word.length();i++){
                    char ch=word.charAt(i);
                    for(int j=0;j<26;j++){
                        char ch2=(char)('a'+j);
                        word.setCharAt(i,ch2);
                        if(pTail.contains(word.toString())){
                            return count;
                        }
                        if(wordList.contains(word.toString())){
                            list.add(word.toString());
                            wordList.remove(word.toString());
                        }
                    }
                    word.setCharAt(i,ch);
                }
            }
            count++;
            if(pHead==head){
                head=list;
            }else{
                tail=list;
            }
        }
        return 0;
    }

    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
        Set<String> dist=new HashSet<String>(wordList);
        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        if(!dist.contains(endWord)) return 0;
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && dist.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }
    public static void main(String[] args){

     String beginWord = "qa";
     String endWord =  "sq";
      String[]  wordList = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca",
              "br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo",
              "as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me",
              "mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};


        /**
        String beginWord="hit";
        String endWord="cog";
        String[] wordList={"hot","dot","dog","lot","log","cog"};
         */
      List<String> list;
      list=new LinkedList<String>(Arrays.asList(wordList));
      System.out.println(new Word_Ladder().ladderLength4(beginWord,endWord,list) );

    }
}
