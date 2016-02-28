package beans;

public enum SortingAlgorithm {

	SELECTION, INSERTION, MERGE, QUICK;

	public SortingAlgorithm fromString(String algoName) {
		switch (algoName.toLowerCase()) {
		case "selection":
			return SortingAlgorithm.SELECTION;
		case "insertion":
			return SortingAlgorithm.INSERTION;
		case "shell":
			return SortingAlgorithm.MERGE;
		case "quick":
			return SortingAlgorithm.QUICK;
		default:
			throw new IllegalArgumentException("Unknown sorting algorithm");
		}
	}

}
