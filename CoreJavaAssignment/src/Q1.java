public class Q1 {
	/*
	 * Bubble sort method: Bubble sort will make multiple passes through an array.
	 * Neighboring pairs will be compared and swapped if arr[i] > arr[i+1]. The flag
	 * is used to catch if another pass through the array will be needed. If flag
	 * passes through the array and is true, then the array is sorted.
	 */
	public static void main(String[] args) {
		System.out.println("Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4");
		int[] arr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] arr2 = bubbleSort(arr);
		System.out.print("Result: ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]);
			if (i < arr2.length - 1) {
				System.out.print(", ");
			}
		}

	}

	static int[] bubbleSort(int[] arr) {
		//A flag is used to determine if another flag is needed 
		boolean flag = true;
		for (int k = 1; k < arr.length && flag; k++) {
			flag = false; // Array may be sorted and next pass not needed
			for (int i = 0; i < arr.length - k; i++) {
				if (arr[i] > arr[i + 1]) {
					// Swap list[i] with list[i + 1]
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					flag = true; // Next pass still needed
				}
			}
		}
		return arr;
	}
}
