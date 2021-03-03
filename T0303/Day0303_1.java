package T0303;

public class Day0303_1 {
    public static void main(String[] args) {

    }
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val,ListNode next) {
            this.next = next;
            this.val=val;
        }
    }
// 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组
//成的。
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prevnode=new ListNode(-1);
        ListNode prev=prevnode;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                prev.next=l1;
                l1=l1.next;
            }else {
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prevnode.next;
    }
}
