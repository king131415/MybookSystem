/**
 * 显示书籍列表类，循环把每本书的信息给打印出来
 */
package MyBookSystem.operation;

import MyBookSystem.BookList;

public class DispBookList implements doOpration{
    @Override
    public void work(BookList bookList) {
        for(int i=0;i<bookList.getSize();i++){
            System.out.println(bookList.getBooks(i));
        }
    }
}
