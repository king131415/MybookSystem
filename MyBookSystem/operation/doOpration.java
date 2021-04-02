/**
 * 操作接口，给其他具体的操作类来实现
 */
package MyBookSystem.operation;

import MyBookSystem.BookList;

public interface doOpration {
    void work(BookList bookList);
}
