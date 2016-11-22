package net.earthcomputer.swing;

import javax.swing.SwingConstants;

public enum Orientation implements IConstant<Integer> {

	VERTICAL(SwingConstants.VERTICAL), HORIZONTAL(SwingConstants.HORIZONTAL);

	private final int intValue;

	private Orientation(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public Integer primitiveValue() {
		return intValue;
	}

}
