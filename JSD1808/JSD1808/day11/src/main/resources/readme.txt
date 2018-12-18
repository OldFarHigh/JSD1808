1、JSP
###（1）什么是jsp？
###（2）如何写一个jsp文件？
	a.java代码片段
	<% java代码片段%>
	b.jsp表达式
	<%= java表达式%>
	c.jsp声明
	<%!声明一个变量或者方法%>
3)隐含对象
	a、什么是隐含对象？
	直接可以使用的对象。
	b、为什么可以直接使用这些隐含对象？
	容器会自动添加获得这些对象的代码。
	c、有哪些隐含对象呢？
	out,response,request,
	session,application,
	pageContext:页面上下文（a2.jsp,a3.jsp）
			容器会为每一个jsp实例创建唯一的一个符合PageContext接口要求的对象，
			该对象会一直存在，除非jsp实例会被容器删除。
			该对象的作用主要有两个：
				作用1：绑定数据。
					绑定到PageContext上的数据，只有对应jsp实例能够访问到。
				作用2：提供了一些方法，用来获得其他所有的隐含对象
	config:ServletConfig(a4.jsp)
			可以为jsp配置初始化参数，然后通过config读取。
	exception:(a5.jsp,a6.jsp)
			当page指令的isErrorPage属性值设置为true时，可以使用该隐含对象，
			该隐含对象可以用来获得jsp运行时产生的一些简短的描述。
	page(了解)：jsp实例本身（jsp对应的servlet实例）。
4)指令
	a、什么是指令？
		可以通过指令告诉容器，在将jsp转换称servlet时，做一些额外的处理，比如导包。
	b、有哪些指令？
		page指令
			import属性：导包
			pageEncoding属性：指定jsp文件的编码。
			contentType属性：response.setContentType方法的内容。
			errorPage属性：指定一个异常处理页面。当jsp运行发生异常，容器会调用该异常处理页面
			isErrorPage属性：缺省值时false，如果值为true，就可以使用exception隐含对象。
			session属性（a7.jsp）：缺省值是true，如果值为false，则不能够使用session隐含对象
			includee指令：
				file指令:指定被包含的文件。
			taglib指令：
				导入要引用的jsp标签。
5)注释：
	a.<!--注释内容 -->
			如果注释内容是java代码，java代码会执行。
	b.<%--注释内容--%>
			如果注释内容是java代码，java代码不会执行。
###（3）jsp是如何执行的？
Step1：容器要将jsp转换称一个servlet
	html(css,js)---->在service方法里面，使用out.write输出。
	<%  %>------>照搬到service方法里面
	<%= %>------>在servlet里面使用out.println输出。
	<%! %>------>为servlet增加新的属性或者新的方法
Step2.容器调用该servlet
	
#2.jsp标签和el表达式
##（1）jsp标签是什么？
	jsp标签是sun公司推出的规范，目的是为了替换jsp中的java代码
		jsp标签语法类似与html标签（比如说，有开始标记、结束标记、有一些属性，有标签体。）
		容器遇到jsp标签之后，会调用jsp标签对应的jsp标签类中的java代码。
		
		使用jsp标签的好处是：jsp文件便于美工去修改，另外也便于代码的复用（jsp标签可以重用）
##（2）el表达式是什么？
一套简单的运算规则，用于给jsp标签的属性赋值，也可以脱离jsp标签，直接使用。

##（3）el表达式的使用
1）读取bean的属性值
	注：
		javabean是一个规范，满足以下几个条件，就可以称之为一个javabean。
		public类
		public构造器
		实现Serializable接口
		有一些属性及对应的get/set方法
a、方式一（e1.jsp）
	${user.username}
		a1.执行过程：容器依次从pageContext-->request--->session-->application中
		查找绑定名为“user”的对象（getAttribute），找到之后，
		调用该对象的“getUsername”方法，然后输出。
		
		a2、优点：
			会将null转换成“”输出。
			如果依据绑定名找不到对应的对象，不会空指针异常的错误。
		a3、指定查找范围：
			可以使用pageScope，requestScope,sessionScope,aalicationScope来指定查找范围
b、方式二
	${user['username']}
		b1、执行过程同上
		b2、【】里面可以出现绑定名
		b3、【】可以出现从0开始的下标，用来访问数组里的某个元素。
		
#练习：
	使用el表达式输出员工对象的各个属性值
	Employee类（ename,salary,age）
		