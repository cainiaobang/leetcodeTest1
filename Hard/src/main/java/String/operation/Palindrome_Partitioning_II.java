package String.operation;

public class Palindrome_Partitioning_II {
    int res;
    public int minCut(String s) {
       res =Integer.MAX_VALUE;
       minCutUtil(s,0,0);
       return res-1;
    }
    public void  minCutUtil(String s, int pos, int count){
        if(pos>=s.length()){
            if(count<res){
                res=count;return;
            }
        }
        for(int i=s.length()-1;i>=pos;i--){
            if(isPalindrome(s,pos,i)){
                minCutUtil(s,i+1,count+1);
                return;
            }
        }
    }
    public boolean isPalindrome(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left++)!=s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(new Palindrome_Partitioning_II().minCut("aab"));
    }
}
