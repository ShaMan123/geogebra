package org.geogebra.web.web.gui.util;


import org.geogebra.common.awt.GColor;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.plugin.EuclidianStyleConstants;
import org.geogebra.web.html5.gui.util.BasicIcons;
import org.geogebra.web.web.css.GuiResources;
import org.geogebra.web.web.gui.images.StyleBarResources;

import com.google.gwt.resources.client.ImageResource;

public class GeoGebraIconW extends BasicIcons {



	/** creates LineStyle icon
	 * @param dashStyle
	 * @param thickness
	 * @param iconSize
	 * @param fgColor
	 * @param bgColor
	 * @return Canvas with icon drawn
	 */
	public static ImageOrText createLineStyleIcon(int dashStyle) {
		if(dashStyle >= lineStyleIcons.length){
			return new ImageOrText();
		}
		return new ImageOrText(lineStyleIcons[dashStyle]);

    }

	private static StyleBarResources LafIcons = StyleBarResources.INSTANCE;
	private static ImageResource[] pointStyleIcons =  {
		(LafIcons.point_full()),
		(LafIcons.point_cross_diag()),
		(LafIcons.point_empty()),
		(LafIcons.point_cross()),
		(LafIcons.point_diamond()),
		(LafIcons.point_diamond_empty()),
		(LafIcons.point_up()),
		(LafIcons.point_down()),
		(LafIcons.point_right()),
		(LafIcons.point_left())};
	private static ImageResource[] gridStyleIcons =  {
		(LafIcons.stylingbar_empty()),
		(LafIcons.grid()),
		(LafIcons.polar_grid()),
		(LafIcons.isometric_grid())};
	private static ImageResource[] lineStyleIcons = {
 LafIcons.line_solid(),
			LafIcons.line_dashed_long(), LafIcons.line_dashed_short(),
			LafIcons.line_dotted(), LafIcons.line_dash_dot(),
			LafIcons.point_cross_diag() };
	
	private static ImageResource[] fillStyleIcons = { (LafIcons.pattern_filled()), (LafIcons.pattern_hatching()),
			(LafIcons.pattern_dots()), (LafIcons.pattern_cross_hatching()), (LafIcons.pattern_honeycomb()) };

	/**
	 * @param pointStyle
	 *            int
	 * @return {@link ImageOrText}
	 */
	public static ImageOrText createPointStyleIcon(int pointStyle) {
		return new ImageOrText(pointStyleIcons[pointStyle]);
    }
	
	public static ImageOrText createFillStyleIcon(int fillStyle) {
		return new ImageOrText(fillStyleIcons[fillStyle]);
	}
	/**
	 * @param pointStyle
	 *            int
	 * @return {@link ImageOrText}
	 */
	public static ImageOrText createGridStyleIcon(int pointStyle) {
		return new ImageOrText(gridStyleIcons[pointStyle]);
    }
	
	/**
	 * @param alpha
	 *            {@code float}
	 * @param fgColor
	 *            {@link GColor}
	 * @param bgColor
	 *            {@link GColor}
	 * @return {@link ImageOrText}
	 */
	public static ImageOrText createColorSwatchIcon(double alpha,
			GColor fgColor,
			GColor bgColor) {
		ImageOrText ret = new ImageOrText();
		if (fgColor != null) {
			ret.setFgColor(fgColor.deriveWithAlpha((int) (alpha * 255)));
		}
		if (bgColor != null) {
			ret.setBgColor(bgColor.deriveWithAlpha((int) (alpha * 255)));
		}
		return ret;
	}

	/**
	 * 
	 * @param symbol
	 *            {@code String}
	 * @param fgColor
	 *            {@link GColor}
	 * @param bgColor
	 *            {@link GColor}
	 * @return {@link ImageOrText}
	 */
	public static ImageOrText createTextSymbolIcon(String symbol,
	        GColor fgColor, GColor bgColor) {
		ImageOrText ret = new ImageOrText();
		ret.setText(symbol);
		ret.setFgColor(fgColor);
		ret.setBgColor(bgColor);
		return ret;
	}
	
	/**
	 * @return {@link ImageOrText} Empty icon
	 */
	public static ImageOrText createNullSymbolIcon() {
		return new ImageOrText();
	}

