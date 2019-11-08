//Name: Nicholas Drazso
//Date: April 23, 2019
//Program Description: Various implementations of divide and conquer algorithms

public class divideAndConquer {

	public static void main (String args[]) {

		int[] n = {16, 23, 12, 25, 40, 1, 6, 26, 36, 13, 87, 99};

		quickSort(n, 0, n.length - 1);
		printArray(n);
		
	}
	
	
	//This method recursively sums a set 
	public static int sum (int[] A, int lo, int hi) {

		//Compute middle index
		int mid = (lo + hi) / 2;

		//Recall sum on first and second half of array
		if (lo < hi) {
			return (sum(A, lo, mid) + sum (A, mid + 1, hi));
		}

		//Returns when lo and hi point to the same index
		return A[lo];
	}

	//This method is used for quickSort and it returns the partition value where quickSort must be called on either side of
	public static int partition (int A[], int lo, int hi) {

		//Randomly chooses index within array as pivot
		int pivotIndex = (int)(Math.random() * (hi - lo + 1)) + lo;
	
		//Swaps A[pivot] with the element at the end of the array
		int temp = A[pivotIndex];
		A[pivotIndex] = A[hi];
		A[hi] = temp;
		
		//Sets pivot value to end of the array
		int pivot = A[hi];
		
		//Location of smallest index 
		int i = lo - 1;
		
		//Loops through array excluding final index
		for (int j = lo; j < hi; j++) {
			
			//If the element is smaller than the pivot, swap with next smallest location within array, marked by 'i' counter
			if (A[j] <= pivot) {
				
				i++;
				
				int temp1 = A[i];
				A[i] = A[j];
				A[j] = temp1;
			}
		}
		
		//Swaps pivot into appropriate position within the array and returns its location 
		int temp2 = A[i + 1];
		A[i + 1] = A[hi];
		A[hi] = temp2;
		
		
		return i + 1;
		
	}

	//Recursive implementation of quickSort Algorithm
	public static void quickSort(int[] A, int lo, int hi) {

		//Calls partition and uses returned value as an index to recursively sort smaller portions 
		if (lo < hi) {
			int part = partition(A, lo, hi);
			quickSort(A, lo, part - 1);
			quickSort(A, part + 1, hi);
		}

	}
	
	//Prints contents of array
	public static void printArray (int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
