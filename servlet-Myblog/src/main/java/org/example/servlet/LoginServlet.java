package org.example.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.AriticleDao;
import org.example.dao.UserDao;
import org.example.model.Article;
import org.example.model.JSONResponse;
import org.example.model.User;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //响应数据为JSon格式
        resp.setContentType("application/json");
        //构造响应对象
        JSONResponse json = new JSONResponse();

        try {
            //获取请求数据
            User user=JSONUtil.deserialize(req.getInputStream(),User.class);
            //处理业务，根据输入的账户和密码查询是否有数据
            User query= UserDao.query(user);
            if(query==null){
                json.setCode("LOG001");
                json.setMessage("用户名或者密码错误！");
            }else {//用户名密码校验成功
                json.setSuccess(true);
                //创建一个session对象，req.getSession是建立会话对象
                HttpSession session = req.getSession();
                //把输入的user与从数据库查询出来的user建立对应关系
                session.setAttribute("user",query);

            }
        } catch (Exception e) {
            e.printStackTrace();
            //业务处理失败，返回false+错误码+错误信息
            json.setCode("EER");
            json.setMessage("系统出错了，联系系统管理员");
        }


        //把返回给前端的数据序列化json字符串
        String s= JSONUtil.serialize(json);
        //打印输出
        resp.getWriter().println(s);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
