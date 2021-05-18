package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        DataSource ds=new MysqlDataSource();
        //连接数据库
        ((MysqlDataSource)ds).setURL("jdbc:mysql://localhost:3306/servlet_blog");
        //数据的用户名
        ((MysqlDataSource) ds).setUser("root");
        //数据课的密码
        ((MysqlDataSource) ds).setPassword("king5258");
//        ((MysqlDataSource) ds).setUseSSL(false);//把默认提供的ssl的连接地址改成false
        //创建连接
        return ds.getConnection();
    }
    public static void close(Connection c, PreparedStatement ps, ResultSet resultSet) throws SQLException {
        resultSet.close();
        ps.close();
        c.close();
    }
    public static void close(Connection c, PreparedStatement ps) throws SQLException {
       ps.close();
       c.close();
    }
}
