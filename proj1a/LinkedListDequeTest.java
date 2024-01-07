/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/** Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/** Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/** Prints a nice message based on whether a test passed.
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");


		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		int removedFirst= lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;
		//removedFirst should be 10
		passed=(10==removedFirst);
		printTestStatus(passed);

		System.out.println("Running get test");
		LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();
		lld2.addFirst(1);
		lld2.addFirst(0);
		lld2.addFirst(-1);
		lld2.addLast(2);
		lld2.addLast(3);
		lld2.addLast(4);
		passed = (lld2.get(0)==-1);
		printTestStatus(passed);
		passed = (lld2.getRecursive(3)==2);
		printTestStatus(passed);
		System.out.println("Running add/remove 2 test");
		passed = (lld2.removeLast()==4);
		printTestStatus(passed);
		passed = (lld2.removeFirst()==-1);
		printTestStatus(passed);
		System.out.println("Running auto-grader's test");
		LinkedListDeque<Integer> lld3 = new LinkedListDeque<Integer>();
		lld3.addLast(0);
		lld3.removeLast();
		lld3.addFirst(2);
		lld3.addFirst(1);
		lld3.addLast(3);
		passed = (lld3.removeFirst()==1);
		printTestStatus(passed);
		boolean passed2 = (lld3.get(1)==3);
		printTestStatus(passed);
		passed=(lld3.removeLast()==3);
		printTestStatus(passed);
		lld3.addLast(4);
		lld3.addFirst(1);

	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
} 