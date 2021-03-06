package T0306;

import java.util.Scanner;

class Node{
    int val;
    Node prev=null;
    Node next=null;

    public Node(int val) {
        this.val = val;
    }
}
//实现双向链表
public class MyLinkedList {
    //记录头结点
    private Node head;
    //记录尾结点
    private Node last;
    private int length=0;

    public MyLinkedList() {
        head=null;
        last=null;
    }

    public int length(){
        return this.length;
    }
    //插入结点
    public void addFirst(int val){
        Node newNode=new Node(val);
        if (head==null){
            head=newNode;
            last=newNode;
            length++;
            return;
        }
        //非空链表
        newNode.next=head;
        //更新head
        head.prev=newNode;
        head=newNode;
        length++;
    }

    //尾插
    public void addLast(int val){
        Node newNode=new Node(val);
        //为空时
        if (head==null){
            head=newNode;
            last=newNode;
            length++;
            return;
        }
        //非空链表
        last.next=newNode;
        newNode.prev=last;
        last=newNode;
        length++;
    }

    //指定位置插入
    public void add(int index,int val){
        if (index<0||index>length)
            return;
        if (index==0){
            addFirst(val);
            return;
        }
        if (index==length){
            addLast(val);
            return;
        }
        Node newNode=new Node(val);
        Node nextNode=getNode(index);
        Node prevNode=nextNode.prev;

        prevNode.next = newNode;
        newNode.prev = prevNode;

        newNode.next = nextNode;
        nextNode.prev = newNode;
        length++;

    }

    //头删
    public void removeFirst(){
        if (head==null)
            return;
        if (head.next==null){
            head=null;
            last=null;
            length=0;
            return;
        }
        Node nextNode=head.next;
        nextNode.prev=null;
        head=nextNode;
        length--;
    }

    //尾删
    public void removelast(){
        if (head==null)
            return;
        if (head.next==null){
            head=null;
            last=null;
            length=0;
            return;
        }
        Node prevNode=last.prev;
        prevNode.next=null;
        last.prev=null;
        last=prevNode;
        length--;
    }

    //删除
    public  void removeByvalue(int val){
        int index=indexof(val);
        if (index==-1)
            return;
        removeByIndex(index);
    }

    public void removeByIndex(int index){
        if (index<0||index>=length){
            return;
        }
        if (index==0){
            removeFirst();
            return;
        }
        if (index==length-1){
            removelast();
            return;
        }
        Node toremove=getNode(index);
        Node prevnode=toremove.prev;
        Node nextnode=toremove.next;
        prevnode.next=nextnode;
        nextnode.prev=prevnode;
        length--;
    }

    //根据下标查找结点
    public Node getNode(int index){
        if (index<0||index>length)
            return null;
        Node cur=head;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur;
    }

    public int indexof(int val){
        Node cur=head;
        for (int  i=0;i<length;i++){
            if (val==cur.val){
                return i;
            }
            cur=cur.next;
        }
        return -1;
    }

    public int get(int index){
        if (index<0||index>=length){
            throw new ArrayIndexOutOfBoundsException();
        }
        return getNode(index).val;
    }

    //打印链表
    public void show(){
        Node cur=head;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    //修改
    public void change(int index,int val){
        if (index<0||index>=length){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node=getNode(index);
        node.val=val;
    }

    public static void main(String[] args) {

        //头插
        MyLinkedList list1=new MyLinkedList();
        for (int i=0;i<5;i++){
            list1.addFirst(i);
        }
        list1.show();
        //尾插
        for (int i=0;i<5;i++){
            list1.addLast(i+5);
        }
        list1.show();
        //指定位置插入
        list1.add(5,11);
        list1.add(0,12);
        list1.add(list1.length,20);
        list1.show();
        //头删
        list1.removeFirst();
        //尾删
        list1.removelast();
        list1.show();
        //删除指定位置的元素
        list1.removeByIndex(5);
        list1.show();
        //按值删除元素
        list1.removeByvalue(6);
        list1.removeByvalue(7);
        list1.show();
    }
}
