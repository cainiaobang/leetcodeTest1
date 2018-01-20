public class String_to_Integer {

    //
    public int myAtoi(String str) {
        if(str.length()==0) return 0;
        String ss=str.trim();
        int  flag=0;
        if(ss.charAt(0)=='-'){
            flag=1;
        }else if(ss.charAt(0)=='+'){
            flag=2;
        }else if(ss.charAt(0)>='0'&&ss.charAt(0)<='9'){
            flag=2;ss="+"+ss;
        }else{
            return 0;
        }
        double result=0;
        for(int i=1;i<ss.length();i++){
           char ch=ss.charAt(i);
           if(ch>='0'&&ch<='9') {
               result=result*10+(ch-'0');
           }
           else break;
        }
        if(flag==1)  result=-result;
        if(result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else   return (int)result;
    }


    //str=str.trim();调用，节省了很多时间
    public int myAtoi2(String str) {
        int sign=1,base=0,i=0;
        if(str==null || str.length()==0) return 0;
        str=str.trim();
        int length=str.length();
        if(str.charAt(i)=='+' || str.charAt(i)=='-') {
           sign=1-2*(int)((str.charAt(i++)=='-')? 1:0);
        }
        while(i<length&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            if(base>Integer.MAX_VALUE/10 || base==Integer.MAX_VALUE/10 &&str.charAt(i)-'0'>7){
                if (sign==1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            base=base*10+str.charAt(i++)-'0';
         }
        return base*sign;

    }
    public static void main(String[] args){
      String_to_Integer mm=new String_to_Integer();
      String ss="214748364";
      System.out.println(mm.myAtoi2(ss));
    }
}
