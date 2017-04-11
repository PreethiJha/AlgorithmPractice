
public class Palindrome {
	public static void main(String[] args) {
		String s = "abcba";
		boolean isPalindrom = isPalindrom(s);
		System.out.println(s+" is a Palindrome:::"+isPalindrom);
	}

	private static boolean isPalindrom(String s) {
		int n = s.length();
		boolean flag = false;
		int i=0,j=n-1; 
		while(i<=n/2 && j>=n/2){
			System.out.println(s.charAt(i)+"==="+s.charAt(j));
			if(s.charAt(i)==s.charAt(j)){
				flag = true;
			}else{
				flag=false;
			}
			i++;
			j--;
		}
	
		return flag;
	}

}
