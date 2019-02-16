package org.jastka4.knapsack;

import java.math.BigDecimal;
import java.util.*;

/**
 * {@inheritDoc}
 *
 * Dynamic programming implementation of the discrete knapsack problem.
 */
public class DynamicProgramming implements Knapsack {
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
	public DynamicProgramming(final List<Item> items, final int capacity) {
		this.items = items;
		this.capacity = capacity;
	}

	/**
	 * Returns a string representation of this solution. This method
	 * is intended to be used only for debugging purposes.
	 * This method returns a string equal to the value of:
	 * <blockquote><pre>
	 * 'DynamicProgramming problem'
	 * 'Capacity : ' + capacity
	 * 'Items :'
	 * for (Item item : items) {
	 *     '- ' + item;
	 * }
	 * </pre></blockquote>
	 *
	 * @return  a string representation of the item.
	 * @see Item
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder()
			.append("DynamicProgramming problem")
			.append("\nCapacity : ").append(capacity)
			.append("\nItems :");

		for (Item item : items) {
			stringBuilder.append("\n- ").append(item);
		}

		return stringBuilder.toString();
	}

	// we write the solve algorithm
	@Override
	public Solution solve() {
		int size = items.size();
		// we use a matrix to store the max value at each n-th item
		BigDecimal[][] matrix = new BigDecimal[size + 1][capacity + 1];

		// first line is initialized to 0
		Arrays.fill(matrix[0], BigDecimal.ZERO);

		// we iterate on items
		for (int i = 1; i <= size; i++) {
			// we iterate on each capacity
			for (int j = 0; j <= capacity; j++) {
				if (items.get(i - 1).getWeight() > j) {
					matrix[i][j] = matrix[i-1][j];
				} else {
					// we maximize value at this rank in the matrix
					matrix[i][j] = (matrix[i-1][j])
							.max((matrix[i-1][j - items.get(i-1).getWeight()]).add(items.get(i-1).getValue()));
				}
			}
		}

		BigDecimal res = matrix[size][capacity];
		int w = capacity;
		List<Item> itemsSolution = new ArrayList<>();

		for (int i = size; i > 0  &&  res.compareTo(BigDecimal.ZERO) > 0; i--) {
			if (res.compareTo(matrix[i-1][w]) != 0) {
				itemsSolution.add(items.get(i-1));
				// we remove items value and weight
				res = res.subtract(items.get(i-1).getValue());
				w -= items.get(i-1).getWeight();
			}
		}

		return new Solution(itemsSolution, matrix[size][capacity]);
	}

	@Override
	public String getDescription() {
		return "";
	}

	public static void main(String[] args) {
		// we take the same instance of the problem displayed in the image
		List<Item> items = Arrays.asList(
				new Item("Elt1", BigDecimal.valueOf(4), 12),
				new Item("Elt2", BigDecimal.valueOf(2.15), 1),
				new Item("Elt3", BigDecimal.valueOf(2), 2),
				new Item("Elt4", BigDecimal.valueOf(1), 1),
				new Item("Elt5", BigDecimal.valueOf(10), 4));

		DynamicProgramming dynamicProgramming = new DynamicProgramming(items, 15);
		System.out.println(dynamicProgramming);
		Solution solution = dynamicProgramming.solve();
		System.out.println(solution);
	}
}
