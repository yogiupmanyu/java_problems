package hackerrank;

public class SubsequenceInArray {
	
	public static void findSubsequenceInString(String src,String trg) {
		char[] srcArr = src.toCharArray();
		char[] trgArr = trg.toCharArray();
		int i = 0;
		int j = 0;
		while( srcArr.length > i && trgArr.length > j) {
			if(srcArr[i] == trgArr[j]) {
				i++;
				j++;
			}else {
				i++;
			}
		}
		
		if(trgArr.length==j)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}
	
	public static void main(String[] args) {
		String s = "axdrc";
		String t = "agx";
		
		findSubsequenceInString(s, t);
	}
}
