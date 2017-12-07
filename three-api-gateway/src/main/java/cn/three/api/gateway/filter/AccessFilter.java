package cn.three.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/11/24 0024.
 */
public class AccessFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    //过滤器的类型,他决定过滤器在请求的那个生命周期中执行
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器的执行顺序,当请求在一个阶段中存在多个过滤器,需要根据该方法返回值依次执行
    @Override
    public int filterOrder() {
        return 0;
    }

    //判断该过滤器是否需要被执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器逻辑
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {}" ,request.getMethod(),request.getRequestURL().toString());

        Object accessToken = request.getParameter("token");
        if (accessToken==null){
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("401");
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
