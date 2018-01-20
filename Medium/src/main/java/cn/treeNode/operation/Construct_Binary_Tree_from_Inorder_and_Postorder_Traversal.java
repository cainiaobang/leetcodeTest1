package cn.treeNode.operation;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildUtil(0, 0, inorder.length - 1, inorder.length - 1, inorder, postorder, map);
    }

    public TreeNode buildUtil(int inStart, int postStart, int inEnd, int postEnd, int[] inOrder, int[] posOrder, Map<Integer, Integer> map) {
        TreeNode treeNode = new TreeNode(posOrder[postEnd]);
        System.out.println(treeNode.val);
        int pos = map.get(posOrder[postEnd]);
        int lenRight;
        lenRight=inEnd-pos;
        if(pos-1>=inStart ) {
            if (postEnd - lenRight - 1 >=postStart) {
                treeNode.left = buildUtil(inStart, postStart, pos - 1, postEnd - lenRight - 1, inOrder, posOrder, map);
            }else{
                treeNode.left=buildUtil(inStart,postStart,pos-1,postEnd-1,inOrder,posOrder,map);
            }
        }
        if(inEnd>=pos+1){
            treeNode.right = buildUtil(pos + 1, postEnd - lenRight, inEnd, postEnd - 1, inOrder, posOrder, map);
        }

        return treeNode;
    }

    public static void main(String[] args){
        int[] nums={1,2,3,4};
        int[] nums2={1,4,3,2};
        new  Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal().buildTree(nums,nums2);
    }
}
