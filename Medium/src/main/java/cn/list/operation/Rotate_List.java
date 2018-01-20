package cn.list.operation;

public class Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null ) return head;
        int count=1;
        ListNode p=head,tail=p;
        while(tail.next!=null){
            tail=tail.next;
            count++;
        }
        tail.next=head;
        k=k%count;
        for(int i=0;i<count-k;i++) tail=tail.next;
        ListNode newHead=tail.next;
        tail.next=null;
        return newHead;
    }


}
