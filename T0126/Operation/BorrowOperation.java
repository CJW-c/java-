package T0126.Operation;

import T0126.Book;
import T0126.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    public void work(BookList bookList){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要借阅的书名：");
        String name=scanner.next();
        int i=0;
        for (;i<bookList.getSize();i++){
            if(bookList.getBook(i).getName().equals(name))
                break;
            else if(i>=bookList.getSize()){
                System.out.println("未找到目标书籍！");
                return;
            }
            Book currentbook=bookList.getBook(i);
            if(currentbook.isBorrow()) {
                System.out.println("该书已被借出");
                return;
            }
        }
        bookList.getBook(i).setBorrow(true);
        System.out.println("成功借阅");
    }
}
