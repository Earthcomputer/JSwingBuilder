package net.earthcomputer.swing;

import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class ButtonGroupBuilder<PARENT extends ContainerBuilder<?, ?, ?>> {

	private PARENT parent;
	private ButtonGroup group;
	private Map<Object, Object> references;

	public ButtonGroupBuilder(Map<Object, Object> references, PARENT parent) {
		this.parent = parent;
		this.references = references;
	}
	
	public ButtonGroupBuilder<PARENT> ref(Object id) {
		references.put(id, group);
		return this;
	}

	public ButtonGroupBuilder<PARENT> add(AbstractButton button) {
		group.add(button);
		parent.add(button);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <CHILD extends JButtonBuilder<JButton, ButtonGroupBuilder<PARENT>, CHILD>> CHILD button() {
		return (CHILD) (Object) new JButtonBuilder<>(references, this, new JButton());
	}

	@SuppressWarnings("unchecked")
	public <CHILD extends JButtonBuilder<JRadioButton, ButtonGroupBuilder<PARENT>, CHILD>> CHILD radio() {
		return (CHILD) (Object) new JButtonBuilder<>(references, this, new JRadioButton());
	}

	@SuppressWarnings("unchecked")
	public <CHILD extends JButtonBuilder<JCheckBox, ButtonGroupBuilder<PARENT>, CHILD>> CHILD checkbox() {
		return (CHILD) (Object) new JButtonBuilder<>(references, this, new JCheckBox());
	}

	public PARENT end() {
		return parent;
	}

}
