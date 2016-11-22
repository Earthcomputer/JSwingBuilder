package net.earthcomputer.swing;

import java.awt.Insets;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.ChangeListener;

@SuppressWarnings("unchecked")
public class JMenuBarBuilder<COMPONENT extends JMenuBar, PARENT, THIS extends JMenuBarBuilder<COMPONENT, PARENT, THIS>>
		extends JComponentBuilder<COMPONENT, PARENT, THIS> {

	protected JMenuBarBuilder(PARENT parent, COMPONENT toAddTo) {
		super(parent, toAddTo);
	}

	public <CHILD extends JMenuBuilder<JMenu, THIS, CHILD>> CHILD menu() {
		return (CHILD) childComponent(JMenu.class, JMenuBuilder.class);
	}

	public THIS borderPainted(boolean borderPainted) {
		component.setBorderPainted(borderPainted);
		return (THIS) this;
	}

	public THIS margin(Insets margin) {
		component.setMargin(margin);
		return (THIS) this;
	}
	
	public THIS selectedIndex(int selectedIndex) {
		component.getSelectionModel().setSelectedIndex(selectedIndex);
		return (THIS) this;
	}
	
	public THIS selectionChangeListener(ChangeListener listener) {
		component.getSelectionModel().addChangeListener(listener);
		return (THIS) this;
	}

}
