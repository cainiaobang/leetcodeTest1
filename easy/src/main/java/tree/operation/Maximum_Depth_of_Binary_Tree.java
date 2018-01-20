package tree.operation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Maximum_Depth_of_Binary_Tree {

    //DFS
    public int maxDepth(TreeNode root) {
       Queue<TreeNode> deque=new LinkedList<TreeNode>();
       if(root==null) return 0;
       deque.offer(root);
       int level=0;
       while(!deque.isEmpty()){
           level++;
           int size=deque.size(),i=0;
           while(i++<size){
               TreeNode treeNode=deque.poll();
               if(treeNode.left!=null) deque.offer(treeNode.left);
               if(treeNode.right!=null) deque.offer(treeNode.right);
           }
       }
       return level;
    }

    //BFS
    public int maxDepth2(TreeNode root){
        return depthUtil(root,0);
    }
    public int depthUtil(TreeNode treeNode,int depth){
         if(treeNode!=null) {
             depth++;
             return Math.max(depthUtil(treeNode.left,depth),depthUtil(treeNode.right,depth));
         }else{
             return depth;
         }
    }

    //前序遍历
    public List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<Integer> result=new LinkedList<Integer>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                result.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
        return result;
    }
}
