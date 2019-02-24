package org.jastka4.knapsack;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 */
public class Item {
	private String name;
	private BigDecimal value;
	private int weight;

	/**
	 * Class constructor specifying name, value and weight of object to create.
	 *
	 * @param name
	 * @param value
	 * @param weight
	 */
	public Item(final String name, final BigDecimal value, final int weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}

	/**
	 * Returns a string representation of this item. This method
	 * is intended to be used only for debugging purposes.
	 * This method returns a string equal to the value of:
	 * <blockquote><pre>
	 * name + ' [value = ' + value.setScale(2, RoundingMode.HALF_UP) + ', weight = ' + weight + ']';
	 * </pre></blockquote>
	 *
	 * @return  a string representation of the item.
	 */
	@Override
	public String toString() {
		return new StringBuilder()
				.append(name)
				.append(" [value = ").append(value.setScale(2, RoundingMode.HALF_UP))
				.append(", weight = ").append(weight).append("]")
				.toString();
	}

	/**
	 * Returns item's value for weight ratio.
	 *
	 * @return ratio
	 */
	public BigDecimal getRatio() {
		return value.divide(BigDecimal.valueOf(weight), 2, RoundingMode.HALF_UP);
	}

	/**
	 * Returns name of the item.
	 *
	 * @return item's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return value of the item.
	 *
	 * @return item's value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * Returns weight of the item.
	 *
	 * @return item's weight
	 */
	public int getWeight() {
		return weight;
	}
}
