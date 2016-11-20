package net.earthcomputer.swing;

import javax.swing.SwingConstants;

public enum VerticalAlignment implements IConstant<Integer> {
	CENTER(SwingConstants.CENTER), TOP(SwingConstants.TOP), BOTTOM(SwingConstants.BOTTOM);

	private final int intValue;

	private VerticalAlignment(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public Integer primitiveValue() {
		return intValue;
	}
}
