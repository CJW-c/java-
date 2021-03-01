package T0126.Operation;

import T0126.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation{
    public void work(BookList bookList){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要删除的书籍名：");
        String name=scanner.next();
        int i=0;
        for (;i<bookList.getSize();i++){
            if(bookList.getBook(i).getName().equals(name))
                break;
        }
        if(i>=bookList.getSize()){
            System.out.println("未找到要删除的书籍");
            return;
        }
        if (i==bookList.getSize()-1){
            int t=bookList.getSize()-1;
            bookList.setSize(t);
            return;
        }
        bookList.setBook(i,bookList.getBook(bookList.getSize()-1));
        bookList.setSize(bookList.getSize()-1);
    }
}
