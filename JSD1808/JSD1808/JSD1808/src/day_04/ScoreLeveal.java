package day_04;

import java.util.Scanner;

public class ScoreLeveal {

	public static void main(String[] args) {
		Scanner scoreScanner = new Scanner(System.in);
		System.out.println("请输入用户的成绩：");
		double score = scoreScanner.nextDouble();
		System.out.println("您输入的用户成绩为："+score);
		/*
		if(score<0 || score>100) {
			System.out.println("成绩不合法");
		}else if(score>=90) {
			System.out.println("A-优秀");
		}else if(score>=80) {
			System.out.println("B-良好");
		}else if(score>=60) {
			System.out.println("C-中等");
		}else {
			System.out.println("D-不及格");	
		}
		*/
		
		if(score>=0 && score<=100) {
			if(score>=90){
				System.out.println("A-优秀");
			}else if(score>=80) {
				System.out.println("B-良好");
			}else if(score>=60) {
				System.out.println("C-中等");
			}
				System.out.println("D-不及格");
			}else {
			System.out.println("成绩不合法");
		}
		scoreScanner.close();
		
	}

}
