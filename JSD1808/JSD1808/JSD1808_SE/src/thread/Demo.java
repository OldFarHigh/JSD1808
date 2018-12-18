package thread;

import java.util.Arrays;

/**
 * 從數組中刪除給定元素
 * @author OldFarHigh
 *
 */
public class Demo {
	public static void main(String[] args) {
		int[] allOut  = {1,2,3,4,5,6,7,8,9};
		
		int pw = 6;
		//將該pw從數組中刪除
		
		for (int i = 0; i < allOut.length; i++) {
			if(allOut[i]==pw) {
				allOut[i] =allOut[allOut.length-1];//將其與最後一個元素交換
				break;
			}
		}
		allOut = Arrays.copyOf(allOut, allOut.length-1);
		
		System.out.println(Arrays.toString(allOut));
	}
}
