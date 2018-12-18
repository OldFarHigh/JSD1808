package cn.tedu.spring;
//该类中的属性均通过Spring表示来获取值
public class ValueBean {
	
	//值：UserDao类中的username
	public String name;
	//值：sampleBean类中的passwrod
	public String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//----------------------------------------------------------
	//---以下是SET/GET方法----
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
