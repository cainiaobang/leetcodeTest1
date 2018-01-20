package cn.list.operation;

public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode q=new ListNode(-1);
        q.next=head;
        ListNode p=q,newHead=q;
        while(p.next!=null){
            if(p.next.val>=x) p=p.next;
            else {
                if(p.equals(q)){
                    p=p.next;
                    q=q.next;
                }else{
                    ListNode temp=q.next;
                    q.next=p.next;
                    p.next=p.next.next;
                    q.next.next=temp;
                    q=q.next;
                }

            }
        }
        return newHead.next;
    }
    public static void main(String[] args){
        ListNode listNode=new ListNode(1);
        new Partition_List().partition(listNode,3);
        ListNode listNode2=listNode;
        ListNode listNode3=listNode;
    }
}
