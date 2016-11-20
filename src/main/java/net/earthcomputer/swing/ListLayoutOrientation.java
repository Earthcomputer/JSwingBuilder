package net.earthcomputer.swing;

import javax.swing.JList;

public enum ListLayoutOrientation implements IConstant<Integer> {

	VERTICAL(JList.VERTICAL), HORIZONTAL_WRAP(JList.HORIZONTAL_WRAP), VERTICAL_WRAP(JList.VERTICAL_WRAP);

	private final int intValue;

	private ListLayoutOrientation(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public Integer primitiveValue() {
		return intValue;
	}

}
