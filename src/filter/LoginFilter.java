package filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/index.jsp")
public class LoginFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getServerName());
		Enumeration<String> e = request.getParameterNames();
//		while(e.hasMoreElements()) {
//			System.out.println(e.nextElement());
//		}
		System.out.println("forbidden");
		return;
//		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init Login Filter");

	}
}
