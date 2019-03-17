package org.jastka4.knapsack;

import org.jastka4.knapsack.algorithms.BruteForce;
import org.jastka4.knapsack.algorithms.DynamicProgramming;
import org.jastka4.knapsack.algorithms.GreedyAlgorithm;
import org.jastka4.knapsack.algorithms.RandomSearch;

/**
 * Knapsack algorithm factory that creates an instance of the algorithm associated with the backpack problem instance.
 */
public class KnapsackAlgorithmFactory {

	/**
	 * Returns an instance of the algorithm associated with the backpack problem instance.
	 *
	 * @param algorithm constant
	 * @param problem instance
	 * @return instance of the algorithm
	 */
	public KnapsackAlgorithm createKnapsackAlgorithm(final KnapsackAlgorithmConstants algorithm, final ProblemInstance problemInstance) {
		KnapsackAlgorithm knapsackAlgorithm = null;
		if (KnapsackAlgorithmConstants.BRUTE_FORCE.equals(algorithm)) {
			knapsackAlgorithm = new BruteForce(problemInstance);
		} else if (KnapsackAlgorithmConstants.DYNAMIC_PROGRAMMING.equals(algorithm)) {
			knapsackAlgorithm = new DynamicProgramming(problemInstance);
		} else if (KnapsackAlgorithmConstants.GREEDY_ALGORITHM.equals(algorithm)) {
			knapsackAlgorithm = new GreedyAlgorithm(problemInstance);
		} else if (KnapsackAlgorithmConstants.RANDOM_SEARCH.equals(algorithm)) {
			knapsackAlgorithm = new RandomSearch(problemInstance);
		}

		return knapsackAlgorithm;
	}
}
