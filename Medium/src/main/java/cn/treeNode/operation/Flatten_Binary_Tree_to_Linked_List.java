package cn.treeNode.operation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        LinkedList<TreeNode> treeNodes=new LinkedList<TreeNode>();
        if(root==null) return ;
        while(!stack.isEmpty()|| root!=null){
            while(root!=null){
                stack.push(root);
                treeNodes.add(root);
                System.out.println(root.val);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
        Iterator<TreeNode> iterator=treeNodes.iterator();
        TreeNode prev=iterator.next(),now=prev;
        while(iterator.hasNext()){
            now=iterator.next();
            prev.left=null;
            prev.right=now;
            prev=now;
        }
        now.left=null;now.right=null;
    }

    public static void main(String[] args){
        /**
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
         */
        //new Flatten_Binary_Tree_to_Linked_List().flatten(treeNode);

    }
}
