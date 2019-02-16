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
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * @return
	 */
	public int getWeight() {
		return weight;
	}
}
