package T0312;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class day0312 {
    public static void main(String[] args) {

    }

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }
    public String build(String str) {
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }


}
class RecentCounter{
    Queue<Integer> a;
    public RecentCounter(){
        a=new LinkedList();
    }

    public int ping(int t){
        a.add(t);
        while(a.peek()<t-3000){
            a.poll();
        }
        return a.size();
    }
}
