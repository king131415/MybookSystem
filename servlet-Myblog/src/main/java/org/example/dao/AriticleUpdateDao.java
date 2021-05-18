package org.example.dao;

import org.example.model.Article;
import org.example.util.DBUtil;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AriticleUpdateDao {
    public static void query(Article a) throws SQLException {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection= DBUtil.getConnection();
            String sql = "update article set title=?,content=? where id=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,a.getTitle());
            ps.setString(2,a.getContent());
            ps.setInt(3,a.getId());
            ps.executeUpdate();
        } finally {
            DBUtil.close(connection,ps);
        }


    }
}
