/**
 * 程序正常终止类，安全退出程序
 */
package MyBookSystem.operation;

import MyBookSystem.BookList;

public class ExitSystem implements doOpration {

    @Override
    public void work(BookList bookList) {
       System.exit(0);
    }
}
