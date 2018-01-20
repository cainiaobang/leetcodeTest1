class ListNode {
     int val;
     ListNode next;
    ListNode(int x) { val = x; }
}

//认真阅读题目，分析计算特点及方式，理解都错了，自然解不出来。
/**
public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> p1=new ArrayList<>();
        List<Integer> p2=new ArrayList<>();
        while(l1.next!=null){
            p1.add(l1.val);
        }
        while(l2.next!=null){
            p2.add(l2.val);
        }
        int length=Math.min(p1.size(),p2.size())-1;
        int length2=Math.max(p1.size(),p2.size())-1;
        int carry=0;
        ListNode result=new ListNode(0);
        ListNode head=result;
        while(length>=0){
            int bit=p1.get(length2)+p2.get(length2)+carry;
            length2--;
            length--;
            if(bit>9){
                bit-=10;carry=1;
            }else{
                carry=0;
            }
            result.next=new ListNode(bit);
            result=result.next;
        }
        if(p1.size()==p2.size()){{
            if(carry==0){
                return head.next;
            }
            else{
                result.next=new ListNode(1);
                return head.next;
            }
        }else if(p1.size()>p2.size()){
            if(carry==0){
                int difference=p1.size()-p2.size();
                while(difference>0){
                    result.next=new ListNode(p1.get(difference-1));
                    result=result.next;
                }

            }

        }else{

        }
        return head.next;
    }
}
 **/

