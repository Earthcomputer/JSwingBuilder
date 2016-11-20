package net.earthcomputer.swing;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class ButtonGroupBuilder<PARENT extends ContainerBuilder<?, ?, ?>> {

	private PARENT parent;
	private ButtonGroup group;

	public ButtonGroupBuilder(PARENT parent) {
		this.parent = parent;
	}

	public ButtonGroupBuilder<PARENT> add(AbstractButton button) {
		group.add(button);
		parent.add(button);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <CHILD extends JButtonBuilder<JButton, ButtonGroupBuilder<PARENT>, CHILD>> CHILD button() {
		return (CHILD) (Object) new JButtonBuilder<>(this, new JButton());
	}

	@SuppressWarnings("unchecked")
	public <CHILD extends JButtonBuilder<JRadioButton, ButtonGroupBuilder<PARENT>, CHILD>> CHILD radio() {
		return (CHILD) (Object) new JButtonBuilder<>(this, new JRadioButton());
	}

	@SuppressWarnings("unchecked")
	public <CHILD extends JButtonBuilder<JCheckBox, ButtonGroupBuilder<PARENT>, CHILD>> CHILD checkbox() {
		return (CHILD) (Object) new JButtonBuilder<>(this, new JCheckBox());
	}

	public PARENT end() {
		return parent;
	}

}
