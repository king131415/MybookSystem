package org.example.fliter;

import org.example.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFliter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //处理http请求和响应
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //获取请求的路径（服务路径）
        String uri = req.getServletPath();
        //不满足公开资源的条件（必须登录后才能访问）
        if(!uri.startsWith("/static/") && !uri.equals("/login.html")
                && !uri.equals("/login2.html") && !uri.equals("/login")
                && !uri.equals("/login2")){
            HttpSession session = req.getSession(false);
            if(session != null){
                User user = (User) session.getAttribute("user");
                if(user != null){//已登录，允许访问
                    //可以访问，放行
                    chain.doFilter(request, response);
                    return;
                }
            }
            String scheme = req.getScheme();//url中http
            String host = req.getServerName();//ip或域名
            int port = req.getServerPort();//port
            String contextPath = req.getContextPath();//应用上下文路径
            String basePath = scheme+"://"+host+":"+port+contextPath;
            resp.sendRedirect(basePath+"/login.html");//重定向到登录页面
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
