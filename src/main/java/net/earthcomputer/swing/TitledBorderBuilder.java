package net.earthcomputer.swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class TitledBorderBuilder<PARENT extends IBorderBuilder<PARENT>>
		implements IBorderBuilder<TitledBorderBuilder<PARENT>> {

	private PARENT parent;
	private Border border = null;
	private String title = "";
	private TitledBorderJustification titleJustification = TitledBorderJustification.DEFAULT_JUSTIFICATION;
	private TitledBorderPosition titlePosition = TitledBorderPosition.DEFAULT_POSITION;
	private Font titleFont = null;
	private Color titleColor = null;

	public TitledBorderBuilder(PARENT parent) {
		this.parent = parent;
	}

	@Override
	public TitledBorderBuilder<PARENT> border(Border border) {
		this.border = border;
		return this;
	}

	public TitledBorderBuilder<PARENT> title(String title) {
		this.title = title;
		return this;
	}

	public TitledBorderBuilder<PARENT> titleJustification(TitledBorderJustification titleJustification) {
		this.titleJustification = titleJustification;
		return this;
	}

	public TitledBorderBuilder<PARENT> titlePosition(TitledBorderPosition titlePosition) {
		this.titlePosition = titlePosition;
		return this;
	}

	public TitledBorderBuilder<PARENT> titleFont(Font titleFont) {
		this.titleFont = titleFont;
		return this;
	}

	public TitledBorderBuilder<PARENT> titleColor(Color titleColor) {
		this.titleColor = titleColor;
		return this;
	}

	public PARENT end() {
		parent.border(BorderFactory.createTitledBorder(border, title, titleJustification.primitiveValue(),
				titlePosition.primitiveValue(), titleFont, titleColor));
		return parent;
	}

}
