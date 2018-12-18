实现动态页面

想在页面上包含动态的数据，那么页面内容就不能是提前准备好的。
需要在查看的时将数据动态包含在页面代码中发送给浏览器去展示。
(现在的主流方式已经抛弃了这种方式，而是采取在浏览器展示的
页面中局部刷新方式:AJAX+JSON)

采取的解决方案为，当用户请求动态数据时，我们在服务端拼接一个
字符串，内容为HTML代码，并且将需要的动态数据包含在其中一起
生成出来，然后将拼接处的HTML代码对应的字节作为响应正文最终
响应给客户端。


1:让HttpResponse支持响应动态数据
    在HttpResponse中添加一个新的属性:byte[] contentDate
    并且在发送响应正文时，添加一个新的分支，若contentDate这个
    属性不为null时，则将该字节数组内容作为响应正文内容发送给
    客户端。
    
2:在HttpResponse中添加可以设置响应头的方法:putHeader
    允许我们设置响应发送的响应头内容     
    

3:在webapps/myweb/index.html页面中添加一个超链接，请求路径
   为:href="showAllUser"
    当用户点击该超链接后，请求路径应当为:
  http://localhost:8088/myweb/showAllUser

4:在servlets包中添加一个新的业务处理类:ShowAllUserServlet
    用于响应客户端用户列表的动态页面

5:在ClientHandler中添加一个新的分支判断，若请求路径为:
  "/myweb/showAllUser"时，实例化ShowAllUserServlet，并
   调用其service方法处理    


6:完成ShowAllUserServlet的service方法
  1:通过RandomAccessFile读取user.dat文件
  
  2:创建一个StringBuilder用来动态拼接HTML的代码内容
  
  3:在拼接到<table>时，我们将user.dat文件中读取出来的每个
        用户信息拼接到一个<tr></tr>(表格中的一行)中
  
  4:当HTML代码拼接完毕后，我们将代码转换为一组字节。
  
  5:准备响应客户端
    5.1:设置响应头:Content-Length,值为HTML代码转换的这组字节
                数组的长度
    5.2:设置响应头:Content-Type,值为页面:text/html                 
    5.3:设置响应正文为这组字节。









