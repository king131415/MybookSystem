package org.example.servlet;


import org.example.dao.AriticleDeletDao;
import org.example.model.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/articleDelete")
public class AritcleDeletServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");
       resp.setContentType("application/json");
        JSONResponse jsion=new JSONResponse();
        try {
            String ids = req.getParameter("ids");
            String[] Ids = ids.split(",");
            //业务处理
            int n= AriticleDeletDao.query(Ids);
            jsion.setSuccess(true);

        }catch (Exception e){
            jsion.setCode("EER");
            jsion.setMessage("出错了，请联系管理员！！");

        }
        String s= JSONUtil.serialize(jsion);
        resp.getWriter().println(s);


    }
}
