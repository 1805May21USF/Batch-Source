package revature_homwork1;

public class Q1 {
		static int[] defaultArray = {1,0,5,6,3,2,3,7,9,8,4};
		static int[] sort(int[] array) {
			array=array.clone();
			for(int i=0;i<(array.length);i++) {
				for(int j=1;j<(array.length);j++) {
					if (array[j-1] > array[j]) {
						int temp = array[j];
						array[j]=array[j-1];
						array[j-1]=temp;
					}
				}
			}
			return array;
		}
}
