package org.geogebra.web.full.gui.layout;

import org.geogebra.web.full.css.MaterialDesignResources;
import org.geogebra.web.full.gui.toolbarpanel.MenuToggleButton;
import org.geogebra.web.html5.gui.util.StandardButton;
import org.geogebra.web.html5.main.AppW;
import org.geogebra.web.html5.util.Dom;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ScrollPanel;

/**
 * Adds the scientific header to AV panel.
 */
public final class ScientificDockPanelDecorator implements DockPanelDecorator {
	private FlowPanel header;
	private AppW app;
	private ScrollPanel algebraPanel;

	@Override
	public Panel decorate(ScrollPanel algebrap, AppW appW) {
		this.app = appW;
		this.algebraPanel = algebrap;
		FlowPanel vp = new FlowPanel();
		vp.setHeight("100%");
		header = new FlowPanel();

		addMenuButton();
		addSettngsButton();

		header.setStyleName("smallScreenHeaderScientific");
		vp.add(header);
		vp.add(algebrap);
		return vp;
	}

	private void addMenuButton() {
		MenuToggleButton menuBtn = new MenuToggleButton(app);
		menuBtn.addStyleName("flatButtonHeader");
		menuBtn.addStyleName("menuBtnScientific");
		header.add(menuBtn);
	}

	private void addSettngsButton() {
		StandardButton settingsButton = new StandardButton(MaterialDesignResources.INSTANCE.gear(),
				null, 24, app);
		settingsButton.setTitle(app.getLocalization().getMenu("Settings"));
		settingsButton.addStyleName("flatButtonHeader");
		settingsButton.addStyleName("settingsBtnScientific");
		header.add(settingsButton);
	}

	@Override
	public void onResize() {
		boolean smallScreen = AppW.smallScreen(app.getArticleElement());
		header.setVisible(smallScreen);
		Dom.toggleClass(algebraPanel, "algebraPanelScientificWithHeader",
				smallScreen);
	}
}