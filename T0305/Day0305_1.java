package T0305;

public class Day0305_1 {
    public static void main(String[] args) {

    }
    //编写一个程序，找到两个单链表相交的起始节点。
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int t1=getlength(headA);
        int t2=getlength(headB);
        int step;
        if(t1>t2){
            step=t1-t2;
            for(int i=0;i<step;i++){
                headA=headA.next;
            }
        }else{
            step=t2-t1;
            for(int i=0;i<step;i++){
                headB=headB.next;
            }
        }
        while(headA!=null){
            if(headA==headB){
                break;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return headA;

    }

    public static int getlength(ListNode head){
        int count=0;
        for(ListNode cur=head;cur!=null;cur=cur.next){
            count++;
        }
        return count;
    }
//给定一个链表，判断链表中是否有环。
//
//如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
//如果链表中存在环，则返回 true 。 否则，返回 false 。
    public static boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    //对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
    //给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
    public static boolean chkPalindrome(ListNode A) {
        // write code here
        ListNode newhead=new ListNode(-1);
        ListNode cur=A;
        ListNode temp=null;
        while(cur!=null){
            temp=newhead.next;
            newhead.next=new ListNode(cur.val);
            newhead.next.next=temp;
            cur=cur.next;
        }
        while(A!=null){
            if(A.val==newhead.next.val){
                A=A.next;
                newhead=newhead.next;
            }else
                return false;
        }
        return true;
    }
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null){
            return null;
        }
        if(pHead.next==null){
            return pHead;
        }
        ListNode newhead=new ListNode(0);
        ListNode newTail=newhead;
        ListNode cur=pHead;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur!=null&&cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
            }else{
                newTail.next=new ListNode(cur.val);
                newTail=newTail.next;
            }
            cur=cur.next;
        }
        return newhead.next;

    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
