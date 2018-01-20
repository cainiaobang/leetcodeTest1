package tree.operation;

import java.util.*;

public class Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if(root==null) return result;
        queue.offer(root);
        TreeNode temp;
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                temp=queue.poll();
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
                list.add(temp.val);
            }
            result.add(0,list);
        }
        return result;
    }

    public static void main(String[] args){
        List<Integer> list=new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(0,3);
        System.out.println(list);
    }
}
