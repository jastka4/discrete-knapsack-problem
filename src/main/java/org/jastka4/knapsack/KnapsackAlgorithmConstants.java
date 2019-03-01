package org.jastka4.knapsack;

public enum KnapsackAlgorithmConstants {
	BRUTE_FORCE("Brute Force"),
	DYNAMIC_PROGRAMMING("Dynamic Programming"),
	GREEDY_ALGORITHM("Greedy Algorithm"),
	RANDOM_SEARCH("Random Search");

	private String name;

	KnapsackAlgorithmConstants(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
