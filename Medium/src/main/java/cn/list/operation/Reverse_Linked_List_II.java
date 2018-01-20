package cn.list.operation;

public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead=new ListNode(-1);
        newHead.next=head;
        ListNode p=newHead,q=newHead;
        int i=0;
        if(m!=1){
            while(p.next!=null){
                p=p.next;
                i++;
                if(i==m-1) break;
            }
        }
        ListNode ListNodeBeforeM=p;
        p=p.next;
        // 首个ｌｉｓｔＮｏｄｅ后进行处理
        ListNode ListNode_M=p;
        q=p;
        p=p.next;
        int count=1;
        while(count++<n-m+1){
            ListNode listNode=p.next;
            p.next=q;
            q=p;
            p=listNode;
        }
        ListNode_M.next=p;
        ListNodeBeforeM.next=q;
        return newHead.next;
    }

    public static void main(String[] args){
        ListNode newHead=new ListNode(5);
        newHead.next=new ListNode(3);
        System.out.println(new Reverse_Linked_List_II().reverseBetween(newHead,1,2));
    }
}
