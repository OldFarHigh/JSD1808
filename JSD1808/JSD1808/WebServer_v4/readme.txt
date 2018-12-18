完成处理请求工作

当用户在浏览器访问一个页面时，输入路径如：
http://localhost:8088/myweb/index.html

我们在请求中可以得到抽象路径部分：/myweb/index.html
但这是一个典型的相对路径，我们要在服务端定义该路径相对的位置，以便找到该资源。

在当前项目目录下新建一个目录webapps,用这个目录保存每一个在服务器上运行的web应用
一个web应用简单说就是一个网站的一切内容，包括素材（网页，图片，样式等）和业务逻辑

webapps下面用一个子目录保存一个web应用。先在其下创建一个名为myweb的目录，用作我们测试使用

在webapps/myweb目录下新建第一个页面：index.html

当用户在浏览器输入：
http://localhost:8088/myweb/index.html时，
我们得到抽象路径：/myweb/index.html后，
我们从webapps目录作为相对的当前目录开始，
就可以找到对应资源了。

变象理解为：
http://localhost:8088访问服务器，
就是访问webapps目录内容，
所有请求的后续资源都从webapps目录下开始找起。


在ClientHandler中通过请求中的资源路径到webapps目录下找到对应资源后，
发送一个响应内容回复客户端。