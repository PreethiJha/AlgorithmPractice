import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MatrixProblems {

	static boolean searchInMatrix(int[][] mat, int num) {
		int rowLength = mat.length - 1;
		int colLength = mat[0].length - 1;
		int rStart = 0;
		int cStart = 0;
		// int rightElement = mat[rStart][colLength];
		while (rStart <= rowLength && colLength >= cStart) {
			if (num == mat[rStart][colLength]) {
				return true;
			}
			if (num > mat[rStart][colLength]) {
				rStart++;

			} else {
				colLength--;

			}
		}
		return false;

	}

	public static boolean findDuplicateWithinKIndecies(int[][] a, int k) {

		HashMap<Integer, HashSet<Point>> map = new HashMap<Integer, HashSet<Point>>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (map.containsKey(a[i][j])) {
					for (Point p : map.get(a[i][j])) {
						int manhDist = Math.abs((i - p.x) + (j - p.y));
						if (manhDist == k) {
							return true;
						}

						if (Math.abs(i - p.x) > k) {
							map.get(a[i][j]).remove(p);
						}
					}
					map.get(a[i][j]).add(new Point(i, j));
				} else {
					HashSet<Point> setP = new HashSet<Point>();
					Point p = new Point(i, j);
					setP.add(p);
					map.put(a[i][j], setP);
				}
			}
		}

		return false;
	}

	static int getBiggestIsland(int[][] mat) {
		int max = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					max = Math.max(countIsLands(mat, i, j), max);
				}
			}
		}
		return max;
	}

	static int countIsLands(int mat[][], int i, int j) {
		int rLen = mat.length;
		int cLen = mat[0].length;
		int sum = 1;
		mat[i][j] = 0;
		if (i < rLen - 1 && mat[i + 1][j] == 1) {
			// mat[i][j]=0;
			sum += countIsLands(mat, i + 1, j);
		}
		if (j < cLen - 1 && mat[i][j + 1] == 1) {
			// mat[i][j]=0;
			sum += countIsLands(mat, i, j + 1);
		}
		if (i > 0 && mat[i - 1][j] == 1) {
			// mat[i][j]=0;
			sum += countIsLands(mat, i - 1, j);
		}
		if (j > 0 && mat[i][j - 1] == 1) {
			// mat[i][j]=0;
			sum += countIsLands(mat, i, j - 1);
		}

		return sum;
	}

	static void makeZero(int[][] mat) {
		Set<Integer> xSet = new HashSet<Integer>();
		Set<Integer> ySet = new HashSet<Integer>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					if (xSet.size() == mat.length
							&& ySet.size() == mat[0].length) {
						break;
					}
					if (!xSet.contains(i)) {
						xSet.add(i);
					}
					if (!ySet.contains(j)) {
						ySet.add(j);
					}
					int col = 0;
					while (col < mat[0].length) {
						mat[i][col] = 0;
						col++;
					}
					int row = 0;
					while (row < mat.length) {
						mat[row][j] = 0;
						row++;
					}
				}
			}
		}
	}

	static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean findPath(int[][] mat, int i, int j) {
		if(mat[mat.length-1][mat[0].length-1]==1){
			return true;
		}
		
		if (i<mat.length-1 && j<mat[0].length-1 && mat[i][j] == 1) {
			return findPath(mat, i+1, j) || findPath(mat, i, j+1);
		}else{
			return false;
		}
		
	}

	public static void main(String[] args) {
		// int[][] mat = { { 1, 2, 3 }, { 4, 1, 6 }, { 7, 8, 9 } };
		/*
		 * int num = 20; boolean found = searchInMatrix(mat, num);
		 * System.out.println("Matrix found=" + found + " element " + num);
		 */
		/*
		 * int k = 2; boolean flag = findDuplicateWithinKIndecies(mat, k);
		 * System
		 * .out.println("Matrix contains no duplicates within "+k+" indices "
		 * +flag);
		 */
		int[][] mat = { { 1, 1, 0 }, { 1, 0, 0 }, { 1, 1, 0 } };
		// int length = getBiggestIsland(mat);
		// System.out.println("Length of the biggest island="+length);
		//printMatrix(mat);
		//System.out.println("====================================");
		//makeZero(mat);
		//printMatrix(mat);
		boolean isPath = findPath(mat, 0, 0);
		System.out.println("Path found="+isPath);

	}
}
