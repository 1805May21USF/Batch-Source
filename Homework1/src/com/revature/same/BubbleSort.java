package com.revature.same;

/*
 * Sorts an array using Bubble sort
 */
public class BubbleSort {

	/*
	 * Constructor for the BubbleSort Class
	 * Calls the bubblesort and print methods
	 */
	public BubbleSort() {
		// TODO Auto-generated constructor stub
		int bubble[] = {1,0,5,6,3,2,3,7,9,8,4};
		bubblesort(bubble);
		System.out.print("Bubble Sort: ");
		print(bubble);
	}

	/*
	 * Performs bubble sort on an integer array
	 * @Param bubble the integer array to be sorted
	 * @return A bubble sorted integer array
	 */
	public static int[] bubblesort(int bubble[]) {
		for(int i = 0; i < bubble.length; i++) {
			for(int j = 0; j < bubble.length-i-1; j++) {
				int first = bubble[j]; int second = bubble[j+1];
				if(first > second) {
					int temp = first;
                    bubble[j] = second;
                    bubble[j+1] = temp;
				}
			}
		}
		return bubble;
	}
	
	/*
	 * Prints the contents of an array
	 * @Param bubble the integer array to be printed to console
	 * @return null
	 */
	public static void print(int bubble[])
    {
        for(int i=0; i<bubble.length; i++) {
            System.out.print(bubble[i] + " ");
        }
        System.out.println();
    }
}
