package net.earthcomputer.swing;

import javax.swing.border.EtchedBorder;

public enum EtchedBorderType implements IConstant<Integer> {
	LOWERED(EtchedBorder.LOWERED), RAISED(EtchedBorder.RAISED);

	private final int intValue;

	private EtchedBorderType(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public Integer primitiveValue() {
		return intValue;
	}
}
