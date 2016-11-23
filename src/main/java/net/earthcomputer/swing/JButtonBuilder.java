package net.earthcomputer.swing;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;

@SuppressWarnings("unchecked")
public class JButtonBuilder<COMPONENT extends AbstractButton, PARENT, THIS extends JButtonBuilder<COMPONENT, PARENT, THIS>>
		extends JComponentBuilder<COMPONENT, PARENT, THIS> {

	protected JButtonBuilder(Map<Object, Object> references, PARENT parent, COMPONENT toAddTo) {
		super(references, parent, toAddTo);
	}

	public THIS onPressed(ActionListener listener) {
		component.addActionListener(listener);
		return (THIS) this;
	}

	public THIS actionCommand(String command) {
		component.setActionCommand(command);
		return (THIS) this;
	}

	public THIS disabledIcon(Icon icon) {
		component.setDisabledIcon(icon);
		return (THIS) this;
	}

	public THIS disabledSelectedIcon(Icon icon) {
		component.setDisabledSelectedIcon(icon);
		return (THIS) this;
	}

	public THIS borderPainted(boolean borderPainted) {
		component.setBorderPainted(borderPainted);
		return (THIS) this;
	}

	public THIS focusPainted(boolean focusPainted) {
		component.setFocusPainted(focusPainted);
		return (THIS) this;
	}

	public THIS hideActionText(boolean hideActionText) {
		component.setHideActionText(hideActionText);
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

	public THIS margin(Insets margin) {
		component.setMargin(margin);
		return (THIS) this;
	}

	public THIS mnemonic(int keyCode) {
		component.setMnemonic(keyCode);
		return (THIS) this;
	}

	public THIS model(ButtonModel model) {
		component.setModel(model);
		return (THIS) this;
	}

	public THIS pressedIcon(Icon icon) {
		component.setPressedIcon(icon);
		return (THIS) this;
	}

	public THIS rolloverEnabled(boolean rolloverEnabled) {
		component.setRolloverEnabled(rolloverEnabled);
		return (THIS) this;
	}

	public THIS rolloverIcon(Icon icon) {
		component.setRolloverIcon(icon);
		return (THIS) this;
	}

	public THIS rolloverSelectedIcon(Icon icon) {
		component.setRolloverSelectedIcon(icon);
		return (THIS) this;
	}

	public THIS selected(boolean selected) {
		component.setSelected(selected);
		return (THIS) this;
	}

	public THIS selectedIcon(Icon icon) {
		component.setSelectedIcon(icon);
		return (THIS) this;
	}

	public THIS text(String text) {
		component.setText(text);
		return (THIS) this;
	}

	public THIS verticalTextPosition(VerticalAlignment textPosition) {
		component.setVerticalTextPosition(textPosition.primitiveValue());
		return (THIS) this;
	}

	public THIS horizontalAlignment(HorizontalAlignment horizontalAlignment) {
		component.setHorizontalAlignment(horizontalAlignment.primitiveValue());
		return (THIS) this;
	}

	public THIS verticalAlignment(VerticalAlignment verticalAlignment) {
		component.setVerticalAlignment(verticalAlignment.primitiveValue());
		return (THIS) this;
	}

	@Override
	protected void onEnd() {
		super.onEnd();
		if (parent instanceof ButtonGroupBuilder) {
			((ButtonGroupBuilder<?>) parent).add(component);
		}
	}

}
