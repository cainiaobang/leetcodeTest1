public class Climbing_Stairs {
    public int climbStairs(int n) {
        if(n>=2) return climbStairs(n-1)+climbStairs(n-2);
        else return 1;
    }

    //DP
    public int climbStairs2(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }

    public static void main(String[] args){
        String str="akdjkal";
        System.out.println(str.indexOf('.'));
    }

}
