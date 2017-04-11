import java.util.HashSet;

public class ArraysProblems {
	public static boolean findDuplicateWithinKIndecies(int[] a, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		int start = 0;
		int cnt = 0;
		int end = 0;

		for (int j = start; j < k; j++) {
			if (!set.contains(a[j])) {
				set.add(a[j]);
			} else {
				return true;
			}
		}
		end = start+k;
		while (end < a.length) {
			set.remove(a[start]);
			if (!set.contains(a[end])) {
				set.add(a[end]);
			} else {
				return true;
			}
			start++;
			end++;
		}

		return false;
	}

	public static void main(String[] args) {
		//int[] a = { 1, 2, 3, 5, 1, 2, 4, 5, 6 };
		int[] a = {1,2,3,4,5,6,7,6};
		int k = 3;
		boolean flag = findDuplicateWithinKIndecies(a, k);
		System.out.println("Duplicate item within " + k + " indices " + flag);
	}
}
