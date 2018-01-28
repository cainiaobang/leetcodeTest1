package list.operation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set=new HashSet<ListNode>();
        while(head!=null){
            if(set.contains(head)) return true;
            else set.add(head);
            head=head.next;
        }
        return false;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
      }
  }
