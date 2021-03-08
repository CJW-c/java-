package T0308;

public class MyStack {
    private int[] data=new int[100];
    private int size=0;

    public void push(int val){
        if (size>=data.length){
            return;
        }
        data[size]=val;
        size++;
    }

    public Integer pop(){
        if (size==0){
            return null;
        }
        int ret=data[size-1];
        size--;
        return ret;
    }

    public Integer peek(){
        if (size==0){
            return null;
        }
        return data[size-1];
    }
}
