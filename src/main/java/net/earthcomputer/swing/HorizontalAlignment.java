package net.earthcomputer.swing;

import javax.swing.SwingConstants;

public enum HorizontalAlignment implements IConstant<Integer> {
	RIGHT(SwingConstants.RIGHT), LEFT(SwingConstants.LEFT), CENTER(SwingConstants.CENTER), LEADING(
			SwingConstants.LEADING), TRAILING(SwingConstants.TRAILING);

	private final int intValue;

	private HorizontalAlignment(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public Integer primitiveValue() {
		return intValue;
	}
}
