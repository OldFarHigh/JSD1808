package ooday_03;

//import java.util.Arrays;

//引用类型数组的演示
public class RefArrayDemo {

	public static void main(String[] args) {
		Student []  stu = new Student[3];
		stu[0]  = new Student("骚太",25,"桃村");
		stu[1] = new Student("骚灰",16,"杞县");
		stu[2] = new Student("嫖老师",26,"开封");
		System.out.println(stu[1].name);
		System.out.println(stu[0]);
		System.out.println(stu[0].age);
		stu[0].age = 28;
		System.out.println(stu[0].age);
		System.out.println(stu);
		
		Student[ ]  as = new Student [ ] {
				new Student("骚太",25,"桃村"),
				new Student("骚灰",146,"杞县"),
				new Student("嫖老师",100,"开封")
		} ;
		System.out.println(as[1].name);
		System.out.println(as[0]);
		System.out.println(as[0].age);
		as[0].age = 28;
		System.out.println(as[0].age);
		
		
		//数组的数组
		int [][] arr = new int [5] [] ;
		arr[0] = new int[4];
		arr[1] = new int [3];
		arr[2] = new int [5];
		arr[3] = new int [7];
		arr[4]  = new int [8];
		arr[1][0] = 100;
		System.out.println(arr[1][0]);
		int [][] ass = new int [3][4];
		for (int i = 0; i < ass.length; i++) {
			for (int j = 0; j < ass[i] .length; j++) {
				ass[i ][j] = (int)(Math.random()*100);
				System.out.print(ass[i][j]+"\t");
			}
			
		}
		//System.out.print("数组的数组为："+Arrays.toString(ass)+"\t");
		
		
	}

}
