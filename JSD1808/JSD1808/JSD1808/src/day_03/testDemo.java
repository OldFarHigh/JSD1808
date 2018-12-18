package day_03;
import java.util.Scanner;
public class testDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你的工资为：");
		double salary = scanner.nextDouble();
		if(salary > 1500) {
			System.out.println("恭喜你，你要为国家建设作贡献了！");
		}
		double tax = 0;
		double taxIncome = salary-3500;
		if(taxIncome<=1500) {
			tax = taxIncome*0.03;
		}
		if(taxIncome>1500 && taxIncome<=4500) {
			tax = taxIncome*0.1;
		}
		if(taxIncome>4500 && taxIncome<=9000) {
			tax = taxIncome*0.2;
		}
		System.out.println("您要交的个人所得税为："+tax);	
		scanner.close();
	}
}
