package HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Home {
    public static void main(String[] args) {
        System.out.println(5/2);
        int[] t={1};
        System.out.println(findUnsortedSubarray(t));
//        int[] nums={2,7,11,15};
//        int target=9;
//        int[] t=twoSum(nums,target);
//        for (int i=0;i<t.length;i++){
//            System.out.print(t[i]+" ");
        }
    public static int[] twoSum(int[] nums, int target){
        int[] a=new int[2];
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    a[0]=i;
                    a[1]=j;
                    break;
                }
            }
        }
        return a;
    }
    public static String addBinary(String a, String b){
        return Integer.toBinaryString(
                Integer.parseInt(a,2)+Integer.parseInt(b,2)
        );
    }

    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            idx++;
        }
        if (idx == n) {
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }
   //选择排序
    public static void selectsort(int[] a){
        for (int i=0;i<a.length;i++){
            int k=i;
            for (int j=i;j<a.length;j++){
                if (a[j]<a[k]){
                    k=j;
                }
            }
            int temp=a[i];
            a[i]=a[k];
            a[k]=temp;
        }
    }

    //插入排序
    public static void insertsort(int[] a){
        
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] Nums=nums.clone();
        Arrays.sort(Nums);
        int k=0,j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=Nums[i]){
                k=i;
                break;
            }
        }
        for (int i=Nums.length-1;i>=0;i--){
            if (nums[i]!=Nums[i]){
                j=i;
                break;
            }
        }
        if (k==j)
            return 0;
        else
            return j-k+1;
    }

    public static int evalRPN(String[] tokens){
        Stack<Integer> numStack=new Stack<>();
        Integer op1,op2;
        for (String s:tokens){
            switch (s){
                case "+":
                    op2=numStack.pop();
                    op1=numStack.pop();
                    numStack.push(op1+op2);
                    break;
                case "-":
                    op2=numStack.pop();
                    op1=numStack.pop();
                    numStack.push(op1-op2);
                    break;
                case "*":
                    op2=numStack.pop();
                    op1=numStack.pop();
                    numStack.push(op1*op2);
                    break;
                case "/":
                    op2=numStack.pop();
                    op1=numStack.pop();
                    numStack.push(op1/op2);
                    break;
                default:
                    //将字符串转换为数字并进行压栈
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }
        return numStack.pop();
    }

    public static List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  //力扣 876 链表的中间节点
  //给定一个头结点为 head 的非空单链表，返回链表的中间结点。
  //如果有两个中间结点，则返回第二个中间结点。
    public static ListNode middleNode(ListNode head) {
        int count=0,j=0;
        ListNode cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        count=count/2;
        for(int i=1;i<=count;i++){
            head=head.next;
        }
        return head;
    }
    //剑指offer  06 从尾到头打印链表
    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    public int[] reversePrint(ListNode head) {
        int count=0;
        ListNode cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        int[] a=new int[count];
        for(int i=count-1;i>=0;i--){
            a[i]=head.val;
            head=head.next;
        }
        return a;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode newhead=null;
        ListNode curnode=head;
        ListNode prevnode=null;
        while(curnode!=null){
            ListNode nextnode=curnode.next;
            if(nextnode==null){
                newhead=curnode;
            }
            curnode.next=prevnode;
            prevnode=curnode;
            curnode=nextnode;
        }
        return newhead;

    }
}
