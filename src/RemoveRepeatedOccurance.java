public class RemoveRepeatedOccurance {
	
	 int removeRepeated(int[] a){
		int start=0;
		int n=a.length;
		int i=0;
		while(i<n-1){
			if(a[i]==a[i+1]){
				i++;
			}else{
				start++;
				swap(a,start,i+1);
				i+=2;
			}
		}
		return start;
	}
	 
	 void swap(int[] a,int i,int j){
		 int t = a[i];
		 a[i]=a[j];
		 a[j]=t;
	 }
	
	public static void main(String[] args) {
		int[] a ={1,1,1,2,2,2,2,3,3,3,3,4,4};
		RemoveRepeatedOccurance r = new RemoveRepeatedOccurance();
		int newLenght = r.removeRepeated(a);
		System.out.println(newLenght);
		for(int i=0;i<newLenght+1;i++){
			System.out.print(a[i]+" ");
		}
	}
}
