package cc.janker.javaIntensively.algorithm.sort;

/**
 * 二分法排序
 * @author janker0718(www.janker.cc)
 *
 */
public class BinarySort {
	private static void sort(int[] a){
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			int left = 0;
			int right = i-1;
			int mid = 0;
			while (left <= right) {
				mid = (left+right)/2;
				if (temp < a[mid]) {
					right = mid - 1;
				}else{
					left = mid + 1;
				}
			}
			for (int j = i-1; j >= left; j--) {
				a[j+1] = a[j];
			}
			
			if (left != i) {
				a[left] = temp;
			}
		}
	}
	public static void main(String[] args) {
		int[] a ={1,233,23,21,34};
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
