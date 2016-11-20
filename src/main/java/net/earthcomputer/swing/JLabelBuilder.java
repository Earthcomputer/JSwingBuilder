package net.earthcomputer.swing;

import javax.swing.Icon;
import javax.swing.JLabel;

@SuppressWarnings("unchecked")
public class JLabelBuilder<COMPONENT extends JLabel, PARENT, THIS extends JLabelBuilder<COMPONENT, PARENT, THIS>>
		extends JComponentBuilder<COMPONENT, PARENT, THIS> {

	protected JLabelBuilder(PARENT parent, COMPONENT toAddTo) {
		super(parent, toAddTo);
	}

	public THIS disabledIcon(Icon icon) {
		component.setDisabledIcon(icon);
		return (THIS) this;
	}

	public THIS disabledMnemonic(int keyCode) {
		component.setDisplayedMnemonic(keyCode);
		return (THIS) this;
	}

	public THIS horizontalAlignment(HorizontalAlignment horizontalAlignment) {
		component.setHorizontalAlignment(horizontalAlignment.primitiveValue());
		return (THIS) this;
	}

	public THIS horizontalTextPosition(HorizontalAlignment textPosition) {
		component.setHorizontalTextPosition(textPosition.primitiveValue());
		return (THIS) this;
	}

	public THIS icon(Icon icon) {
		component.setIcon(icon);
		return (THIS) this;
	}

	public THIS iconTextGap(int iconTextGap) {
		component.setIconTextGap(iconTextGap);
		return (THIS) this;
	}

	public THIS text(String text) {
		component.setText(text);
		return (THIS) this;
	}

	public THIS verticalAlignment(VerticalAlignment verticalAlignment) {
		component.setVerticalAlignment(verticalAlignment.primitiveValue());
		return (THIS) this;
	}

	public THIS verticalTextPosition(VerticalAlignment textPosition) {
		component.setVerticalTextPosition(textPosition.primitiveValue());
		return (THIS) this;
	}

}
