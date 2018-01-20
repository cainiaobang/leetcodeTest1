package cn.String.operation;

public class Longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        StringBuilder result=new StringBuilder();
        boolean flag=true;
        int length=strs[0].length();
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<length) length=strs[i].length();
        }
        for(int i=0 ;i<length;i++){
            char ch=strs[0].charAt(i);
             for(int j=1;j<strs.length;j++){
                 if( strs[j].charAt(i)!=ch) {
                     flag=false;break;
                 }
             }
            if(flag) result.append(ch);
            else break;
        }
        return result.toString();
    }

    public static void main(String[] args){
        Longest_common_prefix ss=new Longest_common_prefix();
        String[] aa={"asde","asdf","asjk"};
        System.out.println(ss.longestCommonPrefix(aa));
    }

}
