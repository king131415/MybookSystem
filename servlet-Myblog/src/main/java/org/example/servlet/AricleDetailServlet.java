package org.example.servlet;

import org.example.dao.AriticleDetailDao;
import org.example.model.Article;
import org.example.model.JSONResponse;
import org.example.util.DBUtil;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/articleDetail")
public class AricleDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        JSONResponse json=new JSONResponse();
        try {
            String userId = req.getParameter("id");
            int id = Integer.parseInt(userId);
            //业务处理，根据用户id查询文章详情
            Article a = AriticleDetailDao.query(id);
            json.setSuccess(true);
            json.setData(a);
        }catch (Exception e){
            e.printStackTrace();
            json.setCode("EER");
            json.setMessage("出错了请联系系统管理员！");
        }
        String s= JSONUtil.serialize(json); //将Json对象序列化为JSON字符串
        resp.getWriter().println(s);//返回响应给前端


    }
}
