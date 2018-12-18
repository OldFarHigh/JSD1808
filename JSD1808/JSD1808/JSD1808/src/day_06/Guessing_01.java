package day_06;
import java.util.Scanner;
//猜字符小游戏
public class Guessing_01 {
	//主方法
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		scan.close();
		char[] chs = generate(); //调用generate方法,生成数组
		System.out.println(chs); //输出
		int count = 0; //表示玩家猜测的次数
		while(true){ //鑷�犳寰幆
			System.out.println("猜吧!");
			String str = scan.next().toUpperCase(); //将接下来输入的字符全部转换为大写字母
			if(str.equals("EXIT")){ //设置离开的权限EXIT
				System.out.println("下次再来吧!");
				break;
			}
			char[] input = str.toCharArray(); //对输入的数组，进行转化为转换为字符数组
			int[] result = check(chs,input); //瀵规瘮:闅忔満瀛楃鏁扮粍涓庣敤鎴疯緭鍏ョ殑瀛楃鏁扮粍
			if(result[0]==chs.length){ //鐚滃浜�
				int score = 100*chs.length-10*count; //1涓瓧绗�100鍒嗭紝鐚滈敊涓�娆℃墸10鍒�
				System.out.println("恭喜你猜对了，得分为:"+score);
				break; //缁堟寰幆
			}else{ //鐚滈敊浜�
				count++; //鐚滈敊娆℃暟澧�1
				System.out.println("字符对个数:"+result[1]+"，位置对个数:"+result[0]);
			}
		}
	}
	
	//生成随机字符数组
	public static char[] generate(){
		char[] chs = new char[5]; //定义新的数组
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' }; //对数组赋初值
		boolean[] flags = new boolean[letters.length]; //寮�鍏虫暟缁�(榛樿鍊间负false)
		for(int i=0;i<chs.length;i++){ //閬嶅巻闅忔満瀛楃鏁扮粍
			int index;
			do{
				index = (int)(Math.random()*letters.length); //闅忔満涓嬫爣(0鍒�25)
			}while(flags[index]==true); //褰撲笅鏍噄ndex瀵瑰簲鐨勫紑鍏充负true鏃讹紝琛ㄧず瀵瑰簲鐨勫瓧绗﹀凡瀛樿繃锛屽垯閲嶆柊鐢熸垚index
			                            //褰撲笅鏍噄ndex瀵瑰簲鐨勫紑鍏充负false鏃讹紝琛ㄧず瀵瑰簲鐨勫瓧绗︽湭瀛樿繃锛屽垯缁撴潫寰幆淇濆瓨瀛楃
			chs[i] = letters[index]; //鍩轰簬index涓嬫爣鑾峰彇瀵瑰簲鐨勫瓧绗﹀苟璧嬪�肩粰chs涓殑姣忎竴涓厓绱�
			flags[index] = true; //灏嗕笅鏍噄ndex瀵瑰簲鐨勫紑鍏充慨鏀逛负true锛岃〃绀哄搴斿瓧绗﹀凡瀛樿繃
		}
		return chs;
	}
	
	//对比:随机字符数组chs与用户输入的字符数组input
	public static int[] check(char[] chs,char[] input){
		int[] result = new int[2]; //瀵规瘮鐨勭粨鏋滐紝鍋囪result[1]涓哄瓧绗﹀锛宺esult[0]涓轰綅缃锛岄粯璁ゅ�奸兘鏄�0
		for(int i=0;i<chs.length;i++){ //閬嶅巻闅忔満瀛楃鏁扮粍
			for(int j=0;j<input.length;j++){ //閬嶅巻鐢ㄦ埛杈撳叆鐨勫瓧绗︽暟缁�
				if(chs[i]==input[j]){ //瀛楃瀵�
					result[1]++; //瀛楃瀵逛釜鏁板1
					if(i==j){ //浣嶇疆瀵�
						result[0]++; //浣嶇疆瀵逛釜鏁板1
					}
					break; //鍓╀綑input鍏冪礌涓嶅啀鍙備笌鏈疆姣旇緝浜�
				}
			}
		}
		return result;
	}

}
