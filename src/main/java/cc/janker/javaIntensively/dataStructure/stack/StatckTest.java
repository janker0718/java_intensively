package cc.janker.javaIntensively.dataStructure.stack;

class StackXX {
	private int maxSize;
	private long[] statckArray;
	private int top;

	public StackXX(int s) {
		maxSize = s;
		statckArray = new long[maxSize];
		top = -1;
	}

	public void push(long j) {
		top = top + 1;
		statckArray[top] = j;
	}

	public long pop() {
		top = top - 1;
		return statckArray[top+1];
	}

	public long peek() {
		return statckArray[top];
	}

	// --------------------------------------------------------------
	public boolean isEmpty() // true if stack is empty
	{
		return (top == -1);
	}

	// --------------------------------------------------------------
	public boolean isFull() // true if stack is full
	{
		return (top == maxSize - 1);
	}
}

public class StatckTest {
	public static void main(String[] args) {
		StackXX stack  = new StackXX(10);
		stack.push(80);
		stack.push(50);
		stack.push(30);
		stack.push(10);
		while (!stack.isEmpty()) {
			long value = stack.pop();
		      System.out.print(value);      // display it
		      System.out.print(" ");
		}
	}
	
}
