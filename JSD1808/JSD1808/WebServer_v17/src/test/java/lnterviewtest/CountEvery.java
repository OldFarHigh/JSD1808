package lnterviewtest;
/**
 * 统计一个英文大些字母组成的字符串中每个字母的数量
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
