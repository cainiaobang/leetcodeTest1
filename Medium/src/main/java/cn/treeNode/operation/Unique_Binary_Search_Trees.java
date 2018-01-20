package cn.treeNode.operation;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees {
    public int  generateTrees(int n) {
        if(n<=0) return 0;
        return generateTreesUtil(1,n).size();
    }
    public List<TreeNode> generateTreesUtil(int left,int right){
        List<TreeNode> result=new ArrayList<TreeNode>();
        if(left>right){
            result.add(null);
            return result;
        }
        if(left==right){
            result.add(new TreeNode(left));
            return result;
        }
        for(int i=left;i<=right;i++){
            List<TreeNode> lefts=generateTreesUtil(left,i-1);
            List<TreeNode> rights=generateTreesUtil(i+1,right);
            for(TreeNode nodeLeft:lefts){
                for(TreeNode nodeRight:rights){
                    TreeNode treeNode=new TreeNode(i);
                    treeNode.left=nodeLeft;
                    treeNode.right=nodeRight;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }

    public int  numTrees(int n) {
        if(n<=0) return 0;
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int left=1;left<=n;left++){
            for(int j=0;j<left;j++){
                dp[left]+=dp[j]*dp[left-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.println(new Unique_Binary_Search_Trees().numTrees(3));
    }
}
