package com.wsy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class LoginFilter extends ZuulFilter {

    //过滤器类型
    //PRE_TYPE：前置过滤器(经过路由之前)
    //ROUTE_TYPE：路由过滤器(将请求路由到对应的微服务时进行)
    //POST_TYPE：后置过滤器(将请求路由到对应的微服务后执行)
    //ERROR_TYPE：错误过滤器(在其他阶段发生错误时执行)
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    //过滤器的执行顺序，越小越先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    //确定过滤器是否进行过滤 false：放行 true：拦截
    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        System.out.println("URI:"+request.getRequestURI());
        System.out.println("URL:"+request.getRequestURL());
        System.out.println("Token："+request.getHeader("token"));

//        if (request.getRequestURI().equalsIgnoreCase("/gate/product/api/product/getProductById")){
//            return true;
//        }
        return false;
    }

    //执行拦截处理
    @Override
    public Object run() throws ZuulException {
        System.out.println("请求被拦截了！==========================");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //登录身份标识
        String token = request.getHeader("token");
        //如果token不为空，表示未登录，从redis中获取用户信息
        if(!StringUtils.isBlank(token)){
            //从redis中获取用户信息
        }else {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }
        return null;
    }
}
