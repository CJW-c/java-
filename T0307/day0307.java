package T0307;
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class day0307 {
    public static void main(String[] args) {

    }
    //一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
    // 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
    public static int missingNumber(int[] nums) {
        int[] a=new int [nums.length+1];
        for(int i=0;i<nums.length;i++){
            a[nums[i]]++;
        }

        int j;
        for(j=0;j<a.length;j++){
            if(a[j]==0)
                break;
        }
        return j;
    }
    //两个链表的第一个公共节点
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a1=getlength(headA);
        int a2=getlength(headB);
        if(a1>a2){
            for(int i=0;i<a1-a2;i++){
                headA=headA.next;
            }
        }else{
            for(int i=0;i<a2-a1;i++){
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
        ListNode cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return  count;
    }
    //统计一个数字在排序数组中出现的次数。
    public static int search(int[] nums, int target) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                count++;
            }
        }
        return  count;
    }
}
