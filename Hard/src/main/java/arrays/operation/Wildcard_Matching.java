package arrays.operation;

public class Wildcard_Matching {

    // not accetped : Time Limit Exceeded : Input:ss1="aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",ss2="a*******b"
    public boolean isMatch(String s, String p) {
        if(s.isEmpty()){
           return p.isEmpty() || (p.charAt(0)=='*'&&isMatch(s,p.substring(1)));
        }
        if(p.isEmpty()) return s.isEmpty() ;
         if(p.charAt(0)=='*'){
                return isMatch(s,p.substring(1)) || isMatch(s.substring(1),p);
            }else{
                boolean firstMatch=s.charAt(0)==p.charAt(0) || p.charAt(0)=='?';
                return firstMatch&&isMatch(s.substring(1),p.substring(1));
        }
    }

    public boolean isMatch2(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='*'&&dp[0][i])  dp[0][i+1]=true;
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(p.charAt(j)=='*'){
                      for(int k=0;k<=i;k++){
                          if(dp[k][j+1]){
                              dp[i+1][j+1]=true; break;
                          }
                      }
                      if(!dp[i+1][j+1]) dp[i+1][j+1]=dp[i+1][j];
                } else{
                    if(p.charAt(j)==s.charAt(i)|| p.charAt(j)=='?' || s.charAt(i)=='*')
                        dp[i+1][j+1]=dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args){
        String ss1="aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",ss2="a*******b";
        System.out.println(new Wildcard_Matching().isMatch2(ss1,ss2) );
    }
}
