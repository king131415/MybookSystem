/**
 * 抽象的用户登录类，用来给管理员或者正常用户来登录实现
 */
package MyBookSystem;

import MyBookSystem.operation.doOpration;

public  abstract class User {
    protected String name;
    protected doOpration[] opration;
    public abstract int menu();
   protected void doopration(BookList bookList , int chioce){
        opration[chioce-1].work(bookList);
    }
}
