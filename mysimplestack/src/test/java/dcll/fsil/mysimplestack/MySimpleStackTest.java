package dcll.fsil.mysimplestack;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import dcll.fsil.mysimplestack.impl.DummyItem;
import dcll.fsil.mysimplestack.impl.MySimpleStack;

/**
 * Unit test for simple task.
 */
public class MySimpleStackTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public MySimpleStackTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(MySimpleStackTest.class);
	}

	/**
	 * Creation
	 */
	public void testCreateStack() {
		// when created a new stack
		SimpleStack stack = new MySimpleStack();

		// then the stack is empty
		assertTrue("stack must be empty", stack.isEmpty());
		assertEquals("size must be 0", 0, stack.getSize());
	}

	public void testPushItem() {
		// given an empty stack and an item
		SimpleStack stack = new MySimpleStack();
		Item item = new DummyItem();

		// when the item is pushed in the stack
		stack.push(item);

		// then the stack has one element and is no more empty
		assertFalse("stack must not be empty", stack.isEmpty());
		assertEquals("size must be 1", 1, stack.getSize());
	}

	public void testPeekOnEmptyStack() {
		// given an empty stack
		SimpleStack stack = new MySimpleStack();

		// when a peek is performed
		try {
			stack.peek();
			fail("must throw exception");
		} catch (EmptyStackException e) {
			// then an EmptyStackException is thrown
		}
	}

	public void testPeekOnNonEmptyStack() throws EmptyStackException {
		// given a stack with one element
		SimpleStack stack = new MySimpleStack();
		Item item = new DummyItem();
		stack.push(item);

		// when a peek is performed
		Item item2 = stack.peek();
		
		// then the item returned is the item in the stack
		assertEquals("the item returned must the one added",item, item2);

		// and the stack has always one element
		assertEquals("size must be 1", 1, stack.getSize());
	}
	
	public void testPopOnEmptyStack() {
		// given an empty stack
		SimpleStack stack = new MySimpleStack();

		// when a peek is performed
		try {
			Item item = stack.pop();
			fail("must throw exception");
		} catch (EmptyStackException e) {
			// then an EmptyStackException is thrown
		}
	}

	public void testPopOnNonEmptyStack() throws EmptyStackException {
		// given a stack with one element
		SimpleStack stack = new MySimpleStack();
		Item item = new DummyItem();
		stack.push(item);

		// when a peek is performed
		Item item2 = stack.pop();
		
		// then the item returned is the item that was in the stack
		assertEquals("the item returned must the one added",item, item2);

		// and the stack is empty
		assertEquals("size must be 0", 0, stack.getSize());
		assertTrue("stack must be empty", stack.isEmpty());
	}

}
