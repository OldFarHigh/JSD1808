package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BmiServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws 
	ServletException, IOException {
		
		//��ȡ��ߺ�����
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		
		/*
		 * �������ˣ�һ��Ҫ���������ֵ���Ϸ��Եļ�飬
		 * ���磬�����ߺ������Ƿ��Ƿ����ֵȵȣ����
		 * ������Ҫ��Ҫ��ʾ�û������޸ġ�
		 */
		
		//������ߺ����أ�����BMIָ��
		double bmi = Double.parseDouble(weight)/
				Double.parseDouble(height)/
				Double.parseDouble(height);
		
		//�����������͸������
		/*
		 * 1������content-type��Ϣͷ��ֵ
		 * 2��out.println������ʹ��ָ�����ַ���������
		 */
		response.setContentType("text/html;charset=utf-8");
		/*
		 * out.println()������Ĭ��ʹ��ISO-8859-1����ַ��������롣��������ģ��ᷢ��������󣬲����������⡣
		 */
		response.getWriter().println("���BMIָ����:" + bmi);
	}
	
	
}





