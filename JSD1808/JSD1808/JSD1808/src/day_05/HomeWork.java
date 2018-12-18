package day_05;

import java.util.Scanner;

public class HomeWork {

	public static void main(String[] args) {
		//数列求和
		/*
		 long nine = 9;
	        long result = nine;
	        for (int i = 2; i <= 10; i++) {
	            nine = nine * 10 + 9;
	            result += nine;
	        }
	        System.out.println("9+99+999+...+9999999999=" + result);
		*/
		//数列求和
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.out.println("请输入整数（例如10）：");
        /*
        int n = scanner.nextInt();
        double result = 0;
        for (int i = 1; i < n; i++) {
            result += 1.0 / i;
            if(i==1){
                System.out.print("1+");
            }else{
                System.out.print("1/" + i + "+");    
            }
        }
        result += 1.0 / n;
        System.out.print("1/" + n + "=" + result);
		*/
	}
}

