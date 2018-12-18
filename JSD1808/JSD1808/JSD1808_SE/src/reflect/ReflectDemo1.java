package reflect;
/**
 * java 的反射机制，
 * 反射允许我们在实例化一个类，操作其属性和方法从编码器决定转为在运行期决定。
 * 这样做可以提高代码的灵活度。适度使用，过度使用会降低代码的运行效率，增加资源开销。
 * @author OldFarHigh
 *
 * Class类
 * Class类的那个实例用于表示JVM加载的一个类。
 * 并且在JVM内部每个被加载的类有且只有一个Class的实例与之对应。
 * 
 * 获取一个类的类对象有以下几种方式：
 * 1：直接调用该类的静态属性class
 * 例如：
 * Class cls = String.class;
 * 但是这样做是在编码期间确定获取某个类的类对象，相对不灵活。
 * 2：调用Class的静态方法forName
 * 例如:
 * Class cls = Class.forName("java.lang.String");
 * 
 * 3:通过类加载器ClassLoader
 */
public class ReflectDemo1 {
	public static void main(String[] args) {
		/*
		 * 加载Preson类
		 * Class.forName中指定的参数为要加载的类的完全限定名：
		 * 即：
		 * 包名.类名
		 */
		try {
			/*
			 * 若指定的类完全限定名有误时，会抛出异常：
			 * ClassNotFoundException
			 */
			Class cls = Class.forName("reflect1.Person");//加载类
			String name =cls.getName();//获取类名
			System.out.println("类名："+name);//输出类名
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
