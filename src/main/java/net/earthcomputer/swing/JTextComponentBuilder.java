package net.earthcomputer.swing;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.InputMethodListener;
import java.util.function.Consumer;

import javax.swing.DropMode;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.NavigationFilter;

@SuppressWarnings("unchecked")
public class JTextComponentBuilder<COMPONENT extends JTextComponent, PARENT, THIS extends JTextComponentBuilder<COMPONENT, PARENT, THIS>>
		extends JComponentBuilder<COMPONENT, PARENT, THIS> {

	protected JTextComponentBuilder(PARENT parent, COMPONENT toAddTo) {
		super(parent, toAddTo);
	}
	
	public THIS caretListener(CaretListener listener) {
		component.addCaretListener(listener);
		return (THIS) this;
	}
	
	public THIS inputMethodListener(InputMethodListener listener) {
		component.addInputMethodListener(listener);
		return (THIS) this;
	}

	public THIS select(int start, int end) {
		component.select(start, end);
		return (THIS) this;
	}

	public THIS selectAll() {
		component.selectAll();
		return (THIS) this;
	}

	public THIS caret(Caret caret) {
		component.setCaret(caret);
		return (THIS) this;
	}

	public THIS caretColor(Color caretColor) {
		component.setCaretColor(caretColor);
		return (THIS) this;
	}

	public THIS caretPosition(int pos) {
		component.setCaretPosition(pos);
		return (THIS) this;
	}

	public THIS disabledTextColor(Color color) {
		component.setDisabledTextColor(color);
		return (THIS) this;
	}

	public THIS document(Document document) {
		component.setDocument(document);
		return (THIS) this;
	}

	public THIS dragEnabled(boolean dragEnabled) {
		component.setDragEnabled(dragEnabled);
		return (THIS) this;
	}

	public THIS dropMode(DropMode dropMode) {
		component.setDropMode(dropMode);
		return (THIS) this;
	}

	public THIS editable(boolean editable) {
		component.setEditable(editable);
		return (THIS) this;
	}

	public THIS focusAccelerator(char key) {
		component.setFocusAccelerator(key);
		return (THIS) this;
	}

	public THIS highlighter(Highlighter highlighter) {
		component.setHighlighter(highlighter);
		return (THIS) this;
	}

	public THIS margin(Insets margin) {
		component.setMargin(margin);
		return (THIS) this;
	}

	public THIS navigationFilter(NavigationFilter filter) {
		component.setNavigationFilter(filter);
		return (THIS) this;
	}

	public THIS selectedTextColor(Color color) {
		component.setSelectedTextColor(color);
		return (THIS) this;
	}

	public THIS selectionColor(Color color) {
		component.setSelectionColor(color);
		return (THIS) this;
	}

	public THIS text(String text) {
		component.setText(text);
		return (THIS) this;
	}

	public THIS documentListener(DocumentListener listener) {
		component.getDocument().addDocumentListener(listener);
		return (THIS) this;
	}

	public THIS onChanged(Consumer<DocumentEvent> listener) {
		return documentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent event) {
				listener.accept(event);
			}

			@Override
			public void insertUpdate(DocumentEvent event) {
				listener.accept(event);
			}

			@Override
			public void removeUpdate(DocumentEvent event) {
				listener.accept(event);
			}
		});
	}
	
	public THIS undoableEditListener(UndoableEditListener listener) {
		component.getDocument().addUndoableEditListener(listener);
		return (THIS) this;
	}

}
