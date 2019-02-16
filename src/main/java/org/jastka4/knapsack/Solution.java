package org.jastka4.knapsack;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Solution of the discrete knapsack problem containing list of items
 * to put in the bag to have the maximal value and the maximal value possible.
 */
public class Solution {
	// list of items to put in the bag to have the maximal value
	private List<Item> items;
	// maximal value possible
	private BigDecimal value;

	/**
	 * Class constructor specifying items to put in the bag and the maximal value possible.
	 *
	 * @param items list of items to put in the bag to have the maximal value
	 * @param value maximal value possible
	 * @see Item
	 */
	public Solution(final List<Item> items, final BigDecimal value) {
		this.items = items;
		this.value = value;
	}

	/**
	 * Returns a string representation of this solution. This method
	 * is intended to be used only for debugging purposes.
	 * This method returns a string equal to the value of:
	 * <blockquote><pre>
	 * 'Value = " + value.setScale(2, RoundingMode.HALF_UP)
	 * 'Items to pick :'
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
				.append("Value = ").append(value.setScale(2, RoundingMode.HALF_UP))
				.append("\nItems to pick :");

		for (Item item : items) {
			stringBuilder.append("\n- ").append(item);
		}

		return stringBuilder.toString();
	}

	/**
	 * Returns list of items to put in the bag to have the maximal value.
	 *
	 * @return list of items
	 * @see Item
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * Returns the maximal value possible.
	 *
	 * @return the maximal value
	 */
	public BigDecimal getValue() {
		return value;
	}
}
