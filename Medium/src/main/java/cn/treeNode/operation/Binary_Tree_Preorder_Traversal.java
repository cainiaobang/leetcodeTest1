package cn.treeNode.operation;

import java.util.*;

public class Binary_Tree_Preorder_Traversal {
    /**
    public List<Integer> preorderTraversal(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<TreeNode>();
        List<Integer> result=new ArrayList<Integer>();
        if(root == null) return result;
        queue.add(root);
        result.add(root.val);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp.left!=null){
                queue.add(temp.left);
                result.add(temp.left.val);
            }
            if(temp.right!=null){
                queue.add(temp.right);
                result.add(temp.right.val);
            }
        }
        return result;
    }
     */
    /**
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            result.add(root.val);
            root=root.right;
        }
        return result;
    }
     */
    public List<Integer>  preorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.add(root);
                result.add(root.val);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
        return result;
    }
}
