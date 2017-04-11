import java.awt.Point;

public class LongestCommonSubString {

	String logestCommonSubstring(String s1, String s2) {

		//int tStart = 0;
		int start = 0;
		//int tlen = 0;
		int len = 0;
		// int j = 0;
		for (int i = 0; i < s1.length(); i++) {
			//System.out.println("String 1 - Start :" + s1.charAt(i));
			//System.out.println("********************************");
			for (int j = 0; j < s2.length(); j++) {
				//System.out.println("String 2 - Start :" + s2.charAt(j));
				//System.out.println("-----------------------");
				if (s1.charAt(i) == s2.charAt(j)) {
					//System.out.println("Matched.. will start loop");
					int tStart = i;
					int t_i = i;
					int t_j = j;
					int tlen = 0;
					while (t_i < s1.length() && t_j < s2.length() 
							&& (s1.charAt(t_i) == s2.charAt(t_j))) {
						//System.out.println("BEFORE t_i : " + t_i + " t_j : " + t_j + " tlen: " + tlen);
						tlen++;
						t_i++;
						t_j++;
						//System.out.println("AFTER t_i : " + t_i + " t_j : " + t_j + " tlen: " + tlen);
					}

					if (tlen > len) {
						len = tlen;
						start = tStart;
					}
				}

			}

		}
		return s1.substring(start, len);
	}

	public static String largestCommonSubstringUsingMatrix(String s1,String s2){
		int[][] matrixCheck = new int[s1.length()][s2.length()];
		int max = 0;
		Point point = new Point();
		for(int row=0;row<s1.length();row++){
			for(int col=0;col<s2.length();col++){
				if(s1.charAt(row)==s2.charAt(col)){
					if(row==0 || col==0){
					matrixCheck[row][col]=1;
					}else{
						int preVal = matrixCheck[row-1][col-1];
						matrixCheck[row][col]=preVal+1;
						if(matrixCheck[row][col]>max){
							max = matrixCheck[row][col];
							point.x = row;
							point.y = col;
						}
					}
				}
			}
		}
		int i = point.x;
		int j = point.y;
		/*for(int row=0;row<s1.length();row++){
			for(int col=0;col<s2.length();col++){
				System.out.print(matrixCheck[row][col]+" ");
			}
			System.out.println();
		}
		System.out.println("Max="+max);*/
		while(i>=0 && j>=0 && matrixCheck[i][j]>=1){
			i--;
			j--;
		}
		
		//System.out.println("i===="+i+"=====j==="+j);
		return s1.substring(i+1, max);
	}
	
	public static void main(String[] args) {
		String s1 = "abczzxyz123bacd";
		String s2 = "xyzabczzxyz123656";
		LongestCommonSubString l = new LongestCommonSubString();
		String s = l.logestCommonSubstring(s1, s2);
		System.out.println("Longest Common Substring =" + s);
		String subString = l.largestCommonSubstringUsingMatrix(s1, s2);
		System.out.println("Longest Common Substring Using Matrix="+subString);
	}

}
