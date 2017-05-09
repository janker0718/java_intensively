package cc.janker.javaIntensively.algorithm.sort;

/**
 * 
 * @author janker0718(www.janker.cc)
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] a ={1,233,23,21,34};
		//sort(a);
		sort2(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	private static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if (a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	private static void sort2(int[] a){
		for (int i = a.length-1; i >1; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
}
