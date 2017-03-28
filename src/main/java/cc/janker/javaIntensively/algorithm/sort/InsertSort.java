package cc.janker.javaIntensively.algorithm.sort;

/**
 * 插入排序
 * @author janker0718(www.janker.cc)
 *
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] a = {1,13,34,22,45};
		for (int i  = 1 ;i <a.length ; i++) {
			int temp = a[i];
			int j ;
			for(j = i-1; j>=0; j--){
				//将大于temp的往后移一位
				if (a[j]>temp) {
					a[j+1] = a[j];
				}else{
					break;
				}
			}
			a[j+1] = temp;
		}
		for (int i : a) {
			System.out.println(i);
		}
	}
}
