/**
 * 还书类，实现了doOpration接口，循环遍历Book类型数组，找出相应书籍的状态
 */
package MyBookSystem.operation;

import MyBookSystem.BookList;

import java.util.Scanner;

public class ReturnBooks implements doOpration{
    @Override
    public void work(BookList bookList) {
//        System.out.println("还书成功！");
        System.out.println("请输入你要归还书籍的名称：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        int i=0;
        for(;i<bookList.getSize();i++){
            if(bookList.getBooks(i).getName().equals(name)){
                if(!bookList.getBooks(i).isIsborrowd()){
                    System.out.println("此书没有借出，无需归还！");
                    break;
                }else {
                    bookList.getBooks(i).setIsborrowd(true);
                    System.out.println("还书成功！");
                    return;

                }
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("图书馆没有《"+name+"》这本书！无需归还！");
            return;
        }
    }
}
