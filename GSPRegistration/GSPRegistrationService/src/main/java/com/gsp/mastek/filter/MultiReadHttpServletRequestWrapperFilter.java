package com.gsp.mastek.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
  *
 */
@WebFilter
@Component
@Order(1)
public class MultiReadHttpServletRequestWrapperFilter implements Filter
{
	public void init ( FilterConfig fc ) throws ServletException
	{
	}

	public void doFilter (
			ServletRequest request,
			ServletResponse response,
			FilterChain chain ) throws IOException,	ServletException
	{
		chain.doFilter(new MultiReadHttpServletRequestWrapper((HttpServletRequest) request), response);
	}

	public void destroy ()
	{
	}
}