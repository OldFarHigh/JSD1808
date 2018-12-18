package day_06;

public class Test_Demo {
	public static void main(String args[]) {
	/*
	public static int a(String id) {
		return 0;
	}
	public static void main(String[] args) {
		 int c=a("1002");
		 System.out.println(c);
		//String c=a("1002");
	}
	*/
	/*
	public static void main(String[] args) {
	int result=0;
	  for (int i=0; i <= 10; i++) {
	   if (i > 5){
	    break;
	   }
	      result+=i;
	  }
	  System.out.println(result);
	 }
	 */

		/*
		   int width = 50;

		   int height;

		   int result;

		   if (width > 40) {

		    right = 9;

		   }

		   result = width + height;

		   System.out.println(result);
		   */
		/*
			double opr = 0;
			int compare =opr > 0 ? 1 : (opr < 0 ? -1 : 0);
			System.out.println("f(" + opr + ")=" + 
			       compare);
		*/
		/*
		   int a=10;
		    int b=20;
		              
		    boolean flag=a++>b--&&b++>a--;  
		    System.out.println(flag+",a="+a+",b="+b);
		    
		    a=10;
		    b=20;
		    boolean flag1=a++>b--&b++>a--;  
		    System.out.println(flag+",a="+a+",b="+b);
		    
		 */
		//testType();
	
	/*
	public static void  testType() {
		  if (isType(1)) {
		   System.out.println("Type");
		  } else {
		   System.out.println("Not type");
		  }
		 }
	public static boolean isType(int type) {
		  if (type == 1) {
		   return false;
		  }
		  return true;
		 }
	*/
		/*
	    int words = 27;
	    do {
	       words--;
	     } while (words <= 18);
	    System.out.println(words);
	  }
	  */
		/*
		  int pigs = 5;
		  boolean isOne = true;
		  boolean isTwo = false;
		  if ((pigs == 4) && !isTwo)
		   System.out.print("first");
		  
		  System.out.print("second ");
		  if ((isTwo = true) && isOne) {
		   System.out.print("third");
		  }
	*/
		int i = 24, j = 32, h = 58;
		  switch (j - i) {
		  case 7:
		   h++;
		  case 8:
		   h++;
		  case 9:
		   h += 2;
		  case 10:
		   h += 3;
		  default:
		   h /= j;
		  }
		  System.out.println(h);

		 }
		}
 


