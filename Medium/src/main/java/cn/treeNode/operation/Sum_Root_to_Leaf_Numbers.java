package cn.treeNode.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sum_Root_to_Leaf_Numbers {
    public int sumNumbers(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        int sum=0;
        if(root==null) return sum;
        numberUtil(root,root.val,result);
        Iterator<Integer> iterator=result.iterator();
        while(iterator.hasNext()){
            sum+=iterator.next();
        }
        return sum;
    }
    public void numberUtil(TreeNode p,Integer  record, List<Integer> result){
        if(p.left!=null){
            numberUtil(p.left,record*10+p.left.val,result);
        }
        if(p.right!=null){
            numberUtil(p.right,record*10+p.right.val,result);
        }
        if(p.left==null&&p.right==null)result.add(record);
    }
}
