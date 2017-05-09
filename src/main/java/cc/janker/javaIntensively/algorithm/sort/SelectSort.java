package cc.janker.javaIntensively.algorithm.sort;

/**
 * 选择排序
 * 
 * @author janker0718(www.janker.cc)
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] a = { 1, 233, 23, 21, 34 };
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	private static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int n = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < min) {
					min = a[j];
					n = j;
				}

			}
			a[n] = a[i];
			a[i] = min;
		}
	}

	private static void sort2(int[] a) {
		for (int i = 0; i < a.length; i++) {
			// 设置当前选中的值为最小值
			int min = a[i];
			int n = i; // 最小数的索引
			for (int j = i + 1; j < a.length; j++) {
				// 从第二个开始找出最小数
				if (a[j] < min) {
					// 设置最小值
					min = a[j];
					// 最小值的索引
					n = j;
				}
			}
			// a[i]与min交换位置
			a[n] = a[i];
			a[i] = min;
		}
	}

}
