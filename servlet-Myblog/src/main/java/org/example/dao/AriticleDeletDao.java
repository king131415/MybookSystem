package org.example.dao;

import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AriticleDeletDao {
    public static int query(String[] ids) throws SQLException {
        Connection connection=null;
        PreparedStatement ps=null;

        try {
            connection= DBUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from article where id in (");
            for (int i=0;i<ids.length;i++){
                if(i!=0){
                    sql.append(",");
                }
                sql.append("?");
            }
            sql.append(")");
            //执行预编译命令
            ps=connection.prepareStatement(sql.toString());
            for (int i=0;i<ids.length;i++){
                ps.setInt(i+1,Integer.parseInt(ids[i]));
            }
            return ps.executeUpdate();

        }finally {
            DBUtil.close(connection,ps);
        }

    }
}
