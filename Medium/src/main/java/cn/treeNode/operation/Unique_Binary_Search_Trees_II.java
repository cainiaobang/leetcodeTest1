package cn.treeNode.operation;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_II {
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new ArrayList<TreeNode>();
        return generateTreesUtil(1,n);
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

    public static List<TreeNode> generateTrees2(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return result[0];
        }

        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    public static void main(String[] args){
        System.out.println(new Unique_Binary_Search_Trees_II().generateTrees2(4).size());
    }
}

