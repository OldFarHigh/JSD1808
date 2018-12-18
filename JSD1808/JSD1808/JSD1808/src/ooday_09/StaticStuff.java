package ooday_09;


class StaticStuff{	

static	int x=10;
static	{x+=5;}
 public	static void	main(String args[])
 {
	 Person t = new Teacher();
	 if (t instanceof Teacher){	
                                  
	 }
 System.out.println("x=" + x);
 }
 static	{x/=3;}
}
class Person{}
class Student extends Person{}
class Teacher extends Person{}