/**
 *  程序测试类
 */
package MyBookSystem;

import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        BookList bookList=new BookList();
          User user=login(); //利用了多态，向上转型
          while (true){
              int chioce=user.menu();
              user.doopration(bookList ,chioce);
          }
    }

    private static User login() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = scanner.next();
        System.out.println("请输入您的角色： 1.管理员   2.普通用户");
        int chioce=scanner.nextInt();
        if(chioce==1){
            return new Admin(name);
        }else if(chioce==2){
            return new NormalUser(name);
        }else {
            System.out.println("您输入的有误");
            System.exit(0);
        }
        return null;
    }
}
