package cn.treeNode.operation;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if(root==null) return result;
        getUtil(root,result);
        return result;
    }
    public void getUtil(TreeNode treeNode, List<Integer> result) {
        if (treeNode.left != null) {
            getUtil(treeNode.left, result);
        }
        result.add(treeNode.val);
        if (treeNode.right != null) {
            getUtil(treeNode.right, result);
        }
    }
}

 class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

