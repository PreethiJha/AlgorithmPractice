
public class SpiralRotation {
	
	static void roatateSpiral(int[][] a){
		int rStart = 0;
		int rEnd = a.length;
		int cStart = 0;
		int cEnd = a[0].length;
		while(rEnd>0 && cEnd>0){
			//left
			for(int j=cStart;j<cEnd;j++){
				System.out.print(a[rStart][j]+" ");
			}
			rStart++;
			//down
			for(int i=rStart;i<rEnd;i++){
				System.out.print(a[i][cEnd-1]+" ");
				
			}
			cEnd--;
			
			//right
			for(int j=cEnd-1;j>cStart;j--){
				System.out.print(a[rEnd-1][j]+" ");
				
			}
			rEnd--;
			//up
			for(int i=rEnd;i>=rStart;i--){
				System.out.print(a[i][cStart]+" ");
				
			}
			cStart++;
		}
	}
	
	static void printMatrix(int[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		//int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		roatateSpiral(a);
	}
}
