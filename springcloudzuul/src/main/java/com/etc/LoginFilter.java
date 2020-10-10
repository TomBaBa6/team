package com.etc;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter extends ZuulFilter {
    private final Logger LOGGER = LoggerFactory.getLogger(LoginFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 0;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        LOGGER.info("session.getAttribute('user'):" + user);
        LOGGER.info("--->>> LoginFilter {},{}", request.getMethod(), request.getRequestURL().toString());
        String url=request.getRequestURL().toString();
        if (user != null) {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            ctx.setResponseBody("你成功了！");
            return null;
        } else {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.getResponse().setCharacterEncoding("UTF-8");
            ctx.getResponse().setContentType("text/html;charset=UTF-8");

            ctx.setResponseBody("<a href='/index?url="+url+"'>请先登陆！</a>");
            ctx.set("isSuccess", false);
            return null;
        }
    }
}