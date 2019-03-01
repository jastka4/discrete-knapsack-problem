package org.jastka4.knapsack;

/**
 * KnapsackAlgorithm problem is a problem in combinatorial optimization.
 * Given a set of items, each with a weight and a value,
 * determine the number of each item to include in a collection
 * so that the total weight is less than or equal to a given limit
 * and the total value is as large as possible.
 * See <a href="https://en.wikipedia.org/wiki/Knapsack_problem">KnapsackAlgorithm problem - Wikipedia</a>
 * for more details.
 *
 * This library implements 0-1 knapsack problem where the maximum
 * number of copies of each kind of item can be zero or one.
 *
 * Input is a list of items each with a name, weight and value
 * along with an instance of the problem.
 *
 * @see Item
 * @see ProblemInstance
 * @see Solution
 */
public interface KnapsackAlgorithm {
	/**
	 * Solves discrete knapsack problem.
	 *
	 * @return  solution
	 * @see     Solution
	 */
	Solution solve();

	/**
	 * Returns full description of the implementation of the discrete knapsack problem.
	 *
	 * @return  description of the implementation
	 */
	String getDescription();
}
