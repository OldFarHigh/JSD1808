package day_04;

public class WhileDemo {

	public static void main(String[] args) {
	/*
	int num = 1;
	while(num<=9) {
		//System.out.println("行动是成功的阶梯");
		System.out.println(num+"*9="+(num*9));//9的乘法表正序
		//System.out.println(num+"*9="+(num*9));
		num++;
	}
	*/
	/*倒叙输出9的乘法表
	int num = 9;
	while(num>=1) {
		System.out.println(num+"*9="+(num*9));
		num--;
	}
	*/
	
	int num = 1;
	while(num<=9) {
		System.out.println(num+"*9="+(num*9));
		num +=2;
	}
	//true 输出 num=1；
	//true 输出 num=3；
	//true 输出 num=5；
	//true 输出 num=7；
	//true 输出 num=9；
	// false 结束
	System.out.println("over");
	}

}
