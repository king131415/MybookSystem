/**
 * 管理员类，管理员登录进行相关操作
 */

package MyBookSystem;

import MyBookSystem.operation.*;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String name) {
        this.name = name;
        this.opration=new doOpration[]{  //初始化操作对象
                new AddBooks(),
                new DeleBooks(),
                new DispBookList(),
                new FindBooks(),
                new ExitSystem()
        };
    }

    public   int menu(){
        /**
         * 在java中用static修饰的方法为静态方法，跟类相关，静态方法不能直接调用非静态方法；
         * 要想调用需要创建类，依托类即可调用！并且，静态方法不能访问非静态的类属性！
         */
        System.out.println("你好！"+name+"欢迎来到图书管理系统！");
        System.out.println("===============================");
        System.out.println("          1.添加图书             ");
        System.out.println("          2.删除图书             ");
        System.out.println("          3.查看图书列表          ");
        System.out.println("          4.查找图书             ");
        System.out.println("          5.退出系统             ");
        System.out.println("================================");
        Scanner scanner =new Scanner(System.in);
        int chioce=scanner.nextInt();
        return chioce;
    }
}
