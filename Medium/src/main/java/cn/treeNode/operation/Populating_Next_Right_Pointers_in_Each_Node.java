package cn.treeNode.operation;

import java.util.LinkedList;
import java.util.Queue;

public class Populating_Next_Right_Pointers_in_Each_Node {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
        if(root==null) return ;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size(),i=0;
            TreeLinkNode temp=null;
            while(i++<size){
                TreeLinkNode treeLinkNode=queue.poll();
                if(treeLinkNode.left!=null) queue.offer(treeLinkNode.left);
                if(treeLinkNode.right!=null) queue.offer(treeLinkNode.right);
                if(temp!=null)temp.next=treeLinkNode;
                temp=treeLinkNode;
            }
            temp.next=null;
        }
    }
}
class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
 }
