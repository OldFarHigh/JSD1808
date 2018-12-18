使得服务端支持客户端传递用户输入的数据。

我们日常上网，经常会在页面上输入信息，比如注册操作。
输入后点击按钮提交给服务端。这个过程的实现如下：
		1：首先要想让用户可以输入内容，需要在页面中添加一个表单，
			 然后在表单中添加若干个输入框，当用户输入信息后点击提交按钮，
			 然后将这个表单内容提交。

		2：当表单提交后，服务端应当在解析请求时，将用户提交的这些数据解析出来，
			 以便做后续对应的操作。
			 
			 
			 
实现：
1：准备一个注册页面，测试表单的提交、
	在webapps/myweb/下新建页面reg.html
	
2：重构HttpRequest类
	 由于请求可能会传递参数过来，所以当我们解析请求时要对参数进行解析。
	 当一个页面中的from表单以GET形式提交时，
	 所有form表单中的输入域内容会被拼接在地址栏中“？”右侧。
	 这时我么在解析请求行中的url部分时会得到类似如下内容：
	 /myweb/reg？username=xxx&password=xxxx&....
	 
	 url中“？”右侧为参数部分，每个参数以“&”进行分割，每个参数由name=value组成，
	 其中name时表单输入域的名字，value时该输入域输入的内容
	 
	 我们在HttpRequest中定义三个参数：
	 private String requestURI：保存url中的请求路径部分
	 private String queryString	：保存url中的参数部分
	 private Map<String,String> parameter  ；保存每一组参数
	 							key： 参数名  value：参数值
	 							
	 定义一个用来进一步解析url的方法：parseUrl，
	 并在解析请求行parseRequestLine方法中解析处url后调用该方法，
	 对url进一步解析。