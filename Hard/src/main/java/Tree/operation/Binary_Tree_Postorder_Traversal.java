package Tree.operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        postorderUtil(root,result);
        return result;
    }
    public void postorderUtil(TreeNode root, List<Integer> result){
        if(root==null)  return;
        if(root.left!=null) postorderUtil(root.left,result);
        if(root.right!=null) postorderUtil(root.right,result);
        result.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> result=new LinkedList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                result.add(0,root.val);
                root=root.right;
            }
            root=stack.pop().left;
        }
        return result;
    }

}
