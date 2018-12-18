package exception;
/**
 * 测试异常的抛出
 * @author OldFarHigh
 *
 */
public class Demo5_Person {
	private int age;
	public  int getAge() {
		return age;
	}
	/**
	 * 当一个方法中使用throw抛出某个异常时，就要在方法声明时使用throws声明该异常的抛出，
	 * 以通知调用者必须处理该异常。
	 * 只有方法抛出RuntimeException及其子类型异常时可以不用throws。
	 * @param age
	 * @throws Exception
	 */
	public void setAge(int age) throws IllegalAgeException {
		if(age<0 || age>100) {
			/*
			 * 通过throw关键字可以将一个异常的实例抛出到方法之外，
			 * 由调用当前方法的代码片段来解决这个异常
			 */
			throw  new IllegalAgeException("年龄不合法!");
		}
		this.age = age;
	}
}
