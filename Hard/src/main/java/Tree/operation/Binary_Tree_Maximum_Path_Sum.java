package Tree.operation;

public class Binary_Tree_Maximum_Path_Sum {
    int result=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       maxUtil(root);
       return result;
    }
    public int maxUtil(TreeNode node){
        if(node==null) return 0;
        int temp=node.val;
        int left=maxUtil(node.left);
        if(left>0)temp+=left;
        int right=maxUtil(node.right);
        if(right>0) temp+=right;
        if(temp>result) result=temp;
        int max=Math.max(left,right);
        if(max>0) return node.val+max;
        else return node.val;
    }
}
