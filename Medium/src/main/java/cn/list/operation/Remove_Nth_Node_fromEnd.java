package cn.list.operation;

class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;

        if (val != listNode.val) return false;
        return next.val==listNode.next.val;
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result ;
        return result;
    }
}
public class Remove_Nth_Node_fromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node=head;
        int num=0;
        while(node!=null){
            node=node.next;
            num++;
        }
        int count=num-n;
        node=head;
        for(int i=0;i<count-1;i++){
            node=node.next;
        }
        if(num==n) return head.next;
        if(n!=1) node.next=node.next.next;
        else  node.next=null;
        return head;
    }
}
