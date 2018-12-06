package com.ms.pkgs.handler;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 日志类
 * 
 *
 * <p>
 *
 * @author cs12110 2018年12月6日
 * @see
 * @since 1.0
 */
@Aspect
@Order(5)
@Configuration
public class LogHandler {

	private ThreadLocal<Long> stopwatch = new ThreadLocal<>();

	/**
	 * before
	 */
	@Before("execution(* com.ms.pkgs.ctrl..*.*(..))")
	public void before(JoinPoint joinPoint) {
		stopwatch.set(System.currentTimeMillis());

		Signature signature = joinPoint.getSignature();
		Class<?> targetClass = signature.getDeclaringType();
		Logger logger = LoggerFactory.getLogger(targetClass);

		HttpServletRequest request = getReq();

		// 打印请求日志
		logger.info("Req:{} {} -> {}", request.getRequestURL(), request.getMethod(),
				simplify(targetClass) + "#" + signature.getName());
	}

	/**
	 * 类名简单化
	 * 
	 * @param clazz
	 *            class
	 * @return String
	 */
	private String simplify(Class<?> clazz) {
		if (clazz == null) {
			return "N/A";
		}

		StringBuilder b = new StringBuilder();
		String origin = clazz.getName();
		int left = 0;
		while (true) {
			int next = origin.indexOf(".", left);
			if (next == -1) {
				break;
			}
			b.append(origin.charAt(left));
			b.append(".");
			left = next + 1;
		}

		b.append(origin.substring(left));

		return b.toString();
	}

	/**
	 * 获取系统HttpServletRequest
	 * 
	 * @return {@link HttpServletRequest}
	 */
	private HttpServletRequest getReq() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attributes.getRequest();
	}

	/**
	 * after
	 * 
	 * @param joinPoint
	 */
	@After("execution(* com.ms.pkgs.ctrl..*.*(..))")
	public void after(JoinPoint joinPoint) {
		long mills = System.currentTimeMillis() - stopwatch.get();

		Signature signature = joinPoint.getSignature();
		Class<?> targetClass = signature.getDeclaringType();
		Logger logger = LoggerFactory.getLogger(targetClass);

		logger.info("Spend:{} mills", mills);

		stopwatch.remove();
	}

}
