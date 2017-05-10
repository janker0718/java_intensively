package cc.janker.javaIntensively.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackXXX
{
private int maxSize;        // size of stack array
private char[] stackArray;
private int top;            // top of stack
//--------------------------------------------------------------
public StackXXX(int s)         // constructor
   {
   maxSize = s;             // set array size
   stackArray = new char[maxSize];  // create array
   top = -1;                // no items yet
   }
//--------------------------------------------------------------
public void push(char j)    // put item on top of stack
   {
   stackArray[++top] = j;     // increment top, insert item
   }
//--------------------------------------------------------------
public char pop()           // take item from top of stack
   {
   return stackArray[top--];  // access item, decrement top
   }
//--------------------------------------------------------------
public char peek()          // peek at top of stack
   {
   return stackArray[top];
   }
//--------------------------------------------------------------
public boolean isEmpty()    // true if stack is empty
   {
   return (top == -1);
   }
//--------------------------------------------------------------
public boolean isFull()     // true if stack is full
   {
   return (top == maxSize-1);
   }
//--------------------------------------------------------------
}  // end class StackX
public class Reverser {
	private String input;
	private String output;
	
	public Reverser(String in){
		input = in;
	}
	public String doRev(){
		int stackSize = input.length();
		StackXXX stackX = new StackXXX(stackSize);
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			stackX.push(ch);
		}
		output ="";
		while (!stackX.isEmpty()) {
			char ch = stackX.pop();
			output = output + ch;
		}
		return output;
	}
	public static void main(String[] args) throws IOException {
		String input,output;
		while (true) {
			System.out.print("Enter a String:");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				break;
			}
			Reverser reverser = new Reverser(input);
			output = reverser.doRev();
			System.out.println("Reversed:"+output);
		}
	}
	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
