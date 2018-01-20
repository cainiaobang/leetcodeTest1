package tree.operation;

import java.util.LinkedList;
import java.util.Queue;

public class Convert_Sorted_Array_to_Binary_Search_Tree {

    // wrong answer
    /**
    public TreeNode sortedArrayToBST(int[] nums) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(nums.length==0) return null;
        int i=nums.length>>1;
        TreeNode root=new TreeNode(nums[i]);
        int left=i-1,right=i+1;
        queue.offer(root);
        while(right<nums.length || left>-1){
            int size=queue.size();
            int j=0;
            while(j<size){
                TreeNode temp=queue.poll();
                if(left>-1) {
                    TreeNode treeNode=new TreeNode(nums[left--]);
                    temp.left=treeNode;
                    queue.offer(treeNode);
                }
                if(right>nums.length){
                    TreeNode treeNode=new TreeNode(nums[right++]);
                    temp.right=treeNode;
                    queue.offer(treeNode);
                }
                j++;
            }
        }
        return  root;
    }
     */

    //int mid = low + (high-low)/2; // avoids integer overflow
    public TreeNode sortedArrayToBST2(int[] nums) {
        if(nums.length==0) return null;
        int pos=nums.length>>1;
        TreeNode treeNode=new TreeNode(nums[pos]);
        buildUtils(nums,0,pos-1,treeNode,true);
        buildUtils(nums,pos+1,nums.length-1,treeNode,false);
        return treeNode;
    }
    public void buildUtils(int[] nums,int posLeft,int posRight, TreeNode treeNode,boolean left){
        if(posLeft>posRight) return ;
        int pos=posLeft+(posRight-posLeft)/2;
        TreeNode newTreeNode=new TreeNode(nums[pos]);
        if(left) treeNode.left=newTreeNode;
        else treeNode.right=newTreeNode;
        buildUtils(nums,posLeft,pos-1,newTreeNode,true);
        buildUtils(nums,pos+1,posRight,newTreeNode,false);
    }

    public static void main(String[] args){
        int[] nums={-10,-3,0,5,9};
        new Convert_Sorted_Array_to_Binary_Search_Tree().sortedArrayToBST2(nums);
    }
}
