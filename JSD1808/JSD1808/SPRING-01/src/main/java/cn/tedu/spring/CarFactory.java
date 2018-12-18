package cn.tedu.spring;

public class CarFactory {
	
	//用于生产对象的工厂方法
	public Car makeCar() {
		return new  Car(null);
	}
}
