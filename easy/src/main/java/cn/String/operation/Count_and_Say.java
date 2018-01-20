package cn.String.operation;

public class Count_and_Say {
    public String countAndSay(int n) {
        if(n==1) return "1";
        StringBuilder s=new StringBuilder("1");
        int i=1,count=0;
        while(i<n){
            StringBuilder m=new StringBuilder("");
            for(int j=0;j<s.length();j++){
                count=1;
                while((j+1)<s.length()&&s.charAt(j)==s.charAt(j+1)){
                    count++;j++;
                }
               m.append(count);m.append(s.charAt(j));
            }
            s=m;i++;
        }
        return s.toString();
    }

    public static void main(String[] args){
        System.out.println(new Count_and_Say().countAndSay(4) );
    }
}
