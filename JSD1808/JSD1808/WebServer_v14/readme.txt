使得服务端支持POST请求（这里只支持POST提交的表单数据）

在实际开发中，当表单中包含用户隐私信息，或者上传附加等操作时，一定要使用POST请求

对于我们之前的注册和登录功能而言，由于表单中含有用户隐私信息，
对此我们将这些form表单的提交形式改为post，而当表单提交形式改为post后，
所有输入域的内容不会再被拼接到URL的“？”右侧，而是将原“？”右侧的内容包含在消息正文中被提交。

具体修改如下：
	1：将页面中表单的提交方式改为：POST
	2：当表单提交后，浏览器地址栏中不再包含“？”以及参数部分。而是这部分内容会被包含在请求的消息正文中。
		这时解析请求的消息头部分会发现多出两个头：
		Content-Length=xx
		Content-Type=application/x-www-form-urlencoded
		分别告知浏览器消息正文长度以及正文内容的类型。
		“application/x-www-form-urlencoded”是一个固定值，
		是用来表示此消息正文内容是一个字符串，是原get请求中“？”右侧的内容。
		
		完成HttpRequest类中解析消息正文的方法：parseContent
		解析消息正文前首先判断消息头中是否含有Content-Length，
		若有，则说明这个请求包含消息正文。
		
		获取消息头Content-Length的值，然后通过输入流读取对应长度的字节量。
		再获取消息头Content-Type，判断此正文类型，这里只判断是否为页面form表单提交上来的用户输入的数据：
		application/x-www-form-urlencoded
		若是，则将读取的正文字节转换为一组字符串，并进行解析参数操作。