package net.earthcomputer.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyListener;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("unchecked")
public class ContainerBuilder<COMPONENT extends Container, PARENT, THIS extends ContainerBuilder<COMPONENT, PARENT, THIS>> {

	// FIELDS
	protected PARENT parent;
	protected COMPONENT component;

	// PROPERTIES
	public THIS containerListener(ContainerListener listener) {
		component.addContainerListener(listener);
		return (THIS) this;
	}

	public THIS propertyChangeListener(PropertyChangeListener listener) {
		component.addPropertyChangeListener(listener);
		return (THIS) this;
	}

	public THIS propertyChangeListener(String property, PropertyChangeListener listener) {
		component.addPropertyChangeListener(property, listener);
		return (THIS) this;
	}

	public THIS componentListener(ComponentListener listener) {
		component.addComponentListener(listener);
		return (THIS) this;
	}

	public THIS focusListener(FocusListener listener) {
		component.addFocusListener(listener);
		return (THIS) this;
	}

	public THIS hierarchyBoundsListener(HierarchyBoundsListener listener) {
		component.addHierarchyBoundsListener(listener);
		return (THIS) this;
	}

	public THIS hierarchyListener(HierarchyListener listener) {
		component.addHierarchyListener(listener);
		return (THIS) this;
	}

	public THIS inputMethodListener(InputMethodListener listener) {
		component.addInputMethodListener(listener);
		return (THIS) this;
	}

	public THIS keyListener(KeyListener listener) {
		component.addKeyListener(listener);
		return (THIS) this;
	}

	public THIS mouseListener(MouseListener listener) {
		component.addMouseListener(listener);
		return (THIS) this;
	}

	public THIS mouseMotionListener(MouseMotionListener listener) {
		component.addMouseMotionListener(listener);
		return (THIS) this;
	}

	public THIS mouseWheelListener(MouseWheelListener listener) {
		component.addMouseWheelListener(listener);
		return (THIS) this;
	}

	public THIS xAxisLayout() {
		return layout(new BoxLayout(component, BoxLayout.X_AXIS));
	}

	public THIS yAxisLayout() {
		return layout(new BoxLayout(component, BoxLayout.Y_AXIS));
	}

	public THIS lineAxisLayout() {
		return layout(new BoxLayout(component, BoxLayout.LINE_AXIS));
	}

	public THIS pageAxisLayout() {
		return layout(new BoxLayout(component, BoxLayout.PAGE_AXIS));
	}

	public THIS gridLayout(int rows, int cols) {
		return layout(new GridLayout(rows, cols));
	}

	public THIS gridLayout(int rows, int cols, int hgap, int vgap) {
		return layout(new GridLayout(rows, cols, hgap, vgap));
	}

	public THIS flowLayout() {
		return layout(new FlowLayout());
	}

	public THIS flowLayout(FlowAlignment align) {
		return layout(new FlowLayout(align.primitiveValue()));
	}

	public THIS flowLayout(FlowAlignment align, int hgap, int vgap) {
		return layout(new FlowLayout(align.primitiveValue(), hgap, vgap));
	}

	public THIS layout(LayoutManager layout) {
		component.setLayout(layout);
		return (THIS) this;
	}

	public THIS minimumWidth(int width) {
		return minimumSize(width, component.getPreferredSize().height);
	}

	public THIS minimumHeight(int height) {
		return minimumSize(component.getPreferredSize().width, height);
	}

	public THIS minimumSize(int width, int height) {
		return minimumSize(new Dimension(width, height));
	}

	public THIS minimumSize(Dimension preferredSize) {
		component.setMinimumSize(preferredSize);
		return (THIS) this;
	}

	public THIS maximumWidth(int width) {
		return maximumSize(width, component.getPreferredSize().height);
	}

	public THIS maximumHeight(int height) {
		return maximumSize(component.getPreferredSize().width, height);
	}

	public THIS maximumSize(int width, int height) {
		return maximumSize(new Dimension(width, height));
	}

	public THIS maximumSize(Dimension preferredSize) {
		component.setMaximumSize(preferredSize);
		return (THIS) this;
	}

	public THIS preferredWidth(int width) {
		return preferredSize(width, component.getPreferredSize().height);
	}

	public THIS preferredHeight(int height) {
		return preferredSize(component.getPreferredSize().width, height);
	}

	public THIS preferredSize(int width, int height) {
		return preferredSize(new Dimension(width, height));
	}

	public THIS preferredSize(Dimension preferredSize) {
		component.setPreferredSize(preferredSize);
		return (THIS) this;
	}

