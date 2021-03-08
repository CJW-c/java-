package T0308;

class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyStack2 {
    private Node head=null;
    //入栈操作
    public void push(int val){
        Node newnode=new Node(val);
        if (head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    //出栈操作
    public Integer pop(){
        if (head==null){
            return null;
        }
        if (head.next==null){
            int ret=head.val;
            head=null;
            return ret;
        }
        int ret=head.val;
        head=head.next;
        return ret;
    }
    //取栈顶元素
    public Integer peek(){
        if (head==null){
            return null;
        }
        return head.val;
    }
}
