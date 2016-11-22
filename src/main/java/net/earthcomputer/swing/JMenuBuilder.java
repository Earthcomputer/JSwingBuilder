package net.earthcomputer.swing;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuListener;

@SuppressWarnings("unchecked")
public class JMenuBuilder<COMPONENT extends JMenu, PARENT, THIS extends JMenuBuilder<COMPONENT, PARENT, THIS>>
		extends JComponentBuilder<COMPONENT, PARENT, THIS> {

	protected JMenuBuilder(PARENT parent, COMPONENT toAddTo) {
		super(parent, toAddTo);
	}

	public <CHILD extends JMenuBuilder<JMenu, THIS, CHILD>> CHILD menu() {
		return (CHILD) childComponent(JMenu.class, JMenuBuilder.class);
	}

	public <CHILD extends JMenuItemBuilder<JMenuItem, THIS, CHILD>> CHILD menuItem() {
		return (CHILD) childComponent(JMenuItem.class, JMenuItemBuilder.class);
	}
	
	public THIS separator() {
		component.addSeparator();
		return (THIS) this;
	}
	
	public THIS menuListener(MenuListener listener) {
		component.addMenuListener(listener);
		return (THIS) this;
	}
	
	public THIS delay(int d) {
		component.setDelay(d);
		return (THIS) this;
	}
	
	public THIS menuLocation(int x, int y) {
		component.setMenuLocation(x, y);
		return (THIS) this;
	}
	
	public THIS popupMenuVisible(boolean visible) {
		component.setPopupMenuVisible(visible);
		return (THIS) this;
	}
	
	public THIS selected(boolean selected) {
		component.setSelected(selected);
		return (THIS) this;
	}

}
