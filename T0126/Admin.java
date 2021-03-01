package T0126;

import T0126.Operation.*;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String name) {
        this.name=name;
        this.operations=new IOperation[] {
                new AddOperation(),
                new DelOperation(),
                new ChangeOperation(),
                new SearchOperation(),
                new ExitOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("*********************");
        System.out.println("1.增加书籍");
        System.out.println("2.删除书籍");
        System.out.println("3.打印书籍");
        System.out.println("4.查找书籍");
        System.out.println("5.退出");
        System.out.println("*********************");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        return choice;
    }
}
