package T0126;

import T0126.Operation.IOperation;

public abstract class User {
    protected String name;
    protected IOperation[] operations;
    public abstract int menu();
    public void doOperation(int choice,BookList bookList){
        IOperation operation=this.operations[choice-1];
        operation.work(bookList);
    }
}

