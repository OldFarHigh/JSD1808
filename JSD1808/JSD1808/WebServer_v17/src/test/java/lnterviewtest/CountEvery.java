package lnterviewtest;
/**
 * ͳ��һ��Ӣ�Ĵ�Щ��ĸ��ɵ��ַ�����ÿ����ĸ������
 * @author OldFarHigh
 * 'A' 65-65 counter[0]++
 * 'B' 66-65 counter[0]++
 * 'C' 67-65 counter[0]++
 * 'D' 68-65 counter[0]++
 * 'E' 69-65 counter[0]++
 * 'F' 70-65 counter[0]++
 * ... ...
 */
public class CountEvery {
	public static void main(String[] args) {
		String str = "ASDJIKHLKHLKHFLKHLKSHLIGFHSLIHFOYHLIKGHIKSHGKH";
		int[] counter = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			counter[c-'A']++;
		}
	}
	
}
