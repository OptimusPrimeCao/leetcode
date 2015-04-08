package New;

import java.util.Arrays;

//. The differences are exactly 1, 2, 3. (|Cr-Cy|=3, |Cy-Cb|=1, |Cb-Cr|=2) 
public class MagicBox {
	public static int magicBox(int x, int y, int z, String str) {
		if(str == null || str.length()<=0)
			return 0;
		int rNum = 0;
		int yNum = 0;
		int bNum = 0;
		
		int dx = 0;
		int dy = 0;
		int dz = 0;
		
		int maxCount = 0;
		char cArr[] = str.toCharArray();
		
		int[] givenArr = new int[3];
		givenArr[0] = x;
		givenArr[1] = y;
		givenArr[2] = z;
		Arrays.sort(givenArr);
		
		int[] testArr = new int[3];
		
		for(int i=0;i<str.length();i++) {
			if(cArr[i] == 'R') {
				rNum ++;
				dx = Math.abs(rNum-yNum);
				dz = Math.abs(bNum-rNum);
			}else if(cArr[i] == 'Y') {
				yNum ++;
				dx = Math.abs(rNum-yNum);
				dy = Math.abs(yNum-bNum);
			}else if(cArr[i] == 'B') {
				bNum ++;
				dy = Math.abs(yNum-bNum);
				dz = Math.abs(bNum-rNum);
			}else {
				return -1;
			}
			
			testArr[0] = dx;
			testArr[1] = dy;
			testArr[2] = dz;
			Arrays.sort(testArr);
			
			if(testArr[0]==givenArr[0] && testArr[1]==givenArr[1] && testArr[2]==givenArr[2]) {
				maxCount = Math.max(maxCount, rNum+yNum+bNum);
				rNum = 0;
				yNum = 0;
				bNum = 0;
			}
			
		}
		
		maxCount = Math.max(maxCount, rNum+yNum+bNum);
		return maxCount;
	}
	
	public static void main(String[] args) {
		System.out.println(magicBox(0,0,0,"RBYRRBY"));
	}
}
