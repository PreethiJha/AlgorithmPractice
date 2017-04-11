
public class ContinousSum {
	static boolean isContinousSumExists(int[] arr,int sum){
		boolean flag = false;
		
		for(int i=0;i<arr.length;i++){
			int checkSum = 0;
			int start = i;
			//System.out.println("==================i============"+i);
			while(start<arr.length && checkSum+arr[start]<=sum){
				checkSum+=arr[start];
				start++;
			}
			//System.out.println("start......"+start+"......sum....."+checkSum);
			if(checkSum==sum){
				flag=true;
				break;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		int[] arr = {-10,0,2,-2,-20,10};
		int sum = 20;
		boolean flag = isContinousSumExists(arr, sum);
		System.out.println("The continous sum in the array exists="+flag);
	}
}
