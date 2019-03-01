package org.jastka4.knapsack;

public class KnapsackAlgorithmFactory {

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
