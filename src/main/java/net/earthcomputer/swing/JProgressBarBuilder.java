package net.earthcomputer.swing;

import java.util.Map;

import javax.swing.BoundedRangeModel;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;

@SuppressWarnings("unchecked")
public class JProgressBarBuilder<COMPONENT extends JProgressBar, PARENT, THIS extends JProgressBarBuilder<COMPONENT, PARENT, THIS>>
		extends JComponentBuilder<COMPONENT, PARENT, THIS> {

	protected JProgressBarBuilder(Map<Object, Object> references, PARENT parent, COMPONENT toAddTo) {
		super(references, parent, toAddTo);
	}

	public THIS changeListener(ChangeListener listener) {
		component.addChangeListener(listener);
		return (THIS) this;
	}

	public THIS borderPainted(boolean borderPainted) {
		component.setBorderPainted(borderPainted);
		return (THIS) this;
	}

	public THIS indeterminate(boolean indeterminate) {
		component.setIndeterminate(indeterminate);
		return (THIS) this;
	}

	public THIS maximum(int n) {
		component.setMaximum(n);
		return (THIS) this;
	}

	public THIS minimum(int n) {
		component.setMinimum(n);
		return (THIS) this;
	}

	public THIS model(BoundedRangeModel model) {
		component.setModel(model);
		return (THIS) this;
	}

	public THIS orientation(Orientation orientation) {
		component.setOrientation(orientation.primitiveValue());
		return (THIS) this;
	}
	
	public THIS text(String text) {
		component.setString(text);
		return (THIS) this;
	}
	
	public THIS textPainted(boolean textPainted) {
		component.setStringPainted(textPainted);
		return (THIS) this;
	}
	
	public THIS value(int n) {
		component.setValue(n);
		return (THIS) this;
	}

}
