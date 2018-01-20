package cn.list.operation;


public class Swap_Nodes_In_Pair {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
         ListNode nodehead=new ListNode(0);
         nodehead.next=head;
         ListNode result=nodehead;
        while(nodehead.next!=null&&nodehead.next.next!=null){
           ListNode agency=nodehead.next.next.next;
           nodehead.next.next.next=nodehead.next;
           nodehead.next=nodehead.next.next;
           nodehead.next.next.next=agency;
           nodehead=nodehead.next.next;
        }
        return result.next;
    }



    public static void main(String[] args){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);l1.next=l2;
        ListNode l3=new ListNode(3);l2.next=l3;
        ListNode l4=new ListNode(4);l3.next=l4;
        ListNode result=new Swap_Nodes_In_Pair().swapPairs(l1);
        while(result!=null){
            System.out.print(result.val);
            result=result.next;
        }
    }
}
