package tree.operation;

import java.util.Stack;

public class Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q==null || p==null) return p==null&&q==null;
        Stack<TreeNode>  stackP=new Stack<TreeNode>();
        Stack<TreeNode> stackQ=new Stack<TreeNode>();
        while(p!=null || !stackP.empty()){
            while(p!=null){
                stackP.push(p);
                p=p.left;
            }
            while(q!=null){
                stackQ.push(q);
                q=q.left;
            }
            p=stackP.pop();
            q=stackQ.pop();
            if(p.val!=q.val) return false;
            p=p.right;
            q=q.right;
        }
        return  true;
    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
 }
