package org.example.dao;

import org.example.model.Article;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AriticleAddDao {
    public static int query(Article article, Integer userId) throws SQLException {
        //获取数据库连接
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBUtil.getConnection();
            //创建Sql
            String sql = "insert into article(title, content, user_id) values(?,?,?)";
            //执行预编译命令
            ps = connection.prepareStatement(sql);
            //替换占位符
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, userId);
            return ps.executeUpdate();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        } finally {
            DBUtil.close(connection,ps);
        }
    }
}
