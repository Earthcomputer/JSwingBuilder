package net.earthcomputer.swing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;

@SuppressWarnings("unchecked")
public class JListBuilder<E, COMPONENT extends JList<E>, PARENT, THIS extends JListBuilder<E, COMPONENT, PARENT, THIS>>
		extends JComponentBuilder<COMPONENT, PARENT, THIS> {

	private boolean hasSetModel = false;
	private List<E> items = new ArrayList<>();

	protected JListBuilder(Map<Object, Object> references, PARENT parent, COMPONENT toAddTo) {
		super(references, parent, toAddTo);
	}

	public THIS item(E item) {
		ensureNotSetModel();
		items.add(item);
		return (THIS) this;
	}

	public THIS items(E... items) {
		for (E item : items) {
			item(item);
		}
		return (THIS) this;
	}

	public THIS items(Collection<E> items) {
		ensureNotSetModel();
		this.items.addAll(items);
		return (THIS) this;
	}

	public THIS model(ListModel<E> model) {
		component.setModel(model);
		items.clear();
		hasSetModel = true;
		return (THIS) this;
	}

	public THIS listDataListener(ListDataListener listener) {
		ensureModelCreated();
		component.getModel().addListDataListener(listener);
		return (THIS) this;
	}

	public THIS cellRenderer(ListCellRenderer<? super E> renderer) {
		component.setCellRenderer(renderer);
		return (THIS) this;
	}

	public THIS dragEnabled(boolean dragEnabled) {
		component.setDragEnabled(dragEnabled);
		return (THIS) this;
	}

	public THIS dropMode(DropMode mode) {
		component.setDropMode(mode);
		return (THIS) this;
	}

	public THIS fixedCellHeight(int height) {
		component.setFixedCellHeight(height);
		return (THIS) this;
	}

	public THIS fixedCellWidth(int width) {
		component.setFixedCellWidth(width);
		return (THIS) this;
	}

	public THIS layoutOrientation(ListLayoutOrientation orientation) {
		component.setLayoutOrientation(orientation.primitiveValue());
		return (THIS) this;
	}
	
	public THIS prototypeCellValue(E prototypeCellValue) {
		component.setPrototypeCellValue(prototypeCellValue);
		return (THIS) this;
	}
	
	public THIS selectedIndex(int selectedIndex) {
		ensureModelCreated();
		component.setSelectedIndex(selectedIndex);
		return (THIS) this;
	}
	
	public THIS selectedIndices(int... selectedIndices) {
		ensureModelCreated();
		component.setSelectedIndices(selectedIndices);
		return (THIS) this;
	}
	
	public THIS selectedValue(Object value, boolean shouldScroll) {
		ensureModelCreated();
		component.setSelectedValue(value, shouldScroll);
		return (THIS) this;
	}
	
	public THIS selectionBackground(Color selectionBackground) {
		component.setSelectionBackground(selectionBackground);
		return (THIS) this;
	}
	
	public THIS selectionForeground(Color selectionForeground) {
		component.setSelectionForeground(selectionForeground);
		return (THIS) this;
	}
	
	public THIS selectionInterval(int anchor, int lead) {
		component.setSelectionInterval(anchor, lead);
		return (THIS) this;
	}
	
	public THIS selectionMode(ListSelectionMode mode) {
		component.setSelectionMode(mode.primitiveValue());
		return (THIS) this;
	}
	
	public THIS selectionModel(ListSelectionModel model) {
		component.setSelectionModel(model);
		return (THIS) this;
	}
	
	public THIS valueIsAdjusting(boolean valueIsAdjusting) {
		component.setValueIsAdjusting(valueIsAdjusting);
		return (THIS) this;
	}
	
	public THIS visibleRowCount(int rows) {
		component.setVisibleRowCount(rows);
		return (THIS) this;
	}

	private void ensureNotSetModel() {
		if (hasSetModel) {
			throw new IllegalStateException(
					"Cannot add an item after the model has been set. Try adding your items first");
		}
	}

	private void ensureModelCreated() {
		if (!items.isEmpty()) {
			if (hasSetModel) {
				throw new AssertionError("This should never happen due to other checks");
			}
			DefaultListModel<E> newModel = new DefaultListModel<>();
			newModel.ensureCapacity(items.size());
			for (E item : items) {
				newModel.addElement(item);
			}
			component.setModel(newModel);
			items.clear();
		}
		hasSetModel = true;
	}

}
