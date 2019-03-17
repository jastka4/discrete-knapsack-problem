package org.jastka4.knapsack.algorithms;

import org.jastka4.knapsack.KnapsackAlgorithm;
import org.jastka4.knapsack.ProblemInstance;
import org.jastka4.knapsack.Solution;

/**
 * {@inheritDoc}
 *
 * Random search implementation of the discrete knapsack problem.
 */
public class RandomSearch implements KnapsackAlgorithm {

	private ProblemInstance problemInstance;

	public RandomSearch(final ProblemInstance problemInstance) {
		this.problemInstance = problemInstance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Solution solve() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return null;
	}
}
