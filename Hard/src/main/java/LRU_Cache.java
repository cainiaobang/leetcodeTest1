import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {
    class DLinkNode{
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int count;
    private int capacity;
    private DLinkNode head,tail;
    private Map<Integer,DLinkNode > map;
    public LRU_Cache(int capacity) {
         this.count=0;this.capacity=capacity;
         head=new DLinkNode(0,0);tail=new DLinkNode(0,0);map=new HashMap<Integer, DLinkNode>();
         head.prev=null;tail.next=null;head.next=tail;tail.prev=head;
    }
    public void inserNode(DLinkNode node){
        node.prev=head;node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    public void removeNode(DLinkNode node){
       node.prev.next=node.next;
       node.next.prev=node.prev;
    }
    public void moveToHead(DLinkNode node){
        removeNode(node);
        inserNode(node);
    }
    public DLinkNode popTail(){
        DLinkNode temp=tail.prev;
       removeNode(temp);
       return temp;
    }

    public int get(int key) {
        DLinkNode node=map.get(key);
        if(node==null){
            return -1;
        }else{
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkNode node=map.get(key);
        if(node!=null){
            node.value=value;
            moveToHead(node);
        }else{
            node=new DLinkNode(key,value);
            inserNode(node);
            map.put(node.key,node);
            count++;
            if(count>capacity){
                DLinkNode temp=popTail();
                map.remove(temp.key);
                --count;
            }
        }
    }
}

