package net.earthcomputer.swing;

import java.awt.FlowLayout;

public enum FlowAlignment implements IConstant<Integer> {

	LEADING(FlowLayout.LEADING), CENTER(FlowLayout.CENTER), TRAILING(FlowLayout.TRAILING);

	private final int intValue;

	private FlowAlignment(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public Integer primitiveValue() {
		return intValue;
	}

}
