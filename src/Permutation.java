import java.util.List;
import java.util.*;


public class Permutation {
	List<String> permute(String str){
		char[] seq = str.toCharArray();
		List<String> permutedList = new ArrayList<String>();
		if(str.length()==1){
			permutedList.add(str);
		}
		else {
			for(int i=0;i<seq.length;i++){
				char firstChar = seq[i];
				StringBuilder s = new StringBuilder();
				s.append(firstChar);
				StringBuilder rest = new StringBuilder();
				if(i>0){
					rest.append(str.substring(0,i));
				}
				if(i!=seq.length-1){
					rest.append(str.substring(i+1,seq.length));
				}
				for(String permuted : permute(rest.toString())) {
					permutedList.add(s.toString()+permuted);
				}
			}
		}
		return permutedList;
	}
	
	public static void main(String[] args) {
		String str = "abc";
		Permutation p = new Permutation();
		List<String> result = p.permute(str);
		for(String s : result){
			System.out.println(s);
		}
	}
}
