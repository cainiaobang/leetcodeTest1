package tree.operation;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<Integer> list=new ArrayList<Integer>();
        while(root!=null && !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            list.add(root.val);
            root=root.right;
        }
        Object[] lists=list.toArray();
        if(lists.length%2==0) return isPalindrome(lists,lists.length>>1,lists.length>>1-1);
        else return isPalindrome(lists,lists.length>>1,lists.length>>1);
    }
    public boolean isPalindrome(Object[] lists,int left,int right){
        while(left>=0&&right<lists.length){
            if(!lists[left].equals(right)) return false;
        }
        return true;
    }
}
