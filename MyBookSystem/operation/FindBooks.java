/**
 * 查找书籍类，同样是实现了doOpration接口，循环遍历Book类型数组，查找书籍
 */
package MyBookSystem.operation;

import MyBookSystem.BookList;

import java.util.Scanner;

public class FindBooks implements doOpration {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入你要查找书籍的名称：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        int i=0;
        for(;i<bookList.getSize();i++){
            if(bookList.getBooks(i).getName().contains(name)){
                System.out.println(bookList.getBooks(i));
                break;
            }
        }
        if( i>=bookList.getSize()){
            System.out.println("没有找到《《"+name+"》》这本书！");
            return;
        }
    }
}
