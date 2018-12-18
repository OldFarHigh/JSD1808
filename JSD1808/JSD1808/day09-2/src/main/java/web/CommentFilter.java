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
/**
 * javax.servlet.*;与具体协议无关的接口与类
 * javax.servlet.http.*;与http协议有关的接口与类
 * @author OldFarHigh
 *
 */
public class CommentFilter implements Filter{
	private FilterConfig config;
	/**
	 *1、容器启动之后，会立即创建过滤器实例，且只会创建一个实例
	 */
	public CommentFilter() {
		System.out.println("Comment's Filter...");
	}
	/**
	 * 容器在删除过滤器之前，会调用destory方法。该方法只会执行一次！
	 */
	public void destroy() {
		System.out.println("CommentFilter's destory...");
	}
	/**
	 *容器在受到请求之后，会调用doFilter方法来处理（类似于servlet的service方法）。
	 *FilterChain(过滤器链)
	 *		如果调用了过滤器链的doFilter方法，表示继续向后调用（即继续调用后续的过滤器，如果没有了，最后再
	 *	servlet的service方法）
	 *		如果没有调用过滤器的doFilter'方法，则不再向后调用，而是返回处理结果。
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("CommentFilter's doFilter begin...");
		/*
		 * 因为sun公司过渡设计，所以在doFilter方法里面，开发人员需要做强制转换
		 * ServletRequest是HttpServletRequest的父接口，
		 * ServletResponse是HttpServletResponse的父接口。
		 */
		HttpServletRequest request =(HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//读取评论的内容
		String content = request.getParameter("content");
		//读取初始化参数
		String illegal = config.getInitParameter("illegal");
		if(content.indexOf(illegal)!=-1) {
			response.getWriter().println("评论包含了违禁词");
		}else {
			//继续向后调用
			arg2.doFilter(request, response);
		}
		System.out.println("CommentFilter's doFilter end...");
	}
	/**
	 * 2、实例化之后，容器会调用init方法。该方法只会执行一次
	 * FilterConfig可以用来读取初始化参数
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("CommentFilter's init...");
		//将容器传递过来的FilterConfig对象保存下来
		config = arg0;
	}
	
	
}
