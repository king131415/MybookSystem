/**
 * 借书类，同样是实现了operation接口，实现了借书操作
 */
package MyBookSystem.operation;

import MyBookSystem.BookList;

import java.util.Scanner;

public class BorrowBooks implements doOpration{
    @Override
    public void work(BookList bookList) {
        System.out.println("借书成功！");
        System.out.println("请输入你要借的书籍的名称：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        int i=0;
        for(;i<bookList.getSize();i++){
            if(bookList.getBooks(i).getName().equals(name)){
                if(!bookList.getBooks(i).isIsborrowd()){
                    System.out.println("借书成功！");
                    bookList.getBooks(i).setIsborrowd(true);
                       return;
                }else if(bookList.getBooks(i).isIsborrowd()){
                    System.out.println("不好意思，此书已经被借出去了！");
                    return;
                }
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("不好意识，图书馆没有《"+name+"》这本书！");
            return;
        }
    }
}
