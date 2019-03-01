package org.jastka4.knapsack;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * {@inheritDoc}
 *
 * Greedy algorithm implementation of the discrete knapsack problem.
 */
public class GreedyAlgorithm implements KnapsackAlgorithm {

	private ProblemInstance problemInstance;

	public GreedyAlgorithm(final ProblemInstance problemInstance) {
		this.problemInstance = problemInstance;
	}

	@Override
	public Solution solve() {
		List<Item> items = problemInstance.getItems();
		items.sort(Comparator.comparing(Item::getRatio).reversed());

		int numberOfItems = 0;
		double capacityUsed = 0;
		BigDecimal value = BigDecimal.ZERO;

		for (Item item: items) {
			if (capacityUsed + item.getWeight() > problemInstance.getCapacity()) {
				break;
			}
			capacityUsed += item.getWeight();
			value = value.add(item.getValue());
			numberOfItems++;
		}

		return new Solution(items.subList(0, numberOfItems), value);
	}

	@Override
	public String getDescription() {
		return null;
	}
}
