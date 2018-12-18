package cn.tedu.spring;

public class HuaWeiPhone {

	//使得当前类不存在无参数的构造方法
	public HuaWeiPhone(Object obj) {
		super();
	}
	//静态工厂方法
	public static HuaWeiPhone  create() {
		return new HuaWeiPhone(null);
	}
}
