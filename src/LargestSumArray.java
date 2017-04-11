
public class LargestSumArray {
	private static int findLargestSum(int[] arr){
		int sum=0;
		int tSum=0;
		for(int i=0;i<arr.length;i++){
			if(tSum+arr[i]>0){
				tSum+=arr[i];
			}else{
				tSum=0;
			}
			if(tSum>sum){
				sum = tSum;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] arr={-1,-3,4,-1,-2,1,5,-3};
		int sum = findLargestSum(arr);
		System.out.println("The largest sum ="+sum);
	}
}
