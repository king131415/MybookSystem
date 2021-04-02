/**
 * 添加书籍类，也是实现了操作接口，实现书籍添加
 */
package MyBookSystem.operation;

import MyBookSystem.Book;
import MyBookSystem.BookList;

import java.util.Scanner;

public class AddBooks implements doOpration {

    @Override
    public void work(BookList bookList) {
        System.out.println("请输入你要添加书籍的名称：");
        Scanner scanner =new Scanner(System.in);
        String name=scanner.next();
        System.out.println("请输入书籍的作者：");
        String author=scanner.next();
        System.out.println("请输入书籍的价格：");
        double price=scanner.nextDouble();
        System.out.println("请输入书籍的类型：");
        String type=scanner.next();
        Book book=new Book(name,author,price,type);
        bookList.setBooks(bookList.getSize(),book);
        bookList.setSize(bookList.getSize()+1);
        System.out.println("添加书籍成功！");

    }
}
