package com.ms.pkgs.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 过滤器
 * 
 *
 * <p>
 *
 * @author cs12110 2018年12月6日
 * @see
 * @since 1.0
 */
@Component
public class SimpleFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(SimpleFilter.class);

	/**
	 * 设置为true,才会拦截
	 * 
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();

		logger.info(request.getRequestURI());

		return null;
	}

	/**
	 * 过滤类型
	 * <p>
	 * 
	 * pre: 可以在请求被路由之前调用 <br>
	 * route: 在路由请求时候被调用<br>
	 * post: 在route和error过滤器之后被调用<br>
	 * error: 处理请求时发生错误时被调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤优先等级
	 * 
	 * 数字越大，优先级越低
	 * 
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
