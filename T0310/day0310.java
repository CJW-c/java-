package T0310;

import java.util.Stack;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//返回删除后的链表的头节点。
public class day0310 {
    public static void main(String[] args) {

    }public ListNode deleteNode(ListNode head, int val) {
        if(head==null){
            return null;
        }
        if(head.next==null&&head.val==val){
            return null;
        }
        if(head.val==val){
            return head.next;
        }
        ListNode cur=head;
        ListNode prev=head;
        while(cur!=null){
            if(cur.val==val){
                prev.next=cur.next;
                break;
            }
            prev=cur;
            cur=cur.next;
        }
        return head;
    }
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char[] chars=s.toCharArray();
        for(char c: chars){
            if (c=='('){
                stack.push(')');
            }else if (c=='['){
                stack.push(']');
            }else if (c=='{'){
                stack.push('}');
            }else if (stack.isEmpty()||stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }

}


class MyStack {

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

    }

    /** Get the top element. */
    public int top() {

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

    }
}

class MyQueue {

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

    }

    /** Get the front element. */
    public int peek() {

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

    }

    class MinStack {

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {

        }

        public void pop() {

        }

        public int top() {

        }

        public int getMin() {

        }
    }

}

