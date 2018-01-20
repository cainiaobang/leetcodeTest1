package String.operation;

public class Valid_Number {
    public boolean isNumber(String s) {
        s=s.trim();
        if(s.length()!=0&&(s.charAt(0)=='-' || s.charAt(0)=='+')) s=s.substring(1,s.length());
       if(s.length()==0) return false;
       int i=1,count_e=0,count_point=0;
       if((s.charAt(0)-'0'<0 || s.charAt(0)-'9'>0)) {
           if(s.charAt(0)!='.')
           return false;
           else {
               count_point++;
               if (s.length() < 2) return false;
               else if (s.charAt(1) - '0' < 0 || s.charAt(i) - '9' > 0) {
                   return false;
                 }
               }
           }
        while (i<s.length()){
             char ch=s.charAt(i++);
             if(ch-'0'<0 || ch-'9'>0){
                 if(ch=='.') {
                     count_point++;
                     if(count_point>1) return false;
                 }else if(ch=='e'){
                     count_e++;
                     if(count_e>1 || i==s.length() ) return false;
                     if(s.charAt(i)=='+' || s.charAt(i)=='-') {
                         i++;
                         if(i==s.length()) return false;
                     }
                     count_point=1;
                 }
                 else
                     return false;
             }
       }
       return true;
    }
}
