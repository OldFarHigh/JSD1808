package ooday_04;

public class Person {
			String name;
			int age ;
			String address;
			Person(String name, int age, String address) {
				super();
				this.name = name;
				this.age = age;
				this.address = address;
				
			}
		
			void  sayHi() {
				System.out.println("您的名字是:"+name+",年龄是:"+age+",家庭住址是:"+address);
			}
			
			
}
