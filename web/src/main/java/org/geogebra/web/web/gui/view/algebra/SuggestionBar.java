package org.geogebra.web.web.gui.view.algebra;

import org.geogebra.common.euclidian.event.PointerEventType;
import org.geogebra.common.gui.view.algebra.Suggestion;
import org.geogebra.common.gui.view.algebra.SuggestionSlider;
import org.geogebra.common.kernel.kernelND.GeoElementND;
import org.geogebra.common.main.Localization;
import org.geogebra.common.util.AsyncOperation;
import org.geogebra.web.html5.gui.util.ClickStartHandler;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * Suggestion bar for each AV item
 * 
 * @author Zbynek
 */
public class SuggestionBar extends FlowPanel {
	private Suggestion suggestion;
	private Label label;

	/**
	 * @param loc
	 *            localization
	 * @param parentItem
	 *            parent tree item
	 */
	public SuggestionBar(final RadioTreeItem parentItem) {
		addStyleName("suggestionBar");
		addStyleName("animating");
		label = new Label();
		label.addStyleName("suggestionButton");
		add(label);
		ClickStartHandler.init(label, new ClickStartHandler() {

			@Override
			public void onClickStart(int x, int y, PointerEventType type) {
				AsyncOperation<GeoElementND> run = new AsyncOperation<GeoElementND>() {
					@Override
					public void callback(GeoElementND geo) {
						suggestion.execute(geo);
					}
				};
				if (suggestion instanceof SuggestionSlider) {
					run.callback(null);
					parentItem.setAutoSliders(true);
					parentItem.onEnter(true);
					parentItem.setAutoSliders(false);
					return;
				}
				parentItem.runAfterGeoCreated(run);
				parentItem.onEnter(true);

			}
		});

	}

	/**
	 * @param suggestion
	 *            suggestion
	 */
	public void setSuggestion(Suggestion suggestion, Localization loc) {
		this.suggestion = suggestion;
		label.setText(suggestion.getCommand(loc));
	}

}
