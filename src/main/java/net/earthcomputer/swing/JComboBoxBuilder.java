package net.earthcomputer.swing;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComboBox.KeySelectionManager;
import javax.swing.ListCellRenderer;
import javax.swing.event.PopupMenuListener;

@SuppressWarnings("unchecked")
public class JComboBoxBuilder<E, COMPONENT extends JComboBox<E>, PARENT, THIS extends JComboBoxBuilder<E, COMPONENT, PARENT, THIS>>
		extends JComponentBuilder<COMPONENT, PARENT, THIS> {

	protected JComboBoxBuilder(PARENT parent, COMPONENT toAddTo) {
		super(parent, toAddTo);
	}

	public THIS onChange(ActionListener listener) {
		component.addActionListener(listener);
		return (THIS) this;
	}
	
	public THIS item(E item) {
		component.addItem(item);
		return (THIS) this;
	}
	
	public THIS items(E... items) {
		for (E item : items) {
			item(item);
		}
		return (THIS) this;
	}
	
	public THIS items(Iterable<? extends E> items) {
		for (E item : items) {
			item(item);
		}
		return (THIS) this;
	}
	
	public THIS itemListener(ItemListener listener) {
		component.addItemListener(listener);
		return (THIS) this;
	}
	
	public THIS popupMenuListener(PopupMenuListener listener) {
		component.addPopupMenuListener(listener);
		return (THIS) this;
	}
	
	public THIS configureEditor(ComboBoxEditor editor, Object item) {
		component.configureEditor(editor, item);
		return (THIS) this;
	}
	
	public THIS actionCommand(String command) {
		component.setActionCommand(command);
		return (THIS) this;
	}
	
	public THIS editable(boolean editable) {
		component.setEditable(editable);
		return (THIS) this;
	}
	
	public THIS editor(ComboBoxEditor editor) {
		component.setEditor(editor);
		return (THIS) this;
	}
	
	public THIS keySelectionManager(KeySelectionManager keySelectionManager) {
		component.setKeySelectionManager(keySelectionManager);
		return (THIS) this;
	}
	
	public THIS lightWeightPopupEnabled(boolean enabled) {
		component.setLightWeightPopupEnabled(enabled);
		return (THIS) this;
	}
	
	public THIS maximumRowCount(int rows) {
		component.setMaximumRowCount(rows);
		return (THIS) this;
	}
	
	public THIS model(ComboBoxModel<E> model) {
		component.setModel(model);
		return (THIS) this;
	}
	
	public THIS popupVisible(boolean popupVisible) {
		component.setPopupVisible(popupVisible);
		return (THIS) this;
	}
	
	public THIS prototypeDisplayValue(E prototypeDisplayValue) {
		component.setPrototypeDisplayValue(prototypeDisplayValue);
		return (THIS) this;
	}
	
	public THIS renderer(ListCellRenderer<? super E> renderer) {
		component.setRenderer(renderer);
		return (THIS) this;
	}
	
	public THIS selectedIndex(int index) {
		component.setSelectedIndex(index);
		return (THIS) this;
	}
	
	public THIS selectedItem(Object item) {
		component.setSelectedItem(item);
		return (THIS) this;
	}
	
	public THIS showPopup() {
		component.showPopup();
		return (THIS) this;
	}

}
