/**
 * 用户类，用户登录进行相关操作
 */
package MyBookSystem;

import MyBookSystem.operation.*;

import java.util.Scanner;

public class NormalUser extends User{
    public NormalUser(String name) {
        this.name = name;
        this.opration=new doOpration[]{
                new BorrowBooks(),
                new ReturnBooks(),
                new FindBooks(),
                new ExitSystem()
        };
    }

    @Override
    public  int  menu(){
        System.out.println("你好！"+name+"欢迎来到图书管理系统！");
        System.out.println("===============================");
        System.out.println("          1.借书                ");
        System.out.println("          2.还书                ");
        System.out.println("          3.查找图书             ");
        System.out.println("          4.退出系统             ");
        System.out.println("================================");
        Scanner scanner=new Scanner(System.in);
        int chioce=scanner.nextInt();
        return chioce;
    }
}
