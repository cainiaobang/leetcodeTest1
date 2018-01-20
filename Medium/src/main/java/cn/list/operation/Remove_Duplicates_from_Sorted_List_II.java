package cn.list.operation;

public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode p=head;
        ListNode copy=new ListNode(Integer.MIN_VALUE);
        copy.next=head;
        ListNode newHead=copy;
        int copy_val=0;
        while(p!=null&&p.next!=null){
            if(p.val==p.next.val){
                copy_val=p.val;
                copy.next=p.next.next;
                p=copy.next;
                if(p==null) break;
                while(p.val==copy_val){
                    copy.next=p.next;
                    p=copy.next;
                    if(p==null) break;
                }
            }else{
                copy=p;
                p=p.next;
            }
        }
        return newHead.next;
    }
}
