package org.jastka4.knapsack;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 *
 * Brute force implementation of the discrete knapsack problem.
 */
public class BruteForce implements KnapsackAlgorithm {

	private ProblemInstance problemInstance;

	public BruteForce(final ProblemInstance problemInstance) {
		this.problemInstance = problemInstance;
	}

	@Override
	public Solution solve() {
		final List<Item> items = problemInstance.getItems();
		final int size = problemInstance.getItems().size();

		BigDecimal bestProfit = BigDecimal.valueOf(-1);
		List<Item> bestItems = new ArrayList<>();

		for (BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.TWO.shiftLeft(size)) < 0; i = i.add(BigInteger.ONE)) {
			int totalWeight = 0;
			BigDecimal totalProfit = BigDecimal.ZERO;
			List<Item> totalItems = new ArrayList<>();

			for (int j = 0; j < size; j++) {
				if (i.testBit(j)) { // checks if the designated bit is set
					totalWeight += items.get(j).getWeight();
					totalProfit = totalProfit.add(items.get(j).getValue());
					totalItems.add(items.get(j));
				}
			}
			if (totalWeight <= problemInstance.getCapacity() && totalProfit.compareTo(bestProfit) > 0) {
				bestProfit = totalProfit;
				bestItems = totalItems;
			}
		}

		return new Solution(bestItems, bestProfit);
	}

	@Override
	public String getDescription() {
		return null;
	}
}
