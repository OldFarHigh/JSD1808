实现登录功能

1：在webapps/myweb页面下新建三个页面
	login.html:登陆页面
					该页面要求用户输入用户名及密码，form表单提交的action=“login”。
	login_success.html:登陆成功提示页面
	login_fail.html：登录失败页面
	
2：在com.webserver.servlets包中添加一个类：LoginServlet
	并在该类中定义service方法（与RegServlet方法定义相同）
	在该方法中首先通过request获取用户名及密码
	然后通过RandomAccessFile读取user.dat文件，
	顺序读取每个用户名的名字与该用户名比对，
	若找到则比对密码，若密码输入正确则跳转登录成功页面。
	若密码输入错误，或该用户在user.dat文件中不存在，则跳转登录失败页面。
	
3：在ClientHandler中判断处理注册业务的分支之下再添加一个分支判断请求路径是否为：myweb/login
	若是则实例化LoginServlet并调用其service方法处理登录。