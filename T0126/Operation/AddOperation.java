package T0126.Operation;

import T0126.Book;
import T0126.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation {
    public void work(BookList bookList){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入书籍名：");
        String name=scanner.next();
        System.out.println("请输入作者：");
        String author=scanner.next();
        System.out.println("请输入价格：");
        double price=scanner.nextDouble();
        System.out.println("请输入类型：");
        String type=scanner.next();
        Book book=new Book(name,author,price,type);
        int cursize=bookList.getSize();
        bookList.setBook(cursize,book);
        bookList.setSize(cursize+1);
        System.out.println("新增成功！");
    }
}
