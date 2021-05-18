package org.example.dao;

import org.example.model.Article;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AriticleDetailDao {
    public static Article query(int id) throws SQLException {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;

        try {
            connection= DBUtil.getConnection();
            String sql = "select * from article where id=?";
            //执行预编译命令
            ps=connection.prepareStatement(sql);
            //替换占位符
            ps.setInt(1,id);
            resultSet = ps.executeQuery();
            Article a=null;
            while (resultSet.next()){
                a=new Article();
                //根据字段名从结果集获取
                a.setTitle(resultSet.getString("title"));
                a.setId(resultSet.getInt("id"));
                a.setContent(resultSet.getString("content"));

            }
            return a;

        }finally {
            DBUtil.close(connection,ps,resultSet);
        }
    }
}
