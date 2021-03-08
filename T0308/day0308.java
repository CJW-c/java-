package T0308;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class day0308 {
    public static void main(String[] args) {

    }
    public static ListNode partition(ListNode pHead, int x){
        //创建一个傀儡节点作为小于x值节点的头节点
        ListNode smallhead=new ListNode(-1);
        //smallTail用于连接小于x值的节点
        ListNode smallTail=smallhead;
        //创建一个傀儡节点作为大于等于x值节点的头节点
        ListNode largehead=new ListNode(-1);
        //largeTail用于连接大于等x值的节点
        ListNode largeTail=largehead;
        ListNode cur=pHead;
        //遍历原链表
        while (cur!=null){
            if (cur.val<x){
                //当前节点的值小于x则创建新节点并连接在samllTail之后
                smallTail.next=new ListNode(cur.val);
                //samllTail进行后移
                smallTail=smallTail.next;
            }else {
                //当前节点的值大于等于x则创建新节点并连接在largeTail之后
                largeTail.next=new ListNode(cur.val);
                //largeTail进行后移
                largeTail=largeTail.next;
            }
            cur=cur.next;
        }
        //遍历完原链表后将大于等于x值的新链表连接在小于x值的新链表之后
        smallTail.next=largehead.next;
        //由于我们使用了傀儡节点，因此傀儡节点并不是我们需要的
        // 而傀儡节点的next节点则是我们需要的首节点因此返回傀儡节点的next节点
        return smallhead.next;
    }
}
