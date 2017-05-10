package cc.janker.javaIntensively.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackX1 {
	private int maxSize; // size of stack array
	private char[] stackArray;
	private int top; // top of stack
	// --------------------------------------------------------------

	public StackX1(int s) // constructor
	{
		maxSize = s; // set array size
		stackArray = new char[maxSize]; // create array
		top = -1; // no items yet
	}

	// --------------------------------------------------------------
	public void push(char j) // put item on top of stack
	{
		stackArray[++top] = j; // increment top, insert item
	}

	// --------------------------------------------------------------
	public char pop() // take item from top of stack
	{
		return stackArray[top--]; // access item, decrement top
	}

	// --------------------------------------------------------------
	public char peek() // peek at top of stack
	{
		return stackArray[top];
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
	// --------------------------------------------------------------
} // end class StackX
class BracketChecker{
	private String input;
	public BracketChecker(String in) {
		input = in;
	}
	public void check(){
		int stackSize = input.length();
		StackX1 stackX = new StackX1(stackSize);
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '{':
				
			case '[':
				
			case '(':
				stackX.push(ch);
				break;
			case '}':
			case ']':
			case ')':
				if (!stackX.isEmpty()) {
					char chx = stackX.pop();
					if ((ch =='}' && chx!='{')||(ch ==']' && chx!='[')
							||(ch ==')' && chx!='(')) {
						System.out.println("Error:"+ch+" at"+i);
					}
				}else{
					System.out.println("Error:"+ch+ "at"+i);
				}
				break;
			default:
				break;
			}
		}
		if (!stackX.isEmpty()) {
			System.out.println("error:missing right delimiter");
		}
	}
}
public class BracketsApp {
	public static void main(String[] args) throws IOException {
		String input;
		while (true) {
			System.out.print("Enter stirng containing delimiters:");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				break;
			}
			BracketChecker bracketChecker = new BracketChecker(input);
			bracketChecker.check();
		}
	}
	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
