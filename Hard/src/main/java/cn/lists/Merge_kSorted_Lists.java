package cn.lists;

import javafx.scene.layout.Priority;
import jdk.nashorn.internal.ir.IndexNode;

import java.lang.reflect.Array;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Merge_kSorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list=new LinkedList<ListNode>();
        for(int i=0;i<lists.length;i++){
           if(lists[i]!=null)list.add(lists[i]);
        }
        ListNode head=new ListNode(0);
        ListNode nodeList=head;
        while(true){
            int val=Integer.MAX_VALUE;
            int pos=-1;
            int i=0;
            ListIterator<ListNode> iterator=list.listIterator();
            while(iterator.hasNext()) {
                i++;
                ListNode node = iterator.next();
                if(node.val<val) {pos=i;val=node.val;}
            }
            i=0;
            if(pos!=-1) {
                iterator=list.listIterator();
                while(iterator.hasNext()){
                   i++;
                   ListNode node=iterator.next();
                   if(i==pos) {
                       nodeList.next=node;nodeList=nodeList.next;
                       node=node.next;
                       if(node==null)iterator.remove();
                       else iterator.set(node);
                       break;
                   }
                }
            }
            else break;
        }
        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
            LinkedList<Integer> list=new LinkedList<Integer>();
            ListNode head=new ListNode(0);
            ListNode node=head;
            for(int i=0;i<lists.length;i++){
                while(lists[i]!=null){
                    list.add(lists[i].val);
                    lists[i]=lists[i].next;
                }
            }
            //
            Collections.sort(list);

            Iterator<Integer> iterator=list.iterator();
            while(iterator.hasNext()){
                head.next=new ListNode(iterator.next());
                head=head.next;
            }
            return node.next;
    }


    // ArrayList比linkedList排序更快，这里更适合用ArrayList
    public ListNode mergeKLists3(ListNode[] lists) {
        List<Integer> list=new LinkedList<Integer>();
        ListNode head=new ListNode(0);
        ListNode node=head;
        for(int i=0;i<lists.length;i++){
            while(lists[i]!=null){
                list.add(lists[i].val);
                lists[i]=lists[i].next;
            }
        }
        ArrayList<Integer> list2=new ArrayList();
        Iterator<Integer> iter=list.iterator();
        while(iter.hasNext()){
           list2.add(iter.next());
        }
        Collections.sort(list2);
        Iterator<Integer> iterator=list2.iterator();
        while(iterator.hasNext()){

            head.next=new ListNode(iterator.next());
            head=head.next;
        }
        return node.next;
    }


    class IndexNode{
        ListNode node;
        int i;
        public IndexNode(ListNode node, int i) {
            this.node = node;
            this.i = i;
        }
    }



    //PriorityQueue在解决该问题的灵活使用
    public ListNode mergeKLists4(ListNode[] lists){
        ListNode head=new ListNode(0);
        ListNode node=head;
        Comparator<ListNode> nodeComparator=new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        };
        Queue<ListNode>  queue=new PriorityQueue<ListNode>(nodeComparator);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null) queue.add(lists[i]);
        }
        while(!queue.isEmpty()){
            ListNode listNode=queue.poll();
            node.next=listNode;node=node.next;
            if(listNode.next!=null) queue.add(listNode.next);
        }
        return head.next;
    }




    public static void main(String[] args){
      ListNode l1=new ListNode(0); ListNode l2=new ListNode(2); ListNode l3=new ListNode(5);
      l1.next=l2;l2.next=l3;
      ListNode[] l={l1};
      new Merge_kSorted_Lists().mergeKLists4(l);
    }
}
