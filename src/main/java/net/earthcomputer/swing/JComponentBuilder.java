package net.earthcomputer.swing;

import java.beans.VetoableChangeListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;

@SuppressWarnings("unchecked")
public class JComponentBuilder<COMPONENT extends JComponent, PARENT, THIS extends JComponentBuilder<COMPONENT, PARENT, THIS>>
		extends ContainerBuilder<COMPONENT, PARENT, THIS>implements IBorderBuilder<THIS> {

	// FIELDS
	protected Object layoutConstraints;

	// CREATION
	public static <PARENT, THIS extends JComponentBuilder<JPanel, PARENT, THIS>> THIS create() {
		return (create(new HashMap<>()));
	}
	
	public static <PARENT, THIS extends JComponentBuilder<JPanel, PARENT, THIS>> THIS create(
			Map<Object, Object> references) {
		return create(new JPanel(), references);
	}

	public static <COMPONENT extends JComponent, PARENT, THIS extends JComponentBuilder<COMPONENT, PARENT, THIS>> THIS create(
			Class<COMPONENT> componentClass, Map<Object, Object> references) {
		return create(newInstance(componentClass), references);
	}

	public static <COMPONENT extends JComponent, PARENT, THIS extends JComponentBuilder<COMPONENT, PARENT, THIS>> THIS create(
			COMPONENT component, Map<Object, Object> references) {
		return (THIS) new JComponentBuilder<>(references, null, component);
	}

	protected JComponentBuilder(Map<Object, Object> references, PARENT parent, COMPONENT toAddTo) {
		super(references, parent, toAddTo);
	}

	// BORDERS
	public THIS border(Border border) {
		component.setBorder(border);
		return (THIS) this;
	}

	// PROPERTIES
	public THIS layoutConstraints(Object constraints) {
		this.layoutConstraints = constraints;
		return (THIS) this;
	}

	public THIS ancestorListener(AncestorListener listener) {
		component.addAncestorListener(listener);
		return (THIS) this;
	}

	public THIS vetoableChangeListener(VetoableChangeListener listener) {
		component.addVetoableChangeListener(listener);
		return (THIS) this;
	}

	public THIS actionParent(ActionMap parent) {
		component.getActionMap().setParent(parent);
		return (THIS) this;
	}

	public THIS action(Object key, Action action) {
		component.getActionMap().put(key, action);
		return (THIS) this;
	}

	public THIS inputParent(InputMap parent) {
		component.getInputMap().setParent(parent);
		return (THIS) this;
	}

	public THIS input(int keyCode, Object actionMapKey) {
		return input(keyCode, 0, actionMapKey);
	}

	public THIS input(int keyCode, int modifiers, Object actionMapKey) {
		return input(keyCode, modifiers, false, actionMapKey);
	}

	public THIS input(int keyCode, int modifiers, boolean onKeyRelease, Object actionMapKey) {
		return input(KeyStroke.getKeyStroke(keyCode, modifiers, onKeyRelease), actionMapKey);
	}

	public THIS input(KeyStroke keyStroke, Object actionMapKey) {
		component.getInputMap().put(keyStroke, actionMapKey);
		return (THIS) this;
	}

	public THIS inputAction(int keyCode, Action action) {
		return inputAction(keyCode, 0, action);
	}

	public THIS inputAction(int keyCode, int modifiers, Action action) {
		return inputAction(keyCode, modifiers, false, action);
	}

	public THIS inputAction(int keyCode, int modifiers, boolean onKeyRelease, Action action) {
		return inputAction(KeyStroke.getKeyStroke(keyCode, modifiers, onKeyRelease), action);
	}

	public THIS inputAction(KeyStroke keyStroke, Action action) {
		Object actionMapKey = new Object();
		return input(keyStroke, actionMapKey).action(actionMapKey, action);
	}

	public THIS alignmentX(float alignmentX) {
		component.setAlignmentX(alignmentX);
		return (THIS) this;
	}

	public THIS alignmentY(float alignmentY) {
		component.setAlignmentY(alignmentY);
		return (THIS) this;
	}

	public THIS autoscrolls(boolean autoscrolls) {
		component.setAutoscrolls(autoscrolls);
		return (THIS) this;
	}

	public THIS opaque(boolean opaque) {
		component.setOpaque(opaque);
		return (THIS) this;
	}

	public THIS tooltip(String text) {
		component.setToolTipText(text);
		return (THIS) this;
	}

	// END
	@Override
	protected void onEnd() {
		if (parent instanceof JComponentBuilder) {
			((JComponentBuilder<?, ?, ?>) parent).add(component, layoutConstraints);
		}
	}

}
