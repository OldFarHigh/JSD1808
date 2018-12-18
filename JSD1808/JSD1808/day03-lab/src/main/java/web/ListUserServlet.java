package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtils;

public class ListUserServlet  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");//解码接收消息
			response.setContentType("text/html;charset=utf-8");//回复消息类型，和字符集
			PrintWriter out = response.getWriter();
			//step1：查询用户信息
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = DBUtils.getConn();
				String sql = "select * from t_user";
				stat = conn.createStatement();
				rs=stat.executeQuery(sql);
				//step2:依据查询到用户信息，输出表格
				out.println("<table border='1' width='60%' cellpadding='0' cellspacing='0'>") ;
				out.println("<tr><td>ID</td>"
						+ "<td>username</td>"
						+ "<td>password</td>"
						+ "<td>email</td></tr>");
				while(rs.next()) {
					int id = rs.getInt("id");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String email = rs.getString("email");
					out.println("<tr><td>"+id+"</td>"
							+ "<td>"+username+"</td>"
							+ "<td>"+password+"</td>"
							+ "<td>"+email+"</td></tr>");
				}
			} catch (Exception e) {
				e.printStackTrace();
				out.println("系统繁忙，请稍后重试");
			} finally {
				DBUtils.close(conn, stat, rs);
			}
	}
}
