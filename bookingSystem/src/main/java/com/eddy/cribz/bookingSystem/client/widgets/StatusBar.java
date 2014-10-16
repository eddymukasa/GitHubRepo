package com.eddy.cribz.bookingSystem.client.widgets;


import com.eddy.cribz.bookingSystem.client.bookingSystem;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;

public class StatusBar extends HLayout {
	

	  private static final String STATUSBAR_HEIGHT = "23px";

	  private static final int BUTTON_SIZE = 12; // 9
	  private static final int LABEL_WIDTH = 50;

	  private final Label selectedLabel;
	  private final ImgButton resultSetFirstButton;
	  private final ImgButton resultSetPreviousButton;
	  private final Label pageNumberLabel;
	  private final ImgButton resultSetNextButton;

	  public StatusBar() {
	    super();

	    // initialise the StatusBar layout container
	    this.setStyleName("crm-StatusBar");
	    this.setHeight(STATUSBAR_HEIGHT);

	    // initialise the Selected label
	    selectedLabel = new Label();
	    selectedLabel.setStyleName("crm-StatusBar-Label");
	    selectedLabel.setContents(bookingSystem.getMessages().selected(0, 50));
	    selectedLabel.setAlign(Alignment.LEFT);
	    selectedLabel.setOverflow(Overflow.HIDDEN);

	    // initialise the Result Set First button
	    resultSetFirstButton = new ImgButton();
	    resultSetFirstButton.setShowRollOver(false);
	    resultSetFirstButton.setShowDisabled(true);
	    resultSetFirstButton.setShowDown(false);
	    resultSetFirstButton.setSize(BUTTON_SIZE);
	    resultSetFirstButton.setLayoutAlign(VerticalAlignment.CENTER);
	    resultSetFirstButton.setSrc("statusbar/resultsetfirst.png");
	    // requires resultsetfirst_Disabled.png
	    resultSetFirstButton.disable();
	    resultSetFirstButton.setAlign(Alignment.RIGHT);

	    // initialise the Result Set Previous button
	    resultSetPreviousButton = new ImgButton();
	    resultSetPreviousButton.setShowRollOver(false);
	    resultSetPreviousButton.setShowDisabled(true);
	    resultSetPreviousButton.setShowDown(false);
	    resultSetPreviousButton.setSize(BUTTON_SIZE);
	    resultSetPreviousButton.setLayoutAlign(VerticalAlignment.CENTER);
	    resultSetPreviousButton.setSrc("statusbar/resultsetprevious.png");
	    // requires resultsetprevious_Disabled.png
	    resultSetPreviousButton.disable();
	    resultSetPreviousButton.setAlign(Alignment.RIGHT);

	    // initialise the Page Number label
	    pageNumberLabel = new Label();
	    pageNumberLabel.setStyleName("crm-StatusBar-Label");
	    pageNumberLabel.setContents(bookingSystem.getMessages().page(1));

	    // TO DO: fix this
	    pageNumberLabel.setWidth(LABEL_WIDTH);
	    // pageNumberLabel.setWidth("*");
	    pageNumberLabel.setAlign(Alignment.RIGHT);
	    pageNumberLabel.setOverflow(Overflow.HIDDEN);

	    // initialise the Result Set Next button
	    resultSetNextButton = new ImgButton();
	    resultSetNextButton.setShowRollOver(false);
	    resultSetNextButton.setShowDisabled(true);
	    resultSetNextButton.setShowDown(false);
	    resultSetNextButton.setSize(BUTTON_SIZE);
	    resultSetNextButton.setLayoutAlign(VerticalAlignment.CENTER);
	    resultSetNextButton.setSrc("statusbar/resultsetnext.png");
	    // requires resultsetnext_Disabled.png
	    resultSetNextButton.disable();
	    resultSetNextButton.setAlign(Alignment.RIGHT);

	    // add the widgets to the StatusBar layout container
	   // this.addMember(selectedLabel);
	    // force right alignment
	    Label alignRight = new Label("&nbsp;");
	    alignRight.setAlign(Alignment.RIGHT);
	    alignRight.setOverflow(Overflow.HIDDEN);
	    this.addMember(alignRight);
	    this.addMember(resultSetFirstButton);
	    this.addMember(resultSetPreviousButton);
	    this.addMember(pageNumberLabel);
	    this.addMember(resultSetNextButton);
	    // add some padding
	    LayoutSpacer paddingRight = new LayoutSpacer();
	    paddingRight.setWidth(8);
	    this.addMember(paddingRight);
	  }

	  public Label getSelectedLabel() {
	    return selectedLabel;
	  }

	  public ImgButton getResultSetFirstButton() {
	    return resultSetFirstButton;
	  }

	  public ImgButton getResultSetPreviousButton() {
	    return resultSetPreviousButton;
	  }

	  public Label getPageNumberLabel() {
	    return pageNumberLabel;
	  }

	  public ImgButton getResultSetNextButton() {
	    return resultSetNextButton;
	  }
}
