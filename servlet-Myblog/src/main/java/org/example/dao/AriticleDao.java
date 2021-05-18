package org.example.dao;

import org.example.model.Article;
import org.example.util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AriticleDao {
    public static List<Article> query(int userId) throws SQLException {
        //JDBC 查询用户关联的文章数据
        //1.创建连接Connection
        Connection c = DBUtil.getConnection();
//        System.out.println(c); //打印连接对象

        //2.创建操作命令对象Statement
        String sql="select id, title from article where user_id=?";
       //预编译命令
        PreparedStatement ps=c.prepareStatement(sql);
        //替换占位符
        ps.setInt(1,userId);
        //3.执行sql
        ResultSet resultSet = ps.executeQuery();


        List<Article> query=new ArrayList<>();
        //4.如果是查询操作，处理结果集
        while (resultSet.next()){
            //获取id字段的值
            int id = resultSet.getInt("id");
            //获取title字段的值
            String title = resultSet.getString("title");
            //每一行数据对应一个文章对象
            Article a=new Article();
            a.setId(id);
            a.setTitle(title);
            query.add(a);//每一个文章对象添加到文章List中去

        }
        //5.释放资源
        DBUtil.close(c, ps, resultSet);
        return query;
    }



    public static void main(String[] args) throws SQLException {
        List<Article> a= query(1);
        System.out.println(a);
    }
}
