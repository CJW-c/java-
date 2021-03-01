package T0126.Operation;

import T0126.BookList;

public class ChangeOperation implements IOperation{
    public void work(BookList bookList){
        for(int i=0;i<bookList.getSize();i++){
            System.out.println(bookList.getBook(i));
        }
    }
}
