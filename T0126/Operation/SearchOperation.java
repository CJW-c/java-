package T0126.Operation;

import T0126.BookList;

import java.util.Scanner;

public class SearchOperation implements IOperation{
    public void work(BookList bookList){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入需要查找的书名：");
        String name=scanner.next();
        int i=0;
        for (;i<bookList.getSize();i++){
            if(bookList.getBook(i).getName().contains(name)){
                System.out.println(bookList.getBook(i));
                break;
            }
        }
    }
}
