package net.earthcomputer.swing;

import javax.swing.JTextArea;

@SuppressWarnings("unchecked")
public class JTextAreaBuilder<COMPONENT extends JTextArea, PARENT, THIS extends JTextAreaBuilder<COMPONENT, PARENT, THIS>>
		extends JTextComponentBuilder<COMPONENT, PARENT, THIS> {

	protected JTextAreaBuilder(PARENT parent, COMPONENT toAddTo) {
		super(parent, toAddTo);
	}

	public THIS columns(int cols) {
		component.setColumns(cols);
		return (THIS) this;
	}
	
	public THIS lineWrap(boolean lineWrap) {
		component.setLineWrap(lineWrap);
		return (THIS) this;
	}
	
	public THIS rows(int rows) {
		component.setRows(rows);
		return (THIS) this;
	}
	
	public THIS tabSize(int tabSize) {
		component.setTabSize(tabSize);
		return (THIS) this;
	}
	
	public THIS wrapStyleWord(boolean wrapStyleWord) {
		component.setWrapStyleWord(wrapStyleWord);
		return (THIS) this;
	}

}
