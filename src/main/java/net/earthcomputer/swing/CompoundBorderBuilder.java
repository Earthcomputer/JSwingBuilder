package net.earthcomputer.swing;

import java.util.EnumMap;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class CompoundBorderBuilder<PARENT extends IBorderBuilder<?>>
		implements IBorderBuilder<CompoundBorderBuilder<PARENT>> {

	private PARENT parent;
	private SubBorderType subBorder;
	private final EnumMap<SubBorderType, Border> borders = new EnumMap<>(SubBorderType.class);

	public CompoundBorderBuilder(PARENT parent) {
		this.parent = parent;
	}

	public CompoundBorderBuilder<PARENT> outerBorder() {
		return subBorder(SubBorderType.OUTER);
	}

	public CompoundBorderBuilder<PARENT> innerBorder() {
		return subBorder(SubBorderType.INNER);
	}

	private CompoundBorderBuilder<PARENT> subBorder(SubBorderType type) {
		if (subBorder != null) {
			throw new IllegalStateException("Already building a sub-border");
		}
		subBorder = type;
		return this;
	}

	@Override
	public CompoundBorderBuilder<PARENT> border(Border border) {
		if (subBorder == null) {
			throw new IllegalStateException("Need to start building the sub-border first");
		}
		borders.put(subBorder, border);
		return this;
	}

	public CompoundBorderBuilder<PARENT> endSubBorder() {
		if (subBorder == null) {
			throw new IllegalStateException("Not building a sub-border");
		}
		subBorder = null;
		return this;
	}

	public PARENT end() {
		if (subBorder != null) {
			throw new IllegalStateException("Not finished building a sub-border");
		}
		parent.border(
				BorderFactory.createCompoundBorder(borders.get(SubBorderType.OUTER), borders.get(SubBorderType.INNER)));
		return parent;
	}

	private static enum SubBorderType {
		OUTER, INNER
	}

}
