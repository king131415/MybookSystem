package org.example.dao;

import jdk.nashorn.internal.ir.CallNode;
import org.example.model.User;
import org.example.util.DBUtil;

import java.sql.*;
import java.util.Date;

public class UserDao {
    public static User query(User user) throws SQLException {
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            c=DBUtil.getConnection();
            String sql="select id,nickname,sex,birthday," +
                    "head from user where username=? and password=?";
            ps=c.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs=ps.executeQuery();
            User query=null;
            while (rs.next()){
                query=new User();
                query.setId(rs.getInt("id"));
                query.setUsername(user.getUsername());
                query.setPassword(user.getPassword());
                query.setNickname(rs.getString("nickname"));
                query.setSex(rs.getBoolean("sex"));
                Timestamp birthday1 = rs.getTimestamp("birthday");
                if(birthday1!=null){
                    query.setBirthday(new Date(birthday1.getTime()));

                }
                query.setHead(rs.getString("head"));

            }
            return query;

        }catch (Exception e) {
            e.printStackTrace();
           return null;

        } finally {
            DBUtil.close(c,ps,rs);
        }

    }
}
