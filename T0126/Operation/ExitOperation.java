package T0126.Operation;

import T0126.Book;
import T0126.BookList;

public class ExitOperation implements IOperation {
    public void work(BookList bookList){
        System.exit(0);
    }
}
