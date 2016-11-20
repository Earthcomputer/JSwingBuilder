package net.earthcomputer.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.border.Border;

public interface IBorderBuilder<THIS extends IBorderBuilder<THIS>> {

	THIS border(Border border);

	default THIS bevelBorder(BevelBorderType type) {
		return border(BorderFactory.createBevelBorder(type.primitiveValue()));
	}

	default THIS bevelBorder(BevelBorderType type, Color highlight, Color shadow) {
		return border(BorderFactory.createBevelBorder(type.primitiveValue(), highlight, shadow));
	}

	default THIS bevelBorder(BevelBorderType type, Color highlightOuter, Color highlightInner, Color shadowOuter,
			Color shadowInner) {
		return border(BorderFactory.createBevelBorder(type.primitiveValue(), highlightOuter, highlightInner,
				shadowOuter, shadowInner));
	}

	@SuppressWarnings("unchecked")
	default CompoundBorderBuilder<THIS> compoundBorder() {
		return new CompoundBorderBuilder<>((THIS) this);
	}

	default THIS dashedBorder(Paint paint) {
		return border(BorderFactory.createDashedBorder(paint));
	}

	default THIS dashedBorder(Paint paint, float length, float spacing) {
		return border(BorderFactory.createDashedBorder(paint, length, spacing));
	}

	default THIS dashedBorder(Paint paint, float thickness, float length, float spacing, boolean rounded) {
		return border(BorderFactory.createDashedBorder(paint, thickness, length, spacing, rounded));
	}

	default THIS emptyBorder() {
		return border(BorderFactory.createEmptyBorder());
	}

	default THIS emptyBorder(int top, int left, int bottom, int right) {
		return border(BorderFactory.createEmptyBorder(top, left, bottom, right));
	}

	default THIS etchedBorder() {
		return border(BorderFactory.createEtchedBorder());
	}

	default THIS etchedBorder(Color highlight, Color shadow) {
		return border(BorderFactory.createEtchedBorder(highlight, shadow));
	}

	default THIS etchedBorder(EtchedBorderType type) {
		return border(BorderFactory.createEtchedBorder(type.primitiveValue()));
	}

	default THIS etchedBorder(EtchedBorderType type, Color highlight, Color shadow) {
		return border(BorderFactory.createEtchedBorder(type.primitiveValue(), highlight, shadow));
	}

	default THIS lineBorder(Color color) {
		return border(BorderFactory.createLineBorder(color));
	}

	default THIS lineBorder(Color color, int thickness) {
		return border(BorderFactory.createLineBorder(color, thickness));
	}

	default THIS lineBorder(Color color, int thickness, boolean rounded) {
		return border(BorderFactory.createLineBorder(color, thickness, rounded));
	}

	default THIS loweredBevelBorder() {
		return border(BorderFactory.createLoweredBevelBorder());
	}

	default THIS loweredSoftBevelBorder() {
		return border(BorderFactory.createRaisedSoftBevelBorder());
	}

	default THIS matteBorder(int top, int left, int bottom, int right, Color color) {
		return border(BorderFactory.createMatteBorder(top, left, bottom, right, color));
	}

	default THIS matteBorder(int top, int left, int bottom, int right, Icon tileIcon) {
		return border(BorderFactory.createMatteBorder(top, left, bottom, right, tileIcon));
	}

	default THIS raisedBevelBorder() {
		return border(BorderFactory.createRaisedBevelBorder());
	}

	default THIS raisedSoftBevelBorder() {
		return border(BorderFactory.createRaisedSoftBevelBorder());
	}

	default THIS softBevelBorder(BevelBorderType type) {
		return border(BorderFactory.createSoftBevelBorder(type.primitiveValue()));
	}

	default THIS softBevelBorder(BevelBorderType type, Color highlight, Color shadow) {
		return border(BorderFactory.createSoftBevelBorder(type.primitiveValue(), highlight, shadow));
	}

	default THIS softBevelBorder(BevelBorderType type, Color highlightOuter, Color highlightInner, Color shadowOuter,
			Color shadowInner) {
		return border(BorderFactory.createSoftBevelBorder(type.primitiveValue(), highlightOuter, highlightInner,
				shadowOuter, shadowInner));
	}

	default THIS strokeBorder(BasicStroke stroke) {
		return border(BorderFactory.createStrokeBorder(stroke));
	}

	default THIS strokeBorder(BasicStroke stroke, Paint paint) {
		return border(BorderFactory.createStrokeBorder(stroke, paint));
	}

	@SuppressWarnings("unchecked")
	default TitledBorderBuilder<THIS> titledBorder() {
		return new TitledBorderBuilder<>((THIS) this);
	}

}
