package net.earthcomputer.swing;

import javax.swing.border.TitledBorder;

public enum TitledBorderJustification implements IConstant<Integer> {
	RIGHT(TitledBorder.RIGHT), LEFT(TitledBorder.LEFT), CENTER(TitledBorder.CENTER), LEADING(
			TitledBorder.LEADING), TRAILING(TitledBorder.TRAILING), DEFAULT_JUSTIFICATION(
					TitledBorder.DEFAULT_JUSTIFICATION);

	private final int intValue;

	private TitledBorderJustification(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public Integer primitiveValue() {
		return intValue;
	}
}