	public THIS background(Color bg) {
		component.setBackground(bg);
		return (THIS) this;
	}

	public THIS enabled(boolean enabled) {
		component.setEnabled(enabled);
		return (THIS) this;
	}

	public THIS font(Font font) {
		component.setFont(font);
		return (THIS) this;
	}

	public THIS foreground(Color fg) {
		component.setForeground(fg);
		return (THIS) this;
	}

	public THIS visible(boolean visible) {
		component.setVisible(visible);
		return (THIS) this;
	}

	public THIS cursor(Cursor cursor) {
		component.setCursor(cursor);
		return (THIS) this;
	}

	public THIS focusable(boolean focusable) {
		component.setFocusable(focusable);
		return (THIS) this;
	}

	// CHILDREN
	public THIS add(Component component) {
		this.component.add(component);
		return (THIS) this;
	}

	public THIS add(Component component, Object layoutConstraints) {
		this.component.add(component, layoutConstraints);
		return (THIS) this;
	}

	public <CHILD extends JButtonBuilder<JButton, THIS, CHILD>> CHILD button() {
		return (CHILD) childComponent(JButton.class, JButtonBuilder.class);
	}

	public <CHILD extends JButtonBuilder<JRadioButton, THIS, CHILD>> CHILD radioButton() {
		return (CHILD) childComponent(JRadioButton.class, JButtonBuilder.class);
	}

	public <CHILD extends JButtonBuilder<JCheckBox, THIS, CHILD>> CHILD checkbox() {
		return (CHILD) childComponent(JCheckBox.class, JButtonBuilder.class);
	}

	public ButtonGroupBuilder<THIS> buttonGroup() {
		return new ButtonGroupBuilder<>((THIS) this);
	}

	public <CHILD extends JTextFieldBuilder<JTextField, THIS, CHILD>> CHILD textField() {
		return (CHILD) childComponent(JTextField.class, JTextFieldBuilder.class);
	}

	public <CHILD extends JTextAreaBuilder<JTextArea, THIS, CHILD>> CHILD textArea() {
		return (CHILD) childComponent(JTextArea.class, JTextAreaBuilder.class);
	}

	public <CHILD extends JLabelBuilder<JLabel, THIS, CHILD>> CHILD label() {
		return (CHILD) childComponent(JLabel.class, JLabelBuilder.class);
	}

	public THIS label(String text) {
		return label().text(text).end();
	}

	public <CHILD extends JComponentBuilder<JPanel, THIS, CHILD>> CHILD lineAxisPanel() {
		return (CHILD) panel().lineAxisLayout();
	}

	public <CHILD extends JComponentBuilder<JPanel, THIS, CHILD>> CHILD pageAxisPanel() {
		return (CHILD) panel().pageAxisLayout();
	}

	public <E, CHILD extends JComboBoxBuilder<E, JComboBox<E>, THIS, CHILD>> CHILD comboBox(Class<E> elementType) {
		return (CHILD) childComponent(JComboBox.class, JComboBoxBuilder.class);
	}

	public <E, CHILD extends JListBuilder<E, JList<E>, THIS, CHILD>> CHILD list(Class<E> elementType) {
		return (CHILD) childComponent(JList.class, JListBuilder.class);
	}

	public THIS gapWithWidth(int width) {
		return gap(width, 1);
	}

	public THIS gapWithHeight(int height) {
		return gap(1, height);
	}

	public THIS gap(int width, int height) {
		return gap(new Dimension(width, height));
	}

	public THIS gap(Dimension size) {
		return add(Box.createRigidArea(size));
	}

	public <CHILD extends JComponentBuilder<JPanel, THIS, CHILD>> CHILD panel() {
		return (CHILD) childComponent(JPanel.class, JComponentBuilder.class);
	}

	public <CHILD_COMPONENT extends JComponent, CHILD extends JComponentBuilder<CHILD_COMPONENT, THIS, CHILD>> CHILD childComponent(
			Class<CHILD_COMPONENT> componentClass, Class<CHILD> builderClass) {
		try {
			return (CHILD) builderClass.getConstructor(Object.class, JComponent.class).newInstance(this,
					newInstance(componentClass));
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException
				| InvocationTargetException e) {
			throw new Error(e);
		}
	}

	// END AND BUILD
	public PARENT end() {
		onEnd();
		return parent;
	}

	protected void onEnd() {
	}

	public COMPONENT getComponent() {
		return component;
	}

	// UTILITY METHODS
	protected static <T> T newInstance(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException("Must be able to instantiate class via a no-arg constructor", e);
		}
	}
}
