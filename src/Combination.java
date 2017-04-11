import java.util.ArrayList;
import java.util.HashSet;


public class Combination {
	private static HashSet<ArrayList<Integer>> findCombination(int start, int end, int k){
		if(k==1){
			HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
			for(int i = start; i<= end; i++){
				ArrayList<Integer> set = new ArrayList<Integer>();
				set.add(i);
				result.add(set);
			}
			
			return result;
		}
		else{
			HashSet<ArrayList<Integer>> finalResult = new HashSet<ArrayList<Integer>>();
			for(int i=start; i<=end-k+1; i++){
				HashSet<ArrayList<Integer>> result = findCombination(i+1, end, k-1);
				for(ArrayList<Integer> set : result){
					set.add(0, i);
					finalResult.add(set);
				}
			}
			return finalResult;
		}
	}
	
	public static void main(String[] args) {
		HashSet<ArrayList<Integer>> result = findCombination(1, 4, 4);
		System.out.println("Printing...");
		for(ArrayList<Integer> set : result){
			System.out.print("[");
			for(Integer x : set){
				System.out.print(x);
				System.out.print(",");
			}
			System.out.print("], ");
		}
	}
}
