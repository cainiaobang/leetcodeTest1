package tree.operation;

import java.util.*;

public class Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Queue<Integer> value=new LinkedList<Integer>();
        Set<Integer> result=new HashSet<Integer>();
        queue.offer(root);
        value.offer(root.val);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp=queue.poll();
                Integer tempValue=value.poll();
                if(temp.left==null&&temp.right==null) {
                    result.add(tempValue);
                    continue;
                }
                if(temp.left!=null){
                    queue.offer(temp.left);
                    value.offer(tempValue+temp.left.val);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                    value.offer(tempValue+temp.right.val);
                }
            }
        }
        //System.out.println(result);
        return result.contains(sum);
    }

    public static void main(String[] args){
        TreeNode treeNode1=new TreeNode(1);
        treeNode1.left=new TreeNode(2);
        treeNode1.right=new TreeNode(3);
        treeNode1.left.left=new TreeNode(4);
        System.out.println(new Path_Sum().hasPathSum(treeNode1,4));
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        Stack<TreeNode> stack=new Stack<TreeNode>();

        return false;
    }
}
