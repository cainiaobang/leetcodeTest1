package cn.list.operation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Copy_List_with_Random_Pointer {
    Map<Integer,RandomListNode> map=new HashMap<Integer,RandomListNode>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode newHead=new RandomListNode(head.label);
        map.put(newHead.label,newHead);
        if(head.next!=null){
            RandomListNode next=map.get(head.next.label);
            if(next!=null){
                newHead.next=next;
            }else{
                newHead.next=copyRandomList(head.next);
            }
        }
        if(head.random!=null){
            RandomListNode random=map.get(head.random.label);
            if(random!=null){
                newHead.random=random;
            }else{
                newHead.random=copyRandomList(head.random);
            }
        }
        return newHead;
    }
    public static void main(String[] args){
        System.out.println(new RandomListNode(1).hashCode());
        System.out.println(new RandomListNode(1).hashCode());
    }
}

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
};
