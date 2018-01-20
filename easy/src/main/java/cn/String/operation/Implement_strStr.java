package cn.String.operation;

public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
         return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
        boolean flag=true;
        int length1=haystack.length();
        int length2=needle.length();
        for(int i=0;i<=length1-length2;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                for(int j=1;j<length2;j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        flag=false;break;
                    }
                }
                if(flag) return i;
            }
            flag=true;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(new Implement_strStr().strStr2("mississippi","issip") );
    }
}
