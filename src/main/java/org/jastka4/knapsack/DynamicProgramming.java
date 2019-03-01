package org.jastka4.knapsack;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@inheritDoc}
 *
 * Dynamic programming implementation of the discrete knapsack problem.
 */
public class DynamicProgramming implements KnapsackAlgorithm {

	private ProblemInstance problemInstance;

	/**
	 * Class constructor specifying instance of the discrete knapsack problem.
	 *
	 * @param problemInstance   instance of the discrete knapsack problem
	 */
	public DynamicProgramming(final ProblemInstance problemInstance) {
		this.problemInstance = problemInstance;
	}

	// we write the solve algorithm
	@Override
	public Solution solve() {
		List<Item> items = problemInstance.getItems();
		int size = problemInstance.getItems().size();
		int capacity = problemInstance.getCapacity();
		// we use a matrix to store the max value at each n-th item
		BigDecimal[][] matrix = new BigDecimal[size + 1][capacity + 1];

		// first line is initialized to 0
		Arrays.fill(matrix[0], BigDecimal.ZERO);

		// we iterate on items
		for (int i = 1; i <= size; i++) {
			// we iterate on each capacity
			for (int j = 0; j <= capacity; j++) {
				if (items.get(i - 1).getWeight() > j) {
					matrix[i][j] = matrix[i-1][j];
				} else {
					// we maximize value at this rank in the matrix
					matrix[i][j] = (matrix[i-1][j])
							.max((matrix[i-1][j - items.get(i-1).getWeight()]).add(items.get(i-1).getValue()));
				}
			}
		}

		BigDecimal res = matrix[size][capacity];
		int w = capacity;
		List<Item> itemsSolution = new ArrayList<>();

		for (int i = size; i > 0  &&  res.compareTo(BigDecimal.ZERO) > 0; i--) {
			if (res.compareTo(matrix[i-1][w]) != 0) {
				itemsSolution.add(items.get(i-1));
				// we remove items value and weight
				res = res.subtract(items.get(i-1).getValue());
				w -= items.get(i-1).getWeight();
			}
		}

		return new Solution(itemsSolution, matrix[size][capacity]);
	}

	@Override
	public String getDescription() {
		return "";
	}
}
