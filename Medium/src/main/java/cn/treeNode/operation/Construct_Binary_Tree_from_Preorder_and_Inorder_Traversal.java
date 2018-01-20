package cn.treeNode.operation;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return buildUtil(0,0,preorder.length-1,inorder.length-1,preorder,inorder,map);
    }

    public TreeNode buildUtil(int preStart, int inStart, int preEnd, int inEnd, int[] preorder, int[] inorder, Map<Integer,Integer>map){
        if(inStart>inEnd || preStart>=inorder.length) return null;
        TreeNode root=new TreeNode(preorder[preStart]);
        int pos=map.get(root.val);
        int i=pos-inStart;
        root.left=buildUtil(preStart+1,inStart,preStart+i,pos-1,preorder,inorder,map);
        root.right=buildUtil(preStart+i+1,pos+1,preEnd,inEnd,preorder,inorder,map);
        return root;
    }

    public static void main(String[] args){
        int[] nums={1,2};
        int[] nums2={2,1};
        new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal().buildTree(nums,nums2);
    }

}
