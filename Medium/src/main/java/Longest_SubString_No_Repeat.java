public class Longest_SubString_No_Repeat {
    /**
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int result=0;
        int max=result;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(set.contains(ch)){
                set.clear();set.add(ch);max=1;
            }else{
                set.add(ch);max++;
                if(max>result) result=max;
            }
        }
        return result;
    }*/
    public static int lengthOfLongestSubstring(String s) {
    int p1=0,p2=0,result=0;
     while(p2<s.length()){
         for(int i=p1;i<p2;i++){
             if(s.charAt(i)==s.charAt(p2)&&p1!=p2){
                 p1=i+1;break;
             }
         }
         result= (p2-p1+1)>result? (p2-p1+1):result;
         System.out.println(result);
         p2++;
     }
     return result;
    }

    public static void main(String[] args){
        String ss="abcabcbb";
        lengthOfLongestSubstring(ss);
    }
}
