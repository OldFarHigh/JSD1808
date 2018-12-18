支持tomcat中所有的介质类型

tomcat的安装目录中的conf目录里有一个web.xml文件，
该文件中整理了所有Content-Type所支持的值，我们将它们解析出来用于初始化HttpContent中mimeTypeMapping

			1:在当前项目目录下新建一个目录conf
			2:即：将tomcat安装目录中conf/web.xml拷贝到我们的conf目录中
			3:修改HttpContext初始化mimeTypeMapping的方法：
			initMimeTypeMapping
	
			将原有直接向mimeTypeMapping这个Map中put元素的代码全部删除，
			改为通过解析conf/web.xml中所有的mime来完成初始化