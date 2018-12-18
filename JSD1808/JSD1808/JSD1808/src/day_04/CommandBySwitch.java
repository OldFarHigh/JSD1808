package day_04;

import java.util.Scanner;

public class CommandBySwitch {

	public static void main(String[] args) {
		Scanner commandScanner = new Scanner(System.in);
		System.out.println("请选择功能：1.显示全部记录 2.查询登陆记录 0.退出");
		String command = commandScanner.nextLine();
		System.out.println("您输入的命令为："+command);
		
		switch(command){
		case "1":
			System.out.println();
		case "2":
		}
		/*
		switch(command) {
		case 1:
			System.out.println("显示全部功能");
			break;
		case 2:
			System.out.println("查询登陆记录");
			break;
		case 0:
			System.out.println("再见！");
			break;
		default:
			System.out.println("请输入正确的命令");
			}
			*/
		commandScanner.close();
	}

}
