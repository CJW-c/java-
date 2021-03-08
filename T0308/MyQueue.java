package T0308;

public class MyQueue {
    static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val=val;
        }
    }

    private Node head=null;
    private Node tail=null;

    //入队列
    public boolean offer(int val){
        Node newnode=new Node(val);
        if (head==null){
            head=newnode;
            tail=newnode;
            return true;
        }
        tail.next=newnode;
        tail=tail.next;
        return true;
    }

    //出队列
    public Integer poll(){
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
    //取队首元素
    public Integer peek(){
        if (head==null){
            return null;
        }
        return head.val;
    }

    public static void main(String[] args) {
        MyQueue myqueue=new MyQueue();
        myqueue.offer(1);
        myqueue.offer(2);
        myqueue.offer(3);
        myqueue.offer(4);

        Integer ret=null;
        ret=myqueue.poll();
        System.out.println(ret+" ");

    }
}
