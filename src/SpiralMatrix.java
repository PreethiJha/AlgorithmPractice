import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {

	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int rStart = 0;
		int rEnd = matrix.length;
		int cStart = 0;
		int cEnd = matrix[0].length;
		while (rEnd > 0 && cEnd > 0) {

			// left
			for (int j = cStart; j < cEnd; j++) {
				System.out.print(matrix[rStart][j] + " ");
				result.add(matrix[rStart][j]);
			}
			rStart++;

			// down
			for (int i = rStart; i < rEnd; i++) {
				System.out.print(matrix[i][cEnd-1] + " ");
				result.add(matrix[i][cEnd-1]);
			}
			cEnd--;

			// right
			for (int j = cEnd-1; j >= cStart; j--) {
				System.out.print(matrix[rEnd-1][j] + " ");
				result.add(matrix[rEnd-1][j]);
			}
			rEnd--;

			// up
			for (int i = rEnd-1; i >= rStart; i--) {
				System.out.print(matrix[i][cStart] + " ");
				result.add(matrix[i][cStart]);
			}
			cStart++;
		}

		return result;
	}
	
	static int[][] constructSpiralMatrix(ArrayList<Integer> result,int n,int itemRem,int itemAdd){
		int[][] mat = new int[n][n];
		
		result.remove(itemRem);
			
		result.add(itemAdd);
		Collections.sort(result);
		constructMatrix(result,mat);
		return mat;
	}
	
	static void constructMatrix(ArrayList<Integer> result,int[][] matrix){
		int rStart = 0;
		int rEnd = matrix.length;
		int cStart = 0;
		int cEnd = matrix[0].length;
		int index = 0;
		while (rEnd > 0 && cEnd > 0) {

			// left
			for (int j = cStart; j < cEnd; j++) {
				//System.out.print(matrix[rStart][j] + " ");
				matrix[rStart][j] = result.get(index++);
				//result.add(matrix[rStart][j]);
			}
			rStart++;

			// down
			for (int i = rStart; i < rEnd; i++) {
				matrix[i][cEnd-1] = result.get(index++);
				//System.out.print(matrix[i][cEnd-1] + " ");
				//result.add(matrix[i][cEnd-1]);
			}
			cEnd--;

			// right
			for (int j = cEnd-1; j >= cStart; j--) {
				matrix[rEnd-1][j] = result.get(index++);
				//System.out.print(matrix[rEnd-1][j] + " ");
				//result.add(matrix[rEnd-1][j]);
			}
			rEnd--;

			// up
			for (int i = rEnd-1; i >= rStart; i--) {
				matrix[i][cStart] = result.get(index++);
				//System.out.print(matrix[i][cStart] + " ");
				//result.add(matrix[i][cStart]);
			}
			cStart++;
		}
	}
	
	static void printMatrix(int[][] mat){
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[i].length;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		ArrayList<Integer> result = spiralOrder(a);
		System.out.println("===============================================");
		for (Integer r : result) {
			System.out.print(r + " ");
		}
		System.out.println("==============================================");
		int[][] resultMat = constructSpiralMatrix(result,a.length,3,10);
		printMatrix(resultMat);
		
	}

}
