package Tree.operation;

import java.util.Stack;

public class Recover_Binary_Search_Tree {
    public void recoverTree(TreeNode root) {
        TreeNode treeNode=root,prev=null;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(treeNode!=null || !stack.isEmpty()){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode=treeNode.left;
            }
            treeNode=stack.pop();
            if(prev!=null&&treeNode.val<prev.val){
               treeNode.left=treeNode.right;
               treeNode.right=prev;
                break;
            }
            prev=treeNode;
            treeNode=treeNode.right;
        }
    }

    public static void main(String[] args){
        TreeNode treeNode=new TreeNode(0);
        treeNode.left=new TreeNode(1);
        new Recover_Binary_Search_Tree().recoverTree(treeNode);
    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
