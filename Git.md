###Linux上安装Git
$ git `查看安装GIT`
The program 'git' is currently not installed. You can install it by typing:sudo apt-get install git
sudo apt-get install git `Debian或Ubuntu Linux,完成Git的安装`
sudo apt-get install git-core `老一点的Debian或Ubuntu Linux`
###安装完成
$ git config --global user.name "Your Name" `你的名字`
$ git config --global user.email "email@example.com"  `Email地址
--globle     `对本机器上所有的git仓库进行统一的设置
$ git init   `初始化一个参数`
$ mkdir binName  `创建目录`
$ pwd        `显示当前目录`
$ ls -ah     `查看隐藏目录`
$ git add fileName `添加文件到仓库,可以添加多次`
$ git commit -m "说明注释"  	`看到自己每次的版本具体修改情况
$ git status  `仓库当前的状态`
$ git diff 	  `查看difference修改内容`
$ git log	  `查看提交历史`  $git log --pretty=oneline `可以调整显示方式,全部的id` $git log --oneline `调整显示方式 只有commit id 前7位`
$ git log --reflog `查看所有版本`
$ git reset --hard HEAD^  `回退到上个版本`      HEAD`表示当前版本`  HEAD`上一个版本`  HEAD^^`上上一个版本`   HEAD~100`回退到上100个版本`
$ git reset --hard commit id `版本回退到指定版本commit id 版本`
$ git reflog `查看命令历史`
$ git checkout -- readme.txt `丢弃工作区的修改,让这个文件回到最近一次git commit或git add时的状态`
$ git reset HEAD readme.txt

###远程端版本回退

1、push的时候用--force，强制把远程库变成a -> b -> d，大部分公司严禁这么干，会被别人揍一顿

2、做一个反向操作，把自己本地变成a -> b -> c -> d，注意b和d文件快照内容一莫一样，但是commit id肯定不同，再push上去远程也会变成 a -> b -> c -> d
简单地说就是你无法容易地抹去远程库的提交信息，所以本地提交怎么都行，push前想好了
###vi & vim 有两种工作模式：

（1） 命令模式：接受、执行 vi & vim 操作命令的模式，打开文件后的默认模式；
（2） 编辑模式：对打开的文件内容进行 增、删、改 操作的模式； 在编辑模式下按下 ESC 键，回退到命令模式。
创建、打开文件：$ vi [filename]

（1）使用 vi 加 文件路径（或文件名）的模式打开文件，如果文件存在则打开现有文件，如果文件不存在则新建文件，并在终端最下面一行显示打开的是一个新文件。
（2）键盘输入字母 “i”或“Insert”键进入最常用的插入编辑模式。
####3、保存文件：

（1）在插入编辑模式下编辑文件。
（2）按下 “ESC” 键，退出编辑模式，切换到命令模式。
（3）在命令模式下键入"ZZ"或者":wq"保存修改并且退出 vi 。
（4）如果只想保存文件，则键入":w"，回车后底行会提示写入操作结果，并保持停留在命令模式。
####4、放弃所有文件修改：

（1）放弃所有文件修改：按下 "ESC" 键进入命令模式，键入 ":q!" 回车后放弃修改并退出vi。
（2）放弃所有文件修改，但不退出 vi ，即回退到文件打开后最后一次保存操作的状态，继续进行文件操作：按下 "ESC" 键进入命令模式，键入 ":e!" ，回车后回到命令模式
####vi readme.txt
进入VIM编辑器,可以新建文件也可以修改文件
如果这个文件，以前是没有的，则为新建，则下方有提示为新文件。

按ESC键 跳到命令模式，然后：

:w `保存文件但不退出vi`
:w file `将修改另外保存到file中，不退出vi`
:w! `强制保存，不退出vi`
:wq `保存文件并退出vi`
:wq! `强制保存文件，并退出vi`
q: `不保存文件，退出vi`
:q! `不保存文件，强制退出vi`
:e! `放弃所有修改，从上次保存文件开始再编辑`
