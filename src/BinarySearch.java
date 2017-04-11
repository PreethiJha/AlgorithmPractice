import java.awt.Point;

public class BinarySearch {
	static int getTheFirstOccuranceOfOne(int[] number, int low, int high) {
		int mid = (low + high) / 2;
		/*
		 * if((low==high) && (number[low]==1)){ return low; }
		 */
		if (number[low] == 1) {
			return low;
		}
		if ((mid) > 0 && number[mid] == 1 && mid - 1 > 0
				&& number[mid - 1] == 0) {
			return mid;
		}

		if (mid < number.length - 1 && number[mid] == 0 && number[mid + 1] == 1) {
			return mid + 1;
		}

		if (mid < number.length - 1 && number[mid] == 0 && number[mid + 1] == 0) {
			return getTheFirstOccuranceOfOne(number, mid + 1, high);
		}

		if (mid > 0 && number[mid] == 1 && mid - 1 > 0 && number[mid - 1] == 1) {
			return getTheFirstOccuranceOfOne(number, low, mid);
		}
		return -1;
	}

	static int findMissingNumbers(int[] num, int low, int high) {
		int mid = (low + high) / 2;
		if (mid >= 0 && mid <= high) {
			if (num[mid] - num[0] != mid) {
				if ((mid - low) == 1) {
					return num[mid] - 1;
				}
				return findMissingNumbers(num, low, mid);
			} else {
				if ((high - mid) == 1) {
					return num[mid] + 1;
				}
				
				return findMissingNumbers(num, mid, high);
			}
		} 
		return -1;
	}

	public static void main(String[] args) {
		 /*int[] binaryNumber = { 0, 0, 0, 1 };
		 int[] binaryNumber = { 0, 0, 1, 1 };
		 int high = binaryNumber.length - 1;
		 int low = 0;
		 int index = getTheFirstOccuranceOfOne(binaryNumber, low, high);
		 System.out.println("The first occurance of 1 is =" + index);
		 int[] a = { 0,1,2,3,5 };*/
		/**
		 * Consecutive numbers
		 */
		/*int[] a = { 1,2,3,5,6 };
		int missingNumber = findMissingNumbers(a, 0, a.length - 1);
		System.out.println("Missing number :::" + missingNumber);*/
		
		
	

	}

}
