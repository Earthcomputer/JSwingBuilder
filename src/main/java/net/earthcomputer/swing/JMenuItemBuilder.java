package net.earthcomputer.swing;

import java.util.Map;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuDragMouseListener;
import javax.swing.event.MenuKeyListener;

@SuppressWarnings("unchecked")
public class JMenuItemBuilder<COMPONENT extends JMenuItem, PARENT, THIS extends JMenuItemBuilder<COMPONENT, PARENT, THIS>>
		extends JButtonBuilder<COMPONENT, PARENT, THIS> {

	protected JMenuItemBuilder(Map<Object, Object> references, PARENT parent, COMPONENT toAddTo) {
		super(references, parent, toAddTo);
	}

	public THIS menuDragMouseListener(MenuDragMouseListener listener) {
		component.addMenuDragMouseListener(listener);
		return (THIS) this;
	}

	public THIS menuKeyListener(MenuKeyListener listener) {
		component.addMenuKeyListener(listener);
		return (THIS) this;
	}

	public THIS accelerator(int keyCode) {
		return accelerator(keyCode, 0);
	}

	public THIS accelerator(int keyCode, int modifiers) {
		return accelerator(keyCode, modifiers, false);
	}

	public THIS accelerator(int keyCode, int modifiers, boolean onKeyRelease) {
		return accelerator(KeyStroke.getKeyStroke(keyCode, modifiers, onKeyRelease));
	}

	public THIS accelerator(KeyStroke keyStroke) {
		component.setAccelerator(keyStroke);
		return (THIS) this;
	}
	
	public THIS armed(boolean armed) {
		component.setArmed(armed);
		return (THIS) this;
	}

}
