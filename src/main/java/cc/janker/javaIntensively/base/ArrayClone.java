package cc.janker.javaIntensively.base;

public class ArrayClone implements Cloneable{
	public int i;
	public ArrayClone(int i){
		this.i = i;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
