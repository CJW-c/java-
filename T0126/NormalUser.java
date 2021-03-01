package T0126;

import T0126.Operation.*;

import java.util.Scanner;

public class NormalUser extends User {
    public NormalUser(String name) {
        this.name=name;
        this.operations=new IOperation[]{
          new SearchOperation(),
          new BorrowOperation(),
          new ReturnOperation(),
          new ExitOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("*********************");
        System.out.println("1.查找书籍");
        System.out.println("2.借阅书籍");
        System.out.println("3.归还书籍");
        System.out.println("4.退出");
        System.out.println("*********************");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        return choice;
    }
}
