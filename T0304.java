public class T0304 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(5);
        ListNode node2=new ListNode(4);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(7);
        ListNode node8=new ListNode(8);
        ListNode node9=new ListNode(9);
        node6.next=node7;
        node7.next=node8;
        node8.next=node9;
        ListNode head=partition(node1,3);
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
//        ListNode head=mergeTwoLists(node1,node6);
//        while(head!=null){
//            System.out.print(head.val+" ");
//            head=head.next;
//        }
//        System.out.println(middleNode(node1).val);
//        System.out.println(FindKthToTail(node1,1).val);
    }
    //实现链表题目: 获取链表的中间节点
    public static ListNode middleNode(ListNode head){
        int count=0,i;
        ListNode cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        for (i=0;i<count/2;i++){
            head=head.next;
        }
        return head;
    }
    //实现链表题目: 获取链表倒数第K个节点
    public static ListNode FindKthToTail(ListNode head,int k){
        int t=getlength(head)-k;
        if (t<0){
            return null;
        }
        ListNode cur1=head;
        for (int i=0;i<t;i++){
            cur1=cur1.next;
        }
        return cur1;
    }
    public static int getlength(ListNode head){
        int count=0;
        for (ListNode cur=head;cur!=null;cur=cur.next){
            count++;
        }
        return count;
    }
    //实现链表题目: 合并两个有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode newhead=new ListNode(-1);
        ListNode newhead1=newhead;
        while(l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                newhead1.next=l1;
                l1=l1.next;
            }else {
                newhead1.next=l2;
                l2=l2.next;
            }
            newhead1=newhead1.next;
        }
        if (l1==null){
            newhead1.next=l2;
        }else {
            newhead1.next=l1;
        }
        return newhead.next;
    }
   // 实现链表题目: 给定 x, 把一个链表整理成前半部分小于 x, 后半部分大于等于 x 的形式
    public static ListNode partition(ListNode pHead, int x){
        ListNode  smallhead=new ListNode(-1);
        ListNode smallTail=smallhead;
        ListNode largehead=new ListNode(-1);
        ListNode largeTail=largehead;
        for (ListNode cur=pHead;cur!=null;cur=cur.next){
            if (cur.val<x){
                smallTail.next=new ListNode(cur.val);
                smallTail=smallTail.next;
            }else {
                largeTail.next=new ListNode(cur.val);
                largeTail=largeTail.next;
            }
        }
        smallTail.next=largehead.next;
        return smallhead.next;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public static ListNode deleteDuplication(ListNode pHead) {
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
            } else{
                newTail.next=new ListNode(cur.val);
                newTail=newTail.next;
            }
            cur=cur.next;
        }
        return newhead.next;

    }
    //对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
    //
    //给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
    public boolean chkPalindrome(ListNode A) {
        // write code here
        ListNode newhead=new ListNode(0);
        ListNode cur=A;
        ListNode temp=null;
        while(cur!=null){
            temp=newhead.next;
            newhead.next=new ListNode(cur.val);
            newhead.next.next=temp;
            cur=cur.next;
        }
        temp=newhead.next;
        while(A!=null){
            if(A.val!=temp.val){
                return false;
            }
            A=A.next;
            temp=temp.next;
        }
        return true;
    }
    //给定一个链表，判断链表中是否有环。
    //
    //如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
    //
    //如果链表中存在环，则返回 true 。 否则，返回 false 。
    public boolean hasCycle(ListNode head) {
        ListNode first=head;
        ListNode slow=head;
        while(first!=null&&first.next!=null){
            first=first.next;
            first=first.next;
            slow=slow.next;
            if(first==slow){
                return true;
            }
        }
        return false;
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

