import java.util.HashSet;


public class LongestUniqueSubstring {
	
	static String logestUniqueSubstting(String str){
		
		if(str==null || str.length()==0){
			return null;
		}
		
		int start =0;
		int max = 0;
		//int i =0;
		for(int i=0;i<str.length();i++){
			HashSet<Character> set  = new HashSet<Character>();
			for(int j=i;j<str.length();j++){
				if(!set.contains(str.charAt(j))){
					set.add(str.charAt(j));
				}else{
					//max = Math.max(max, set.size());
					if(set.size()>max){
						start=i;
					}
					max = Math.max(max, set.size());
					break;
				}
			}
			
		}
	
		
		return str.substring(start, max+1);
	}

	public static void main(String[] args) {
		String str = "abcdagafh12";
		String subsString = logestUniqueSubstting(str);
		System.out.println("Longest Unique Substring="+subsString);
	}
}
