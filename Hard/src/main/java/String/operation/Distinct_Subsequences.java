package String.operation;

public class Distinct_Subsequences {
    public int numDistinct(String s, String t) {
        if(s.length()<t.length()) return 0;
        boolean[] mark=new boolean[s.length()];
        return numUtil(s,t,0,0,mark);
    }
    public int numUtil(String s,String t,int left,int count,boolean[] mark){
        if(s.length()==t.length()+count){
           StringBuilder temp=new StringBuilder();
           for(int j=0;j<s.length();j++){
               if(!mark[j]) temp.append(s.charAt(j));
           }
           return temp.toString().equals(t)? 1:0;
        }
        int sum=0;
        for(int i=left;i<s.length();i++){
            mark[i]=true;
            sum+=numUtil(s,t,i+1,count+1,mark);
            mark[i]=false;
        }
        return sum;
    }

    public int numDistinct2(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length();i++) dp[i][0]=1;
        for(int i=0;i<t.length();i++){
            for(int j=0;j<s.length();j++){
                if(t.charAt(i)==s.charAt(j)){
                    dp[j+1][i+1]=dp[j][i+1]+dp[j][i];
                }else{
                    dp[j+1][i+1]=dp[j][i+1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public int numDistinct3(String s,String t){
        int[] dp=new int[t.length()+1];
        dp[0]=1;
        /**
        for(int i=0;i<t.length();i++){
            for(int j=0;j<s.length();j++){
                if(t.charAt(i)==s.charAt(j)){
                    dp[i+1]=dp[i]+dp[i+1];
                }
            }
        }
         */
        for(int j=1;j<=s.length();j++){

            for(int i=0;i<t.length();i++){
                if(s.charAt(j-1)==t.charAt(i)){
                    dp[i+1]=dp[i]+dp[i+1];
                }
             }
             /**
            for(int i=t.length();i>0;i--){
                if(s.charAt(j-1)==t.charAt(i-1))
                    dp[i]=dp[i-1]+dp[i];
            }
              */
        }
        return dp[t.length()];
    }

    public static void main(String[] args){
        String s1="bccbcdcabadabddbccaddcbabbaaacdba";
        String s2="bccbbdc";
        System.out.println(new Distinct_Subsequences().numDistinct(s1,s2));
    }
}
