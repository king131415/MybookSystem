package org.example.servlet;

import org.example.dao.AriticleAddDao;
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

@WebServlet("/articleAdd")
public class ArticleaddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");
       resp.setContentType("application/json"); //设置响应的格式为JSON格式
         //设置响应对象
        JSONResponse json=new JSONResponse();

        try {
            //解析请求数据
            Article article = JSONUtil.deserialize(req.getInputStream(), Article.class);
            //从会话层拿对象
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            //2.业务处理
            int n=AriticleAddDao.query(article,user.getId());
            json.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            json.setCode("EER");
            json.setMessage("系统出错了,请联系系统管理员！");

        }
        String s=JSONUtil.serialize(json);
        resp.getWriter().println(s);



    }
}
