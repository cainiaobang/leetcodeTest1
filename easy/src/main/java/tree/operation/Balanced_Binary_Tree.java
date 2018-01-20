package tree.operation;

public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
       if(root==null) return true;
       int depthLeft=depth(root.left);
       int depthRight=depth(root.right);
       return Math.abs(depthLeft-depthRight)<=1&&isBalanced(root.right)&&isBalanced(root.left);
    }
    public int depth(TreeNode treeNode){
        if(treeNode==null) return 0;
        return Math.max(depth(treeNode.left),depth(treeNode.right))+1;
    }

    public boolean isBalanced2(TreeNode root) {
        return dfsHeight(root)!=-1;
    }
    public int dfsHeight(TreeNode treeNode){
        if(treeNode==null) return 0;
        int leftHeight=dfsHeight(treeNode.left);
        int rightHeight=dfsHeight(treeNode.right);
        if(Math.abs(leftHeight-rightHeight)>1) return -1;
        if(leftHeight==-1 || rightHeight==-1) return -1;
        return Math.max(leftHeight,rightHeight)+1;
    }

}
