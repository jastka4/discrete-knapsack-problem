package org.jastka4.knapsack;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@inheritDoc}
 *
 * Brute force implementation of the discrete knapsack problem.
 */
public class BruteForce implements Knapsack {
	// instance of the problem
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

		for (BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.ONE.shiftLeft(size)) < 0; i = i.add(BigInteger.ONE)) {
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

	public static void main(String[] args) {
		// we take the same instance of the problem displayed in the image
		List<Item> items = Arrays.asList(
				new Item("Elt1", BigDecimal.valueOf(4), 12),
				new Item("Elt2", BigDecimal.valueOf(2.15), 1),
				new Item("Elt3", BigDecimal.valueOf(2), 2),
				new Item("Elt4", BigDecimal.valueOf(1), 1),
				new Item("Elt5", BigDecimal.valueOf(10), 4));

		ProblemInstance problemInstance = new ProblemInstance(items, 15);

		BruteForce bruteForce = new BruteForce(problemInstance);
		System.out.println(bruteForce);
		Solution solution = bruteForce.solve();
		System.out.println(solution);
	}

	@Override
	public String getDescription() {
		return null;
	}
}
