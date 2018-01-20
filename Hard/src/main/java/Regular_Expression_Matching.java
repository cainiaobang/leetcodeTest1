
enum Result {
    TRUE, FALSE
}

// 我的解法，DP，从上往下
public class Regular_Expression_Matching {
    private  Result[][] memo;
    public  boolean isMatch(String s, String p) {
        memo =new Result[s.length()+1][p.length()+1];
        memo[0][0]=Result.TRUE;
        for(int i=1;i<=s.length();i++){
            memo[i][0]=Result.FALSE;
        }
        if (p.length()>0) memo[0][1]=Result.FALSE;
        for(int j=2;j<=p.length();j++){
            if(p.charAt(j-1)=='*')
                memo[0][j]=memo[0][j-2];
            else
                memo[0][j]=Result.FALSE;
        }
        return dp(s.length(),p.length(),s,p);
    }
    public  boolean dp(int i, int j, String s,String p){
        if(memo[i][j]!=null){
         //  System.out.println(i+","+j+","+memo[i][j]);
            return memo[i][j]==Result.TRUE;
      }
        if(i>0&&j>0&&(p.charAt(j-1)=='.'|| s.charAt(i-1)==p.charAt(j-1))){
           //System.out.println(i+", "+j+","+"first_match");
            return  dp(i-1,j-1,s,p);
        }
        else if(j>0&&p.charAt(j-1)=='*'){
           // System.out.println("second  third");
            if(i>0&&j>1&&p.charAt(j-2)!=s.charAt(i-1)&&p.charAt(j-2)!='.'){
              //  System.out.println(i+", "+j+","+"second_match");
                return dp(i,j-2,s,p);
            }
            else if(i>0&&j>1&&(p.charAt(j-2)==s.charAt(i-1)|| p.charAt(j-2)=='.'))
            {
               // System.out.println(i+", "+j+","+"third_match");
                return  dp(i,j-2,s,p)||dp(i,j-1,s,p)||dp(i-1,j,s,p);
            }
        }
         return false;
    }



    // 推荐的方法，不适合实例（""，"*")
    public boolean isMatch２(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args){
        String s="";
        String p="*";
        System.out.println(new Regular_Expression_Matching().isMatch２(s,p));
    }
}

