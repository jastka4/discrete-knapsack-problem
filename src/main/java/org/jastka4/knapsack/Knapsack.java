package org.jastka4.knapsack;

/**
 *
 */
public interface Knapsack {
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
