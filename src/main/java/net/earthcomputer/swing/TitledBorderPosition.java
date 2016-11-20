package net.earthcomputer.swing;

import javax.swing.border.TitledBorder;

public enum TitledBorderPosition implements IConstant<Integer> {

	ABOVE_TOP(TitledBorder.ABOVE_TOP), TOP(TitledBorder.TOP), BELOW_TOP(TitledBorder.BELOW_TOP), ABOVE_BOTTOM(
			TitledBorder.ABOVE_BOTTOM), BOTTOM(TitledBorder.BOTTOM), BELOW_BOTTOM(
					TitledBorder.BELOW_BOTTOM), DEFAULT_POSITION(TitledBorder.DEFAULT_POSITION);

	private final int intValue;

	private TitledBorderPosition(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public Integer primitiveValue() {
		return intValue;
	}

}
