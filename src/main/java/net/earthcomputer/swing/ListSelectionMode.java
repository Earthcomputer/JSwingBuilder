package net.earthcomputer.swing;

import javax.swing.ListSelectionModel;

public enum ListSelectionMode implements IConstant<Integer> {

	SINGLE_SELECTION(ListSelectionModel.SINGLE_SELECTION), SINGLE_INTERVAL_SELECTION(
			ListSelectionModel.SINGLE_INTERVAL_SELECTION), MULTIPLE_INTERVAL_SELECTION(
					ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	private final int intValue;

	private ListSelectionMode(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public Integer primitiveValue() {
		return intValue;
	}

}
