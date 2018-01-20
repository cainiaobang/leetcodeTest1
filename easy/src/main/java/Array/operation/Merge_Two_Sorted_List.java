package Array.operation;

 class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Merge_Two_Sorted_List {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         ListNode head=new ListNode(0);
         ListNode node=head;
         while(l1!=null|| l2!=null){
             if(l1==null){
                 node.next=l2;break;
             }else if(l2==null){
                 node.next=l1;break;
             } else if(l1.val<l2.val){
                 node.next=l1;l1=l1.next;node=node.next;
             }else{
                 node.next=l2;l2=l2.next;node=node.next;
             }
         }
         return head.next;
    }

    public static void main(String[] args){
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(1);
        ListNode l3=new Merge_Two_Sorted_List().mergeTwoLists(l1,l2);
        while(l3!=null){
            System.out.print(l3.val);
            l3=l3.next;
        }
    }
}
