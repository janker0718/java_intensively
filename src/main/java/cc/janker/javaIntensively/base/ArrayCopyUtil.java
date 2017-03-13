package cc.janker.javaIntensively.base;

import java.util.Arrays;

public class ArrayCopyUtil {
	public  static void arrayCopyBySystem(int[] oldArray,int[] newArray){
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
	}
	public static int[] arrayCopyByArrays(int[] oldArray){
		return Arrays.copyOf(oldArray, oldArray.length);
	}
	
	public static void main(String[] args) {
		int[] oldArray = {1,2,3,4,5};
		int[] newArray = new int[oldArray.length];
//		ArrayCopyUtil.arrayCopyBySystem(oldArray, newArray);
//		for (int i = 0; i < newArray.length; i++) {
//			System.out.println(newArray[i]);
//		}
//		newArray =  ArrayCopyUtil.arrayCopyBySystem2(oldArray);
//		for (int i = 0; i < newArray.length; i++) {
//			System.out.println(newArray[i]);
//		}
		//通过for循环的形式实现
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
		for (int i = 0; i < newArray.length; i++) {
			System.out.println(newArray[i]);
		}
	}
	
}
