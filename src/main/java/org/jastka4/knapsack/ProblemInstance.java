package org.jastka4.knapsack;

import java.util.List;

/**
 * Instance of the discrete knapsack problem containing list of items
 * that can be put into the bag and the capacity of the bag.
 */
public class ProblemInstance {
	// items of our problem
	private List<Item> items;
	// capacity of the bag
	private int capacity;

	/**
	 * Class constructor specifying items of our problem and capacity of the bag.
	 *
	 * @param items list of items
	 * @param capacity capacity of the bag
	 */
	public ProblemInstance(final List<Item> items, final int capacity) {
		this.items = items;
		this.capacity = capacity;
	}

	/**
	 * Returns list of items that can be put into the bag.
	 *
	 * @return list of items
	 * @see Item
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * Returns the maximum capacity of the bag.
	 *
	 * @return maximum capacity
	 */
	public int getCapacity() {
		return capacity;
	}
}
