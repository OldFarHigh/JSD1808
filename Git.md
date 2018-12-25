###Linux上安装Git
$ git `查看安装GIT`
The program 'git' is currently not installed. You can install it by typing:sudo apt-get install git
sudo apt-get install git `Debian或Ubuntu Linux,完成Git的安装`
sudo apt-get install git-core `老一点的Debian或Ubuntu Linux`
###LINUX指令
$ mkdir binName  `创建目录`
$ pwd        `显示当前目录`
$ ls -ah     `查看隐藏目录`
$ rm readme.txt `删除文件`
###GIT指令
$ git config --global user.name "Your Name" `你的名字`
$ git config --global user.email "email@example.com"  `Email地址
--globle     `对本机器上所有的git仓库进行统一的设置
$ git init   `初始化一个参数`
$ git add fileName `添加文件到仓库,可以添加多次`
$ git commit -m "说明注释"  	`看到自己每次的版本具体修改情况
$ git status  `仓库当前的状态`
$ git diff 	  `查看difference修改内容`
$ git log	  `查看提交历史`  $git log --pretty=oneline `可以调整显示方式,全部的id` $git log --oneline `调整显示方式 只有commit id 前7位`
$ git log --reflog `查看所有版本`
$ git reset --hard HEAD^  `回退到上个版本`      HEAD`表示当前版本`  HEAD`上一个版本`  HEAD^^`上上一个版本`   HEAD~100`回退到上100个版本`
$ git reset --hard commit id `版本回退到指定版本commit id 版本`
$ git reflog `查看命令历史`
$ git checkout -- readme.txt `丢弃工作区的修改,让这个文件回到最近一次git commit或git add时的状态,相当于“一键还原”`
$ git reset HEAD readme.txt  `把暂存区的修改撤销掉（unstage），重新放回工作区`
$ git rm readme.txt `版本库中删除文件`
$ git remote add origin git@github.com:yourmail/learngit.git `关联远程库`  --orign`远程库默认的名字`
$ git push -u origin master `第一次当前分支master推送到远程` 
-u参数 	`git会将本地的master分支内容推送的远程新的master分支，还会把本地的master分支和远程的master分支关联起来，在以后的推送或者拉取时就可以简化命令`
$ git push origin master `把本地master分支的最新修改推送至GitHub`
$ git clone git@github.com:yourmail/gitskills.git `克隆一个本地库`

###SSH警告
The authenticity of host 'github.com (xx.xx.xx.xx)' can't be established.
RSA key fingerprint is xx.xx.xx.xx.xx.
Are you sure you want to continue connecting (yes/no)?
输入yes回车即可。

Git会输出一个警告，告诉你已经把GitHub的Key添加到本机的一个信任列表里了：

<Warning: Permanently added 'github.com' (RSA) to the list of known hosts.>

###创建SSHKey
1、在主目录下，看有没有.ssh目录，如果有，再看看这个目录下有没有<id_rsa>和<id_rsa.pub>这两个文件，
如果已经有了，可直接跳到下一步。如果没有，打开Shell（Windows下打开Git Bash），创建SSH Key
<id_rsa>是私钥，不能泄露出去，<id_rsa.pub>是公钥，可以放心地告诉任何人。
$ ssh-keygen -t rsa -C "youremail@example.com"
第2步：登陆GitHub，打开“Account settings”，“SSH Keys”页面：

然后，点[“Add SSH Key”]，填上任意Title，在Key文本框里粘贴id_rsa.pub文件的内容：
点“Add Key”，你就应该看到已经添加的Key：

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
