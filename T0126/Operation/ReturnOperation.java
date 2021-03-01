package T0126.Operation;

import T0126.Book;
import T0126.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation{
    public void work(BookList bookList){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您要归还的书籍名称:");
        String name=scanner.next();
        int i=0;
        for(;i<bookList.getSize();i++){
            if(bookList.getBook(i).getName().equals(name))
                break;
        }
        if(i>=bookList.getSize()){
            System.out.println("无法归还");
            return;
        }
        Book curBook=bookList.getBook(i);
        if(!curBook.isBorrow()){
            System.out.println("该书籍未借出，无法归还");
            return;
        }
        bookList.getBook(i).setBorrow(false);
        System.out.println("归还成功");
    }
}
