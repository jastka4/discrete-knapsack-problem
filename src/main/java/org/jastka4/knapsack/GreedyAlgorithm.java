package org.jastka4.knapsack;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * {@inheritDoc}
 *
 * Greedy algorithm implementation of the discrete knapsack problem.
 */
public class GreedyAlgorithm implements Knapsack {
	// instance of the problem
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

	public static void main(String[] args) {
		// we take the same instance of the problem displayed in the image
		List<Item> items = Arrays.asList(
				new Item("Elt1", BigDecimal.valueOf(4), 12),
				new Item("Elt2", BigDecimal.valueOf(2.15), 1),
				new Item("Elt3", BigDecimal.valueOf(2), 2),
				new Item("Elt4", BigDecimal.valueOf(1), 1),
				new Item("Elt5", BigDecimal.valueOf(10), 4));

		ProblemInstance problemInstance = new ProblemInstance(items, 15);

		GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(problemInstance);
		System.out.println(greedyAlgorithm);
		Solution solution = greedyAlgorithm.solve();
		System.out.println(solution);
	}

	@Override
	public String getDescription() {
		return null;
	}
}
