package cn.string.operation;

import java.util.Arrays;

public class Decode_Ways {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        return DecodeUtil(s,0);
    }

    public  int DecodeUtil(String s, int left){
        if(left<s.length()-1){
           int num=(s.charAt(left)-'0')*10+(s.charAt(left+1)-'0');
           if(num<=26&&num>=11) return DecodeUtil(s,left+1)+DecodeUtil(s,left+2);
           else if(num==10) return DecodeUtil(s,left+2);
           else if(num>26) return DecodeUtil(s,left+1);
           else return 0;
        }else if(left==s.length()-1)
            if(s.charAt(left)-'0'>0&&s.charAt(left)-'0'<=9)
                return 1;
            else return 0;
        else {
            return 1;
        }
    }


    /**
    public int  numDecodings2(String s) {
        if(s.length()==0) return 0;
        int[] nums=new int[s.length()+1];
        nums[0]=1;
        int left=0;
        while(left<s.length()) {
            if (left < s.length() - 1) {
                int num = (s.charAt(left) - '0') * 10 + s.charAt(left + 1) - '0';
                if (num >= 11 && num <= 26) {
                    nums[1 + left] = nums[left];
                    nums[2 + left] = nums[left] + nums[left+1];
                    left = left + 2;
                } else if (num == 10) {
                    nums[1 + left] = 0;
                    nums[2 + left] = nums[left];
                    left = left + 2;
                } else if (num > 26) {
                        nums[1 + left] = nums[left];
                        left++;
                } else {
                    if (left > 0) {
                        int n = s.charAt(left - 1) - '0';
                        if (n >= 1 && n <= 2) {
                            nums[1 + left] = nums[left - 1];
                            nums[left] = 0;
                            left++;
                        } else
                            return 0;

                    } else
                        return 0;
                }
            } else {
                if (s.charAt(left) - '0' > 0 && s.charAt(left) - '0' <= 9) {
                    nums[1 + left] = nums[left];
                    left++;
                } else if (s.charAt(left) == '0') {
                    if (left > 1) {
                        int num = s.charAt(left - 1) - '0';
                        if (num >= 1 && num <= 2) {
                            nums[1 + left] = nums[left - 1];
                            nums[left] = 0;
                            left++;
                        } else {
                            return 0;
                        }
                    } else
                        return 0;
                } else
                    return 0;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return nums[s.length()];
    }
     */

    public int  numDecodings3(String s) {
        if(s.length()==0) return 0;
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        if(s.charAt(0)=='0'){
            return 0;
        }else{
            dp[1]=1;
        }
        int left=1;
        while(left<s.length()){
            if(s.charAt(left)!='0'){
                int num=(s.charAt(left-1)-'0')*10+(s.charAt(left)-'0');
                if(num>=11&&num<=26) {
                    dp[1 + left] = dp[left] + dp[left - 1];
                    left++;
                }else {
                    dp[1+left]=dp[left];
                    left++;
                }
            }else{
                if(s.charAt(left-1)=='1' || s.charAt(left-1)=='2'){
                    dp[1+left]=dp[left-1];
                    left++;
                }else
                    return 0;
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
    public static void main(String[] args){
        System.out.println(new Decode_Ways().numDecodings3("111"));
    }

}
