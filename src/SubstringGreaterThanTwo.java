import java.util.List;
import java.util.ArrayList;

import javax.print.attribute.standard.Finishings;

public class SubstringGreaterThanTwo {
	private static List<String> findSubstring(String str) {
		List<String> result = new ArrayList<String>();
		int n = str.length();
		for(int i=1;i<=Math.pow(2, n);i++){
			int k=1;
			StringBuilder s = new StringBuilder();
			for(int j=0;j<n;j++){
				//int x = k<<1;
				if((i&k)>=1){
					s.append(str.charAt(j));
				}
				k=k<<1;
			}
			if(s.toString().length()>=2){
				result.add(s.toString());
			}
			
		}
		return result;
	}
	public static void main(String[] args) {
		String str = "ABC";
		List<String> results = findSubstring(str);
		for(String s:results){
			System.out.println(s);
		}
	}
}
