package net.earthcomputer.swing;

import javax.swing.border.BevelBorder;

public enum BevelBorderType implements IConstant<Integer> {
	LOWERED(BevelBorder.LOWERED), RAISED(BevelBorder.RAISED);

	private final int intValue;

	private BevelBorderType(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public Integer primitiveValue() {
		return intValue;
	}
}
