package org.example.servlet;

import org.example.dao.AriticleUpdateDao;
import org.example.model.Article;
import org.example.model.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/articleUpdate")
public class AricleUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
         //创建响应对象
        JSONResponse json=new JSONResponse();
        try {
            //根据请求body中的字符串构造响应的实体类对象
            Article a = JSONUtil.deserialize(req.getInputStream(), Article.class);
            AriticleUpdateDao.query(a);
            //业务成功
            json.setSuccess(true);
        }catch (Exception e){
            json.setCode("EER");
            json.setMessage("系统出错，请联系,系统管理员！");
        }
        String s=JSONUtil.serialize(json);
        resp.getWriter().println(s);


    }
}
