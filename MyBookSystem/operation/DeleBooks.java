/**
 * 删除书籍类，同样是实现了operation接口，完成书籍的删除
 */
package MyBookSystem.operation;

import MyBookSystem.BookList;

import java.util.Scanner;

public class DeleBooks implements doOpration{
    @Override
    public void work(BookList bookList) {
//        System.out.println("删除书籍成功！");
        System.out.println("请输入你要删除书籍的名称：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        int i=0;
        for(;i<bookList.getSize();i++){
            if(bookList.getBooks(i).getName().equals(name)){
                bookList.setBooks(i,bookList.getBooks(bookList.getSize()-1));
                bookList.setSize(bookList.getSize()-1);
                System.out.println("删除书籍成功！");
               break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("图书馆没有"+name+"这本书！");
        }
        return;
    }
}
