package ooday_04;

public class Test {
	public static void main(String[] args) {
		Person []  ps = new Person[3];
		
		ps[0] = new Student("骚太",15,"烟台",1996);
		ps[1] = new Teacher("骚太老师",15,"烟台",4000);
		ps[2] = new Doctor("骚太医生",15,"烟台","赤脚大夫");
		for (int i = 0; i < ps.length; i++) {
			//System.out.println(ps[i].name);
			ps[i].sayHi();
		}
		Student zs1 = new Student("zhangsan",15,"LF",1506183);
		Person zs2 =new Student("zhangsan",16,"JMS",1761583);
		zs1.sayHi();//调用Student类的方法
		zs2.sayHi();//调用Student类的方法
		
		/*
		Student[] ss = new Student [3];
		ss[0] = new Student("骚太",15,"烟台",1996);
		ss[1] =new Student("骚灰",16,"杞县",12); 
		ss[2]=new Student("骚胜",17,"新乡",11);
		for (int i = 0; i < ss.length; i++) {
			ss[i].sayHi();
		}
	
		
		Teacher[] ts = new Teacher[3];
		ts[0]=new Teacher("骚太老师",15,"烟台",4000);
		ts[1]=new Teacher("骚灰老师",16,"杞县",4500);
		ts[2]=new Teacher("骚胜老师",17,"新乡",5000);
		for (int i = 0; i < ts.length; i++) {
			ts[i].sayHi();
		}
		
		
		Doctor[] ds =new Doctor[3];
		ds[0] =new Doctor ("骚太",15,"烟台","赤脚大夫");
		ds[1] = new Doctor("骚灰",16,"杞县",”主治医生“);
		ds[2]=new Doctor("骚胜",17,"新乡",“部门主任”);
		for (int i = 0; i < ds.length; i++) {
			ds[i].sayHi();
		}
		*/
	}
		

}
