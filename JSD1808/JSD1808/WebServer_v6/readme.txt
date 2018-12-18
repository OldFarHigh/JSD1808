使服务端支持响应不同类型的资源给客户端

当用户请求一个页面时，服务端将该页面的html代码响应回去后，浏览器解析时若发现该页面存在图片时，
会再次发起连接向服务器请求该图片资源。这时服务器端应当将该图片响应回去

所以当一个页面中存在其他资源时，构成这个页面会经历数次请求响应来完成。

但是如果希望浏览器能正确理解其请求的资源，要求服务端在响应该资源时在响应头中指定的Content-Type必须准确

不同的资源的类型有不同的值，这些都是有定义的。
我们可以参考tomcat安装目录中conf目录中的web.xml文件，该文件整理出了这些类型，有1000多个。


修改HttpResponse,首先发送的响应头不能是固定值，该根据实例响应需求进行变化。

	1、在HttpResponse中定义响应头的相关属性：Map headers
	并且对外提供设置响应头和获取响应头信息的相关方法。

	2、修改发送响应头的方法，将原来固定发送的两个响应头：
	 Content-Type和Content-Length改变为遍历headers，将每个响应头进行发送。
	 
	3、在http包中定义了一个类：HttpContext，使用这个类来定义所有有关http协议的内容。
		这里先定义相关Content-Type对应值的一组信息：
		3.1定义一个Map类型的静态属性：mimeTypeMapping
			其中key保存资源的后缀名，
			value保存mime类型（Content-Type对应的值）
			
		3.2定义一个私有的静态方法用于初始化这个Map
		3.3在HttpContext的静态块中调用这个初始化方法来进行初始化操作
		（因为都是静态变量，所以不能创建构造方法用以初始化）
		3.4定义一个共有的静态方法：getMimeType
			该方法可根据文件的后缀名获取对应的mime类型。
			
	4、修改HttpResponse的setEntity方法，在该方法中除了将给定的File文件设置到对应属性entity之外，
	再根据该文件向响应头对应的Map属性headers中添加Conetent-Type与Content-Length
	其中Content-Type的值要根据该文件后缀调用3.4的方法获取对应的值