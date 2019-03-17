package org.jastka4.knapsack;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Item of the discrete knapsack problem containing name,
 * value and weight of the object.
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
