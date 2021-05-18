package org.example.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.AriticleDao;
import org.example.model.Article;
import org.example.model.JSONResponse;
import org.example.model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/articleList")
public class ArticleServletList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //响应数据为JSon格式
        resp.setContentType("application/json");

        JSONResponse json = new JSONResponse();

        try {
            //文章列表查询(数据库查询所有数据）
            //getSeesion(false),表示从服务端回去会话对象
            HttpSession session = req.getSession(false);
            User user= (User) session.getAttribute("user");
//
//            if(user==null){ //如果之前没有创建会话对象,那user就为空
//                //uesr为空，表示访问敏感资源，就来个重定向
////               //设置转发服务路径
//                RequestDispatcher re = req.getRequestDispatcher("src\\main\\webapp\\login.html");
////                //执行请求，前进
//                  re.forward(req,resp);
////                resp.setStatus(302);
////                resp.setHeader("Location", "http://www.baidu.com");
//
//                return;
////
//            }
             List<Article> query = AriticleDao.query(user.getId());
            //业务处理成功：返回success true
            json.setSuccess(true);
            json.setData(query);

        } catch (Exception e) {
            e.printStackTrace();
            //业务处理失败，返回false+错误码+错误信息
            json.setCode("EER");
            json.setMessage("系统出错了，联系系统管理员");
          }

           ObjectMapper m=new ObjectMapper();
           //把返回给前端的数据序列化json字符串
           String s=m.writeValueAsString(json);
           //打印输出
           resp.getWriter().println(s);


      }


}

