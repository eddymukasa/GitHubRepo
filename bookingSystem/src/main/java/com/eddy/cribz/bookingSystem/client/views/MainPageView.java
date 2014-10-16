/**
 * 
 */
package com.eddy.cribz.bookingSystem.client.views;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.eddy.cribz.bookingSystem.client.bookingSystem;
import com.eddy.cribz.bookingSystem.client.data.BookingDataSource;
import com.eddy.cribz.bookingSystem.client.data.SystemAdministrationDataSource;
import com.eddy.cribz.bookingSystem.client.events.MainPageUiHandlers;
import com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter;
import com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu;
import com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar;
import com.eddy.cribz.bookingSystem.client.widgets.Masthead;
import com.eddy.cribz.bookingSystem.client.widgets.NavigationPane;
import com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader;
import com.eddy.cribz.bookingSystem.client.widgets.StatusBar;
import com.eddy.cribz.bookingSystem.model.Permission;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

/**
 * @author Planet Developer 001
 * 
 */
public class MainPageView extends ViewWithUiHandlers<MainPageUiHandlers>
		implements MainPagePresenter.MyView {

	private static final int NORTH_HEIGHT = 85;
	private static final int DEFAULT_MENU_WIDTH = 70;
	private static final String DEFAULT_MARGIN = "0px";

	// Application Menu Widget
	private final ApplicationMenu applicationMenu;
	private final Masthead mastHead;
	private final NavigationPaneHeader navigationPaneHeader;
	private final NavigationPane navigationPane;
	private final StatusBar statusBar;
	private final MainStatusBar mainStatusBar;

	private VLayout panel;
	private HLayout northLayout;
	private HLayout southLayout;
	public static VLayout westLayout;
	private VLayout centerLayout;

	private HLayout HL_PASS_BUTTONS;

	private DynamicForm DF_FORM;

	private PasswordItem passwordText = new PasswordItem("passwordText",
			"Password");
	private PasswordItem confirmPasswordText = new PasswordItem(
			"confirmPasswordText", "Confirm Password");
	private PasswordItem oldPasswordText = new PasswordItem("oldPasswordText",
			"Old Password");

	private final Button saveButton = new Button("Save");
	private final Button clearButton = new Button("Clear");
	private final Button closeButton = new Button("Close");

	private VLayout VL_WINDOW;

	private HLayout HL_BUTTONS;

	@Inject
	public MainPageView(Masthead mastHead, ApplicationMenu applicationMenu,
			NavigationPaneHeader navigationPaneHeader,
			NavigationPane navigationPane, StatusBar statusBar,
			MainStatusBar mainStatusBar) {

		this.mastHead = mastHead;
		this.applicationMenu = applicationMenu;
		this.navigationPaneHeader = navigationPaneHeader;
		this.navigationPane = navigationPane;
		this.statusBar = statusBar;
		this.mainStatusBar = mainStatusBar;

		Window.enableScrolling(false);
		Window.setMargin(DEFAULT_MARGIN);

		panel = new VLayout();
		panel.setWidth100();
		panel.setHeight100();

		centerLayout = new VLayout();
		centerLayout.setWidth100();
		centerLayout.setHeight100();
		centerLayout.setBackgroundColor("white");
		// initialise the North layout container
		northLayout = new HLayout();
		northLayout.setHeight(NORTH_HEIGHT);

		initApplicationMenu();

		// initialise the nested layout container
		VLayout vLayout = new VLayout();
		vLayout.addMember(this.mastHead);
		vLayout.addMember(this.applicationMenu);

		// add the nested layout container to the North layout container
		northLayout.addMember(vLayout);

		// initialise the West layout container
		westLayout = this.navigationPane;
		// westLayout.setVisible(true);

		// centerLayout
		// initialise the South layout container
		southLayout = new HLayout();
		southLayout.setMembers(westLayout, centerLayout);

		DF_FORM = new DynamicForm();
		DF_FORM.setWidth100();
		DF_FORM.setNumCols(2);
		DF_FORM.setWrapItemTitles(false);

		DF_FORM.setItems(oldPasswordText, passwordText, confirmPasswordText);

		for (FormItem FI : DF_FORM.getFields()) {
			FI.setWidth(200);
			FI.setCellHeight(47);
		}

		HL_PASS_BUTTONS = new HLayout();
		HL_PASS_BUTTONS.setWidth100();
		HL_PASS_BUTTONS.setMembersMargin(2);
		HL_PASS_BUTTONS.setMembers(saveButton, clearButton, closeButton);

		VL_WINDOW = new VLayout();
		VL_WINDOW.setWidth100();
		VL_WINDOW.setHeight100();
		VL_WINDOW.setBorder("1px solid black");
		VL_WINDOW.setPadding(2);

		HL_BUTTONS = new HLayout();
		HL_BUTTONS.setWidth100();
		HL_BUTTONS.setHeight("*");
		HL_BUTTONS.setBorder("1px solid black");
		HL_BUTTONS.setPadding(2);

		/*
		 * this.setAutoCenter(true); this.setWidth("40%");
		 * this.setHeight("45%"); this.setIsModal(true);
		 * this.addItem(VL_WINDOW); this.setTitle("Change Password");
		 */

		VL_WINDOW.addMember(DF_FORM);
		VL_WINDOW.addMember(HL_PASS_BUTTONS);

		// add the North and South layout containers to the main layout
		// container
		panel.addMember(northLayout);
		panel.addMember(southLayout);
		panel.addMember(mainStatusBar);

		// initNavigationPane();

		// navigationPane.getSectionStack().
		// bindCustomUiHandlers();
	}

	private static final String NAME = "name";

	protected void bindCustomUiHandlers() {

		navigationPane.addRecordClickHandler(bookingSystem.getConstants()
				.SystemAdministrationStackSectionName(),
				new RecordClickHandler() {
					public void onRecordClick(RecordClickEvent event) {
						onRecordClicked(event);
					}
				});
	}

	private void onRecordClicked(RecordClickEvent event) {
		Record record = event.getRecord();
		String name = record.getAttributeAsString(NAME);

		Log.debug("onRecordClicked() - " + name);

		if (getUiHandlers() != null) {
			getUiHandlers().onNavigationPaneSectionClicked(name);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gwtplatform.mvp.client.View#asWidget()
	 */
	public Widget asWidget() {
		// TODO Auto-generated method stub
		// return vp;
		return panel;
	}

	public void setInSlot(Object slot, Widget content) {
		if (slot == MainPagePresenter.TYPE_SetContextAreaContent) {

			centerLayout.setMembers((VLayout) content);
		} else {
			super.setInSlot(slot, content);
		}
	}

	private void initApplicationMenu() {
		/*applicationMenu.addMenu(procnet.getConstants().FileMenuName(),
				DEFAULT_MENU_WIDTH, bookingSystem.getConstants()
						.FileMenuItemNames(), null);
		applicationMenu.addMenu(procnet.getConstants().ActionsMenuName(),
				DEFAULT_MENU_WIDTH, bookingSystem.getConstants()
						.ActionsMenuItemNames(), null);
		applicationMenu.addMenu(procnet.getConstants().ViewsMenuName(),
				DEFAULT_MENU_WIDTH, bookingSystem.getConstants()
						.ViewsMenuItemNames(), new ClickHandler() {

					public void onClick(MenuItemClickEvent event) {

						Log.info("View Menu... " + event.getItem().getTitle());

						String applicationName = event.getItem().getTitle();

						if (applicationName.contains("Show Sections")) {

							westLayout.setVisible(true);
						} else if (applicationName.contains("Hide Sections")) {

							westLayout.setVisible(false);
						}
					}

				});
		applicationMenu.addMenu(procnet.getConstants().ModulesMenuName(),
				DEFAULT_MENU_WIDTH, bookingSystem.getConstants()
						.ModulesMenuItemNames(), null);
		applicationMenu.addMenu(procnet.getConstants().ToolsMenuName(),
				DEFAULT_MENU_WIDTH, bookingSystem.getConstants()
						.ToolsMenuItemNames(), null);
		applicationMenu.addMenu(procnet.getConstants().SecurityMenuName(),
				DEFAULT_MENU_WIDTH, bookingSystem.getConstants()
						.SecurityMenuItemNames(), new ClickHandler() {

					public void onClick(MenuItemClickEvent event) {

						GWT.log("Application Menu Clicked: ", null);
						String applicationName = event.getItem().getTitle();

						// SC.say(""+applicationName);
						if (applicationName.contains("Log Out")) {
							bookingSystem.logout();
						} else if (applicationName.contains("Change Password")) {
							GWT.log("Change Password: ", null);

							if (getUiHandlers() != null) {

								// getUiHandlers().onChangedUserPasswordClicked();
							}
						}

					}

				});
		applicationMenu.addMenu(bookingSystem.getConstants().HelpMenuName(),
				DEFAULT_MENU_WIDTH, bookingSystem.getConstants()
						.HelpMenuItemNames(), null);
	*/}

	public void initNavigationPane() {
		/*
		 * navigationPane.addSection(procnet.getConstants().SalesStackSectionName
		 * (), SalesDataSource.getInstance());//SalesNpsDataSource.getInstance()
		 * navigationPane
		 * .addSection(procnet.getConstants().SettingsStackSectionName(),
		 * null);// SettingsNpsDataSource.getInstance()
		 * navigationPane.addSection
		 * (procnet.getConstants().ResourceCentreStackSectionName(),
		 * null);//ResourceCentreNpsDataSource.getInstance()
		 */

		
				
		navigationPane.addSection(bookingSystem.getConstants()
				.BookingsStackSectionName(), BookingDataSource.getInstance());
		
		navigationPane.addSection(bookingSystem.getConstants()
				.SystemAdministrationStackSectionName(),
				SystemAdministrationDataSource.getInstance());
		if (getUiHandlers() != null) {
			getUiHandlers().onAdministrationSectionClickHandler();
		}
		

		// navigationPane.addSection(procnet.getConstants().TipsStackSectionName(),
		// null);
		/*
		 * if(getUiHandlers() !=null){
		 * getUiHandlers().onAdministrationSectionClickHandler(); }
		 */

	}

	public NavigationPaneHeader getNavigationPaneHeader() {
		// TODO Auto-generated method stub
		return navigationPaneHeader;
	}

	public NavigationPane getNavigationPane() {
		// TODO Auto-generated method stub
		return navigationPane;
	}

	public void setGetLoggedInUserError(String serverErrorResponse) {

		Log.info("setGetLoggedInUserError");

		SC.warn(serverErrorResponse);
	}

	public Masthead getMastHead() {

		return mastHead;
	}

	public ApplicationMenu getApplicationMenu() {

		return applicationMenu;
	}

	public VLayout getWestLayout() {

		return westLayout;
	}

	public void setUserPermissions(List<Permission> permissions) {
		// TODO Auto-generated method stub
		
	}

	/*public void setUserPermissions(List<Permission> permissions) {

		Log.info("Attaching User Permissions");

		for (Permission permission : permissions) {

			if (permission.getName().contentEquals(
					PermissionConstants.PERM_DISPLAY_REQUISTION)) {

				Log.info("Permission: " + permission.getName());

				navigationPane.addSection(Procnet.getConstants()
						.RequisitionsStackSectionName(), RequisitionsDataSource
						.getInstance());
				if (getUiHandlers() != null) {
					getUiHandlers().onRequisitionSectionClickHandler();
				}

			} else if (permission.getName().contentEquals(
					PermissionConstants.PERM_DISPLAY_BUDGET)) {

				Log.info("Permission: " + permission.getName());

				navigationPane.addSection(Procnet.getConstants()
						.BudgetStackSectionName(), BudgetDataSource
						.getInstance());
				if (getUiHandlers() != null) {
					getUiHandlers().onBudgetSectionClickHandler();
				}

			} else if (permission.getName().contentEquals(
					PermissionConstants.PERM_DISPLAY_PLANNING)) {

				Log.info("Permission: "+permission.getName());
				
				navigationPane
						.addSection(Procnet.getConstants()
								.PlansStackSectionName(), PlansDataSource
								.getInstance());
				if (getUiHandlers() != null) {
					getUiHandlers().onPlanSectionClickHandler();
				}

			} else if (permission.getName().contentEquals(
					PermissionConstants.PERM_VIEW_ADMINISTRATION)) {

				Log.info("Permission: "+permission.getName());
				
				navigationPane.addSection(procnet.getConstants()
						.SystemAdministrationStackSectionName(),
						SystemAdministrationDataSource.getInstance());
				if (getUiHandlers() != null) {
					getUiHandlers().onAdministrationSectionClickHandler();
				}

			} else {

			}

		}
	}*/
	
	

}
