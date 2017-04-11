public class BalanceArray {
	static int  getBalancedIndex(int[] a){
		int left = 0;
		
		for(int i=0;i<a.length;i++){
			int right = 0;
			for(int j=i+1;j<a.length;j++){
				right +=a[j];
			}
			if(i>0){
			left+=a[i-1];
			}
			if(left==right){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {-7,1,5,2,-4,3,0};
		int balanced = getBalancedIndex(a);
		System.out.println(balanced);
	}

}
