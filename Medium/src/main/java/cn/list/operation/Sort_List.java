package cn.list.operation;

public class Sort_List {
    public ListNode sortList(ListNode head) {
        ListNode newHead=new ListNode(0);
        newHead.next=head;
       ListNode nodeLeft,nodeRight=head,nodePrev=newHead;
       boolean flag=false;
       while(nodeRight!=null){
           nodeLeft=newHead;
           while(nodeLeft!=nodePrev){
               if(nodeRight.val<nodeLeft.next.val){
                   //
                   nodePrev.next=nodeRight.next;
                   ListNode temp=nodeRight;
                   nodeRight=nodeRight.next;
                   //
                   temp.next=nodeLeft.next;
                   nodeLeft.next=temp;
                   break;
               }
               nodeLeft=nodeLeft.next;
           }
           if(nodeLeft==nodePrev){
               nodePrev=nodeRight;
               nodeRight=nodePrev.next;
           }
       }
       return newHead.next;
    }




    public static void main(String[] args){
        ListNode node1=new ListNode(2);
        node1.next=new ListNode(1);
        new Sort_List().sortList(node1);
    }
}
