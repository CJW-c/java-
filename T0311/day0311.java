package T0311;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class day0311 {
    public static void main(String[] args) {

    }
}
class MyStack {
    private Queue<Integer> A=new LinkedList<>();
    private Queue<Integer> B=new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (A.isEmpty()&&B.isEmpty()) {
            return 0;
        }
        while(A.size()>1){
            int tmp=A.poll();
            B.offer(tmp);
        }
        int ret=B.poll();
        swapAB();
        return ret;
    }

    private void swapAB(){
        Queue<Integer> tmp=A;
        A=B;
        B=tmp;
    }

    /** Get the top element. */
    public int top() {
        if (A.isEmpty()&&B.isEmpty()){
            return 0;
        }
        while(A.size()>1){
            int tmp=A.poll();
            B.offer(tmp);
        }
        int ret=A.poll();
        B.offer(ret);
        swapAB();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty()&&B.isEmpty();
    }
}

class MyQueue {
    Stack<Integer> A=new Stack<>();
    Stack<Integer> B=new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!B.isEmpty()){
            A.push(B.pop());
        }
        A.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(A.isEmpty()&&B.isEmpty()){
            return 0;
        }
        while(!A.isEmpty()){
            B.push(A.pop());
        }
        return B.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(A.isEmpty()&&B.isEmpty()){
            return 0;
        }
        while(!A.isEmpty()){
            B.push(A.pop());
        }
        return B.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return A.isEmpty()&&B.isEmpty();
    }
}

class MinStack {
    Stack<Integer> A=new Stack<>();
    Stack<Integer> B=new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        A.push(x);
        if(B.isEmpty()){
            B.push(x);
            return;
        }
        int min=B.peek();
        if(x<min){
            min=x;
        }
        B.push(min);
    }

    public void pop() {
        if(A.isEmpty()){
            return;
        }
        A.pop();
        B.pop();
    }

    public int top() {
        if(A.isEmpty()){
            return 0;
        }
        return A.peek();
    }

    public int getMin() {
        if(B.isEmpty()){
            return 0;
        }
        return B.peek();
    }
}