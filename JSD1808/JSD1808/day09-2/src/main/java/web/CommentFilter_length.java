package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter_length implements Filter {
	private FilterConfig config;
	public void destroy() {
		System.out.println("字数检查过滤器被销毁了。。。");
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("开始检查字数。。。");
		HttpServletRequest request =(HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//读取评论的内容
		String content = request.getParameter("content");
		int number =Integer.parseInt(config.getInitParameter("number"));
		if(content.length()>number) {
			//评论字数超过10
			response.getWriter().println("评论字数过多");
		}else {
			arg2.doFilter(request, response);
		}
		System.out.println("字数检查完毕。。。");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化检查字数过滤器。。");
		config = arg0;
	}

}
