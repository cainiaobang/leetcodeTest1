package cn.lists;

public class Reverse_Nodes_In_K_Group {

    //
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node=new ListNode(0);
        node.next=head;
        ListNode result=node;
        int count=0;
        while(node!=null){
            count=0;
            ListNode listHead=node;
            while(count<k&&node!=null){
                count++;node=node.next;
            }
            if(node==null)break;
            ListNode listTail=node;
            ListNode tailNext=node.next;
            for(int i=0;i<k-1;i++){
                node=listHead;
                for(int j=0;j<k-1-i;j++){
                    node=node.next;
                }
                node.next.next=node;
            }
            listHead.next.next=tailNext;
            listHead.next=listTail;
            node.next=tailNext;
        }
        return result.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode listNode=result;
        ListNode top=result;
        int count=0;
        while(true) {
            count=0;
            while(count<k&&result!=null){
                count++;result=result.next;
            }
            if(result==null)break;
            head=top.next;
            while(count-->1){
             ListNode tmp=top.next;
             top.next=tmp.next;
             tmp.next=result.next;
             result.next=tmp;
            }
            top=head;result=head;

        }
        return listNode.next;
    }
}
