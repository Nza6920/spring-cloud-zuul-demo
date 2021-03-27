package com.niu.spring.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 前置过滤器
 * 检查 Header 是否存在 sys-correlation-id
 * 不存在则在首部添加
 *
 * @author [nza]
 * @version 1.0 [2021/03/08 22:09]
 * @createTime [2021/03/08 22:09]
 */
@Component
@Slf4j
@AllArgsConstructor
public class TrackingFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;

    /**
     * 告诉 Zuul 该过滤器的类型 (前置 | 路由 | 后置)
     *
     * @return {@link String}
     * @createTime 2021/3/8 22:31
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 定义不同类型过滤器的执行顺序
     *
     * @return {@link int}
     */
    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    /**
     * 判断该过滤器是否要执行
     *
     * @return {@link boolean}
     */
    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    /**
     * 过滤器逻辑代码
     *
     * @return {@link Object}
     * @author nza
     * @createTime 2021/3/8 22:40
     */
    @Override
    public Object run() throws ZuulException {

        // 获取当前请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();

        log.info("TrackingFilter 处理请求: {}", ctx.getRequest().getRequestURI());

        return null;
    }
}
