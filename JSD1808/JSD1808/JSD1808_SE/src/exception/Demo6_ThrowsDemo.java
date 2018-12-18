package exception;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 子类再重写超类含有throws声明异常抛出的方法时的一些重写规则
 * @author OldFarHigh
 *
 */
public class Demo6_ThrowsDemo {
	//允许抛出异常
	public void dosome()throws IOException,AWTException{	
	}
}
class Son extends Demo6_ThrowsDemo{
	//允许不再抛出任何异常
//	public void dosome() {	
//	}
	//允许抛出部分异常
//	public void dosome()throws IOException{	
//	}
	//允许抛出父类方法抛出异常的子类型异常
	public void dosome()throws FileNotFoundException{
	}
	//不允许抛出额外异常
//	public void dosome()throws SQLException{	
//	}
	//不允许抛出父类抛出异常的父类型异常
//	public void dosome()throws Exception{
//	}
	
}
	
	

