package cc.janker.javaIntensively.algorithm.find;

/**
 * 二分查找 -面向的有序数组
 * @author zhiyongliu3
 *
 */
public class BinaryFind {
	public static int find(int[] array,int key){
		int lower = 0;
		int upper = array.length-1;
		int curIn;
		while (true) {
			curIn = (lower + upper)/2;
			
			if (array[curIn] == key) {
				return curIn;
			}else if (lower > upper) {
				return - array.length;
			}else{ 
				if(array[curIn] < key){
				lower = curIn + 1;
			}else{
				upper = curIn -1;
			}
			}
		}
	}
	public static void main(String[] args) {
		int[] arr  = new int[]{1,3,34,35,37,344};
		System.out.println(find(arr,3));
	}
}
