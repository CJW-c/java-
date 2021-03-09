package T0309;
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class day0309 {
    public static void main(String[] args) {

    }
    //实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
    //输入：单向链表a->b->c->d->e->f中的节点c
    //结果：不返回任何数据，但该链表变为a->b->d->e->f
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

    //给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
    //失败解法
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        int t=getlength(head);
        ListNode newhead=head;
        k=k%t;
        for(int i=0;i<k;i++){
            newhead=xuan(newhead);
        }
        return newhead;
    }

    public ListNode xuan(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        while(cur.next!=null){
            prev=cur;
            cur=cur.next;
        }
        prev.next=null;
        cur.next=head;
        head=cur;
        return head;
    }

    public int getlength(ListNode head){
        int count=0;
        ListNode cur=head;
        while(cur!=null){
            count++;
        }
        return count;
    }
    //官方解法
    public ListNode RotateRight(ListNode head, int k) {
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;

    }
}
