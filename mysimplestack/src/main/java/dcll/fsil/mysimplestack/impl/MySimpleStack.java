package dcll.fsil.mysimplestack.impl;

import java.util.ArrayList;

import dcll.fsil.mysimplestack.EmptyStackException;
import dcll.fsil.mysimplestack.Item;
import dcll.fsil.mysimplestack.SimpleStack;

public class MySimpleStack implements SimpleStack {
	
	private ArrayList<Item> theStack = new ArrayList<Item>(); 

	@Override
	public boolean isEmpty() {
		return theStack.isEmpty();
	}

	@Override
	public int getSize() {
		return theStack.size();
	}

	@Override
	public void push(Item item) {
		theStack.add(item);
	}

	@Override
	public Item peek() throws EmptyStackException {
		if (theStack.isEmpty()) {
			throw new EmptyStackException();
		}
		return theStack.get(theStack.size()-1);
	}

	@Override
	public Item pop() throws EmptyStackException {
		if (theStack.isEmpty()) {
			throw new EmptyStackException();
		}
		return theStack.remove(theStack.size()-1);
	}

}
