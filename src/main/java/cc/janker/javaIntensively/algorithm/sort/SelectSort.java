package cc.janker.javaIntensively.algorithm.sort;

/**
 * 选择排序
 * @author janker0718(www.janker.cc)
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] a ={1,233,23,21,34};
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	private static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int n =i;	//最小数的索引
			for (int j = i+1; j < a.length; j++) {
				//从第二个开始找出最小数
				if (a[j] < min) {
					min = a[j];
					n = j;
				}
			}
			a[n] = a[i];
			a[i] = min;
		}
	}
}
