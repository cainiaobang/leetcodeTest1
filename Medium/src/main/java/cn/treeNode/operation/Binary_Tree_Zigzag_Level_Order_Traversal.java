package cn.treeNode.operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int level=1;
        while(!queue.isEmpty()){
            int i=0,j=0,size=queue.size();
            ArrayList<Integer> list=new ArrayList<Integer>(size);
            while(j++<size)
                list.add(null);
            while(i<size){
                TreeNode temp=queue.poll();
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
                if(level%2==0){
                    System.out.println(list);
                    list.set(size-1-i,temp.val);
                }else{
                    list.set(i,temp.val);
                }
                i++;
            }
            result.add(list);
            level++;
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(3);  TreeNode node9=new TreeNode(9);  TreeNode node20=new TreeNode(20);
        root.left=node9;
        root.right=node20;
        TreeNode treeNode15=new TreeNode(15);
        TreeNode treeNode7=new TreeNode(7);
        node20.left=treeNode15;node20.right=treeNode7;
        System.out.println(new Binary_Tree_Zigzag_Level_Order_Traversal().zigzagLevelOrder(root));
    }
}
