package cn.treeNode.operation;

import java.util.Stack;

public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(!isValidLeft(root.left,root.val) || !isValidRight(root.right,root.val)) return false;
        return isValidBST(root.left)&&isValidBST(root.right);
    }
    public boolean isValidLeft(TreeNode p,int val){
        if(p==null) return true;
        if(p.val>=val) return false;
        if(!isValidLeft(p.left,val)|| !isValidLeft(p.right,val)) return false;
        return true;
    }
    public boolean isValidRight(TreeNode p,int val){
        if(p==null) return true;
        if(p.val<=val) return false;
        if(!isValidRight(p.left,val)|| !isValidRight(p.right,val)) return false;
        return true;
    }

}