	/**
	 * @param id
	 *            {@code int}
	 * @return {@link ImageOrText}
	 */
	public static ImageOrText createDecorAngleIcon(int id) {
		ImageResource url = null;
		switch(id){
			case GeoElement.DECORATION_ANGLE_TWO_ARCS:
				url =  GuiResources.INSTANCE.deco_angle_2lines();
			break;
			case GeoElement.DECORATION_ANGLE_THREE_ARCS:
				url =  GuiResources.INSTANCE.deco_angle_3lines();
			break;
			case GeoElement.DECORATION_ANGLE_ONE_TICK:
				url =  GuiResources.INSTANCE.deco_angle_1stroke();
			break;
			case GeoElement.DECORATION_ANGLE_TWO_TICKS:
				url =  GuiResources.INSTANCE.deco_angle_2strokes();
			break;
			case GeoElement.DECORATION_ANGLE_THREE_TICKS:
				url =  GuiResources.INSTANCE.deco_angle_3strokes();
			break;			
			case GeoElement.DECORATION_ANGLE_ARROW_ANTICLOCKWISE:
				url =  GuiResources.INSTANCE.deco_angle_arrow_up();
			break;
			case GeoElement.DECORATION_ANGLE_ARROW_CLOCKWISE:
				url =  GuiResources.INSTANCE.deco_angle_arrow_down();
			break;
			default:
				url =  GuiResources.INSTANCE.deco_angle_1line();
		}
		return new ImageOrText(url);

	}

	/**
	 * @param id
	 *            {@code int}
	 * @return {@link ImageOrText}
	 */
	public static ImageOrText createDecorSegmentIcon(int id) {
		ImageResource url = null;

		switch (id) {		
		case GeoElement.DECORATION_SEGMENT_ONE_TICK:
			url =  GuiResources.INSTANCE.deco_segment_1stroke();
			break;
		case GeoElement.DECORATION_SEGMENT_TWO_TICKS:
			url =  GuiResources.INSTANCE.deco_segment_2strokes();
			break;
		case GeoElement.DECORATION_SEGMENT_THREE_TICKS:
			url =  GuiResources.INSTANCE.deco_segment_3strokes();
			break;
		case GeoElement.DECORATION_SEGMENT_ONE_ARROW:
			url =  GuiResources.INSTANCE.deco_segment_1arrow();
			break;
		case GeoElement.DECORATION_SEGMENT_TWO_ARROWS:
			url =  GuiResources.INSTANCE.deco_segment_2arrows();
			break;
		case GeoElement.DECORATION_SEGMENT_THREE_ARROWS:
			url =  GuiResources.INSTANCE.deco_segment_3arrows();
			break;
		default:
			url =  GuiResources.INSTANCE.deco_segment_none();
			break;
		}

		return new ImageOrText(url);

    }

	/**
	 * @param id
	 *            {@code int}
	 * @return {@link ImageOrText}
	 */
	public static ImageOrText createAxesStyleIcon(int id, boolean newStyle) {
		ImageResource url = null;

		if (newStyle) {
			switch (id) {
			case EuclidianStyleConstants.AXES_TWO_ARROWS:
				url = StyleBarResources.INSTANCE.axes_2arrows();
				break;
			case EuclidianStyleConstants.AXES_FOUR_ARROWS:
				url = StyleBarResources.INSTANCE.axes_4arrows();
				break;
			case EuclidianStyleConstants.AXES_NO_ARROW:
				url = StyleBarResources.INSTANCE.axes();
				break;
			default:
				url = StyleBarResources.INSTANCE.axes(); // stylingbar_empty()
			}

		} else {
			switch (id) {
			case EuclidianStyleConstants.AXES_LINE_TYPE_ARROW:
				url = GuiResources.INSTANCE.deco_axes_arrow();
				break;
			case EuclidianStyleConstants.AXES_LINE_TYPE_TWO_ARROWS:
				url = GuiResources.INSTANCE.deco_axes_arrows();
				break;
			case EuclidianStyleConstants.AXES_LINE_TYPE_ARROW_FILLED:
				url = GuiResources.INSTANCE.deco_axes_arrow_filled();
				break;
			case EuclidianStyleConstants.AXES_LINE_TYPE_TWO_ARROWS_FILLED:
				url = GuiResources.INSTANCE.deco_axes_arrows_filled();
				break;
			default:
				url = GuiResources.INSTANCE.deco_axes_none();
			}
		}

		return new ImageOrText(url);
	}
}
