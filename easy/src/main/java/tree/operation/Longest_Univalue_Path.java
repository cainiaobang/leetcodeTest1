package tree.operation;

public class Longest_Univalue_Path {
    /**
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        return longestUtil(root);
    }
    public int longestUtil(TreeNode node){
        if(node.left==null&&node.right==null){
           return 0 ;
        }else if(node.left==null){
            if(node.val==node.right.val){
                return longestUtil(node.right)+1;
            }else
                return longestUtil(node.right);
        }else if(node.right==null){
            if(node.val==node.left.val){
                return longestUtil(node.left)+1;
            }else
                return longestUtil(node.left);
        }else{
            if(node.val==node.left.val&&node.val==node.right.val){
                return longestUtil(node.left)+longestUtil(node.right)+2;
            }else if(node.val==node.left.val){
                return Math.max(longestUtil(node.left)+1,longestUtil(node.right));
            }else if(node.val==node.right.val){
                return Math.max(longestUtil(node.left),longestUtil(node.right)+1);
            }else{
                return Math.max(longestUtil(node.left),longestUtil(node.right));
            }
        }
    }
     */
}
