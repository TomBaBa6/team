package com.etc;

import com.netflix.zuul.IZuulFilter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PasswordFilter extends ZuulFilter {

    public static final Logger logger = LoggerFactory.getLogger(ZuulFilter.class);


    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }


    @Override
    public boolean shouldFilter() {
        RequestContext context= RequestContext.getCurrentContext();
        return (boolean)context.get("isSuccess");
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context=RequestContext.getCurrentContext();
        HttpServletRequest request=context.getRequest();
        logger.info("---------->>>>>>>>>"+"请求方法"+request.getMethod()+"请求URL"+ request.getRequestURL().toString());
        String password=request.getParameter("password");
        if(password !=null && password.equals("123456")){
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
            context.set("isSuccess",true);
            return null;
        }
        else{
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(400);
            context.setResponseBody("password is empty or error");
            context.set("isSuccess",false);
            return null;
        }
    }


}
