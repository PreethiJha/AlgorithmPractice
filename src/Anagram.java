import java.io.CharConversionException;

public class Anagram {
	static boolean isAnagram(String s1, String s2) {
		int[] chracArr = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			int ascii = (int) s1.charAt(i);
			//System.out.println("ascii="+ascii);
			chracArr[ascii] += 1;
		}
		for (int i = 0; i < s2.length(); i++) {
			int ascii = (int) s2.charAt(i);
			//System.out.println("ascii="+ascii);
			if(chracArr[ascii]>0){
			chracArr[ascii] -= 1;
			}
		}
		int cnt = 0;
		for (int i = 0; i < 256; i++) {
			//System.out.println(i+" i "+chracArr[i]);
			cnt += chracArr[i];
		}
		if (cnt == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "dcfa";
		boolean f = isAnagram(s1, s2);
		System.out.println("s1=" + s1 + " and s2=" + s2 + " isAnaagram=" + f);

	}
}
