package net.earthcomputer.swing;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

@SuppressWarnings("unchecked")
public class JTextFieldBuilder<COMPONENT extends JTextField, PARENT, THIS extends JTextFieldBuilder<COMPONENT, PARENT, THIS>>
		extends JTextComponentBuilder<COMPONENT, PARENT, THIS> {

	protected JTextFieldBuilder(PARENT parent, COMPONENT toAddTo) {
		super(parent, toAddTo);
	}

	public THIS onEnterPressed(ActionListener listener) {
		component.addActionListener(listener);
		return (THIS) this;
	}
	
	public THIS actionCommand(String command) {
		component.setActionCommand(command);
		return (THIS) this;
	}
	
	public THIS columns(int cols) {
		component.setColumns(cols);
		return (THIS) this;
	}
	
	public THIS horizontalAlignment(HorizontalAlignment alignment) {
		component.setHorizontalAlignment(alignment.primitiveValue());
		return (THIS) this;
	}
	
	public THIS scrollOffset(int scrollOffset) {
		component.setScrollOffset(scrollOffset);
		return (THIS) this;
	}

}
