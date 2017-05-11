package cc.janker.javaIntensively.dataStructure.queue;

class PriorityQ {
	private int maxSize;
	private long[] queArray;
	private int nItems;

	public PriorityQ(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}

	public void insert(long item) {
		int j;
		if (nItems == 0) {
			queArray[nItems++] = item;
			//nItems = nItems + 1;
		} else {
			for (j = nItems - 1; j >= 0; j--) {
				if (item > queArray[j]) {
					queArray[j + 1] = queArray[j];
				} else {
					break;
				}
			}
			queArray[j + 1] = item;
			nItems++;
		}
	}

	public long remove() {
		//nItems = nItems - 1;
		return queArray[--nItems];
	}

	public long peekMin() {
		return queArray[nItems - 1];
	}

	// -------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (nItems == 0);
	}

	// -------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{
		return (nItems == maxSize);
	}
	// -------------------------------------------------------------
	// end class PriorityQ
	
}
public class PriorityQApp
{
public static void main(String[] args)
   {
   PriorityQ thePQ = new PriorityQ(5);
   thePQ.insert(30);
   thePQ.insert(50);
   thePQ.insert(10);
   thePQ.insert(40);
   thePQ.insert(20);

   while( !thePQ.isEmpty() )
      {
      long item = thePQ.remove();
      System.out.print(item + " ");  // 10, 20, 30, 40, 50
      }  // end while
   System.out.println("");
   }  // end main()
//-------------------------------------------------------------
}  // end class PriorityQApp
////////////////////////////////////////////////////////////////
