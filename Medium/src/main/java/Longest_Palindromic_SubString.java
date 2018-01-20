public class Longest_Palindromic_SubString {
     private  int length;
     private int len;
     private int maxlength;
      public  String longestPalindrome(String s) {
        length=s.length();
        if(length<=1) return s;
        for(int i=0;i<length-1;i++){
            isPalindromic(s,i-1,i+1);
            isPalindromic(s,i,i+1);
        }
      return s.substring(len,len+maxlength);
    }

    public void  isPalindromic(String s, int left,int right){
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;right++;
            }
            if((right-left-1)>maxlength) {
                len=left+1;
                maxlength=right-left-1;
            }
    }


    public static void main(String[] args){
        String ss="fbcda";
        Longest_Palindromic_SubString sm=new Longest_Palindromic_SubString();
       System.out.println(sm.longestPalindrome(ss));
    }
}
