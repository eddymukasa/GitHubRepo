package com.eddy.cribz.bookingSystem.client.presenters;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.eddy.cribz.bookingSystem.client.bookingSystem;
import com.eddy.cribz.bookingSystem.client.events.MainPageUiHandlers;
import com.eddy.cribz.bookingSystem.client.utils.NameTokens;
import com.eddy.cribz.bookingSystem.client.widgets.Masthead;
import com.eddy.cribz.bookingSystem.client.widgets.NavigationPane;
import com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader;
import com.eddy.cribz.bookingSystem.model.Permission;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;


/**
 * @author Planet Developer 001
 *
 */
public class MainPagePresenter extends Presenter<MainPagePresenter.MyView, MainPagePresenter.MyProxy>
implements MainPageUiHandlers{

	final PlaceManager placeManager;
	final DispatchAsync dispatcher;
	
	private static NavigationPaneHeader navigationPaneHeader;  
	  private static NavigationPane navigationPane;  
	  
	  public static String organization = "NSSF";
	//  public static FinancialYear activeFinancialYear = new FinancialYear();
	  /**
		 * @author Planet Developer 001
		 *
		 */
	  @ProxyStandard
	  @NameToken(NameTokens.mainPage)
		public interface MyProxy extends Proxy<MainPagePresenter>, Place{

		}
	  

		/**
		 * @author Planet Developer 001
		 *
		 */
		public interface MyView extends View, HasUiHandlers<MainPageUiHandlers>{

	    NavigationPaneHeader getNavigationPaneHeader();
	    NavigationPane getNavigationPane();
	 //   void setLoggedInUser(User user);
	    void setGetLoggedInUserError(String serverErrorResponse);
	    Masthead getMastHead();
	  //  ApplicationMenu getApplicationMenu();
	    void setUserPermissions(List<Permission> permissions);
	    void initNavigationPane();
	    
	    VLayout getWestLayout();
	    
		}
		
		/**
		   * Use this in leaf presenters, inside their {@link #revealInParent} method.
		   */
		 @ContentSlot
		  public static final Type<RevealContentHandler<?>> TYPE_SetContextAreaContent = new Type<RevealContentHandler<?>>();
	/**
	 * @param eventBus
	 * @param view
	 * @param proxy
	 */
	@Inject
	public MainPagePresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager,DispatchAsync dispatcher) {
		super(eventBus, view, proxy);
		
		getView().setUiHandlers(this);
		
		this.placeManager=placeManager;
		this.dispatcher=dispatcher;
		
		MainPagePresenter.navigationPaneHeader = view.getNavigationPaneHeader();
		MainPagePresenter.navigationPane = view.getNavigationPane();
		
	}
	
	protected void onBind(){
		super.onBind();

		Log.info("onBind()... ");

		
		// reveal the first nested Presenter
		PlaceRequest placeRequest = new PlaceRequest(NameTokens.mainPage);
		placeManager.revealPlace(placeRequest);
		 // getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(NameTokens.tasks);
		
		getView().getWestLayout().setVisible(false);
		
	//	getView().setUserPermissions(null);
		getView().initNavigationPane();
		//onGetLoggedInUser();
		//getActiveFinancialYear();
	}

	protected void onReveal(){
		super.onReveal();
		
		Log.info("onReveal()");
	//	onGetLoggedInUser();
		//getActiveFinancialYear();
	}
    
	public void onReset(){
		super.onReset();
	Log.info("onReset()");
	
	//onGetLoggedInUser();
	//getActiveFinancialYear();
	}
	
	/* (non-Javadoc)
	 * @see com.gwtplatform.mvp.client.Presenter#revealInParent()
	 */
	@Override
	protected void revealInParent() {
		
		RevealRootContentEvent.fire(this, this);
	}
	
	  public void onNavigationPaneSectionHeaderClicked(String name) {
		    if (name.length() != 0) { 
		      PlaceRequest placeRequest = new PlaceRequest(name); 
		      placeManager.revealPlace(placeRequest); 
		    }
		  }
		  
		  public void onNavigationPaneSectionClicked(String name) {
		    if (name.length() != 0) { 
		      PlaceRequest placeRequest = new PlaceRequest(name); 
		      placeManager.revealPlace(placeRequest); 
		    }
		  }
		  
		  public static NavigationPaneHeader getNavigationPaneHeader() {
		    return navigationPaneHeader;
		  }   
		  
		  public static NavigationPane getNavigationPane() {
		    return navigationPane;
		  } 
		  
		  public class NavigationPaneClickHandler implements RecordClickHandler {
			  	    public void onRecordClick(RecordClickEvent event) {
			  	       
			  	    	Log.info("Navigation Pane");
			  	      Record record = event.getRecord(); 
			  	      String name = record.getAttributeAsString("name");
			  	       
			  	      Log.info("onRecordClick() - " + name);
			  	   /*    
			  	    if(name.contentEquals(NameTokens.users)){

				  		 Log.info("Section: "+NameTokens.users); */

				  	    	/*   for(Permission permission: permissions){

						  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
			*/
						  	      PlaceRequest myRequest = new PlaceRequest(name);
						  	       
						  	      placeManager.revealPlace(myRequest);
	
						  	    	 /* }
						  	    	  else{
						  	
						  	    	  }*/
						  	  //    }
				  	     // }
			  	    
			  	/*      // Check for User Permission to View Section
			  	    if(name.contentEquals(NameTokens.planPeriod)){
			  	    	  
			  	    	Log.info("Section "+NameTokens.planPeriod);

			  	      for(Permission permission: permissions){

			  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_PLANNINGPERIOD)){

			  	      PlaceRequest myRequest = new PlaceRequest(name);
			  	 //   myRequest.with("task", "VIEW PLAN");
			  	    
			  	      placeManager.revealPlace(myRequest);
			  	       
			  	     // getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);// Pane Header Removed
			  	 //   getView().getWestLayout().setVisible(false);

			  	    	  }// End of if
			  	    	  else{
			  	    		  
			  	    		// SC.warn("Access Denied");
			  	    	  }
			  	      }// End of For
			  	      
			  	      }
			  	      
			  	      else if(name.contentEquals(NameTokens.inputDepartmentPlans)){
			  	    	  
			  	    	// System.out.println("Section: "+NameTokens.inputDepartmentPlans);
			  	    	Log.info(NameTokens.inputDepartmentPlans);
			  	    	
			  	      for(Permission permission: permissions){

			  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_PLAN)){

			  	      PlaceRequest myRequest = new PlaceRequest(name);

			  	      placeManager.revealPlace(myRequest);
			  	       
			  	   //   getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);// Pane Header Removed
			  	  //  getView().getWestLayout().setVisible(false);

			  	    	  }// End of if
			  	    	  else{
			  	    		  
			  	    		// SC.warn("Access Denied");
			  	    	  }
			  	      }// End of For
			  	      
			  	      }
			      
			      else if(name.contentEquals(NameTokens.departmentPlans)){

			    	  Log.info("Section: "+NameTokens.departmentPlans);
			    	  
		  	    	   for(Permission permission: permissions){

				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_DEPARTMENTALPLAN)){

				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	    myRequest.with("task", "VIEW PLANS");
				  	      placeManager.revealPlace(myRequest);
				  	    //  getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				 // 	    getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    		//  SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
		  	      
			      
			  	      else if(name.contentEquals(NameTokens.directoratePlan)){

			  	    	Log.info("Section: "+NameTokens.directoratePlan);
			  	    	
			  	    	   for(Permission permission: permissions){

					  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_DIRECTORATEPLAN)){

					  	      PlaceRequest myRequest = new PlaceRequest(name);
					  	       
					  	      placeManager.revealPlace(myRequest);
					  	       
					  	     // getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
					  	  //  getView().getWestLayout().setVisible(false);
					  	    	  }// End of if
					  	    	  else {
					  	    		  
					  	    	//	 SC.warn("Access Denied");
					  	    	  }
					  	      }
			  	      }
			  	      
			  	      else if(name.contentEquals(NameTokens.consolidatedPlan)){

			  	    	Log.info("Section: "+NameTokens.consolidatedPlan);
			  	    	
			  	    	   for(Permission permission: permissions){
	
					  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_CONSOLIDATEDPLAN)){

					  	      PlaceRequest myRequest = new PlaceRequest(name);
					  	       
					  	      placeManager.revealPlace(myRequest);
					  	       
					  	     // getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
					  	   // getView().getWestLayout().setVisible(false);
					  	    	  }// End of if
					  	    	  else{
					  	    		  
					  	    		// SC.warn("Access Denied");
					  	    	  }
					  	      }
			  	      }
			  	    else if(name.contentEquals(NameTokens.departmentalAllocations)){
			  	    	  
			  	  	Log.info("Section: "+NameTokens.departmentalAllocations);

			  	    	   for(Permission permission: permissions){

					  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_BUDGETALLOCATIONS)){
	
					  	      PlaceRequest myRequest = new PlaceRequest(name);
					  	       
					  	      placeManager.revealPlace(myRequest);
					  	       
					  	//      getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
					  	  //  getView().getWestLayout().setVisible(false);
					  	    	  }// End of if
					  	    	  else{
					  	    		  
					  	    	//	 SC.warn("Access Denied");
					  	    	  }
					  	      }
			  	      }
			  	  else if(name.contentEquals(NameTokens.budgets)){
		  	    	  
			  		Log.info("Section: "+NameTokens.budgets);

		  	    	   for(Permission permission: permissions){

				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_BUDGET)){
	
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	   //   getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	 //   getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
			      
			  	 else if(name.contentEquals(NameTokens.users)){

			  		 Log.info("Section: "+NameTokens.users); 

			  	    	   for(Permission permission: permissions){

					  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
		
					  	      PlaceRequest myRequest = new PlaceRequest(name);
					  	       
					  	      placeManager.revealPlace(myRequest);
					  	       
					  	 //     getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
					  	  //  getView().getWestLayout().setVisible(false);
					  	    	  }// End of if
					  	    	  else{
					  	    		  
					  	    	//	 SC.warn("Access Denied");
					  	    	  }
					  	      }
			  	      }
			  	 else if(name.contentEquals(NameTokens.financialYear)){

			  		 Log.info("Section: "+NameTokens.financialYear);

		  	    	   for(Permission permission: permissions){
	
				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
		
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	    //  getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	   // getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
			  	 else if(name.contentEquals(NameTokens.fundAgencies)){

		  	    	   for(Permission permission: permissions){

				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
			
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	    //  getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	//    getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
			  	 else if(name.contentEquals(NameTokens.votes)){

		  	    	   for(Permission permission: permissions){
	
				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
	
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	  //    getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	  //  getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
			  	 else if(name.contentEquals(NameTokens.organizationalUnits)){
	
		  	    	   for(Permission permission: permissions){

				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
		
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	   //   getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	  //  getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
			  	 else if(name.contentEquals(NameTokens.currencies)){

		  	    	   for(Permission permission: permissions){

				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
			
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	  //    getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	  //  getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
			  	 else if(name.contentEquals(NameTokens.products)){
	
			  		 Log.info("Section: "+NameTokens.products);
	
		  	    	   for(Permission permission: permissions){

				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
			
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	//      getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	//    getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
			  	 else if(name.contentEquals(NameTokens.projects)){

			  		 Log.info("Section: "+NameTokens.projects);
		  	    	  
		  	    	   for(Permission permission: permissions){
		
				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
				  	
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	    //  getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	   // getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
			  	 else if(name.contentEquals(NameTokens.outputs)){
		  
		  	    	 Log.info("Section: "+NameTokens.outputs);
		  	    	  
		  	    	   for(Permission permission: permissions){

				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
			
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	  //    getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	  //  getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
			  	 else if(name.contentEquals(NameTokens.units)){

		  	    	Log.info("Section: "+NameTokens.units);
		
		  	    	   for(Permission permission: permissions){
				
				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
			
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  //	      getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	  //  getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
				 else if(name.contentEquals(NameTokens.suppliers)){

			  	    	Log.info("Section: "+NameTokens.suppliers);
	
			  	    	   for(Permission permission: permissions){
	
					  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
		
					  	      PlaceRequest myRequest = new PlaceRequest(name);
					  	       
					  	      placeManager.revealPlace(myRequest);
					  	       
					  	     // getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
					  	   // getView().getWestLayout().setVisible(false);
					  	    	  }// End of if
					  	    	  else{
					  	    		  
					  	    	//	 SC.warn("Access Denied");
					  	    	  }
					  	      }
			  	      }
				 else if(name.contentEquals(NameTokens.auditTrail)){

			  	    	Log.info("Section: "+NameTokens.auditTrail);
	
			  	    	   for(Permission permission: permissions){
	
					  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
		
					  	      PlaceRequest myRequest = new PlaceRequest(name);
					  	       
					  	      placeManager.revealPlace(myRequest);
					  	       
					  //	      getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
					  	 //   getView().getWestLayout().setVisible(false);
					  	    	  }// End of if
					  	    	  else{
					  	    		  
					  	    	//	 SC.warn("Access Denied");
					  	    	  }
					  	      }
			  	      }
			  	 else if(name.contentEquals(NameTokens.tasks)){

		  	    	Log.info("Section: "+NameTokens.tasks);
		  	    	  
		  	    	   for(Permission permission: permissions){
		  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
	
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	   //   getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	 //   getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
			  	 else if(name.contentEquals(NameTokens.inputRequisistions)){
	
		  	    	  Log.info("Selected Input Requisition");
		  	    	  
		  	    	   for(Permission permission: permissions){
			
				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
			
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	//      getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	 //   getView().getWestLayout().setVisible(false);
				  	    	  }
				  	    	  else{
				  	    		  
				  	    	
				  	    	  }
				  	      }
		  	      }
			  	 else if(name.contentEquals(NameTokens.setUpCommittees)){
			  		 
			  		Log.info("Section "+NameTokens.setUpCommittees);
			  		
		  	    	   for(Permission permission: permissions){
				
				  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
				  
				  	      PlaceRequest myRequest = new PlaceRequest(name);
				  	       
				  	      placeManager.revealPlace(myRequest);
				  	       
				  	//      getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
				  	 //   getView().getWestLayout().setVisible(false);
				  	    	  }// End of if
				  	    	  else{
				  	    		  
				  	    	//	 SC.warn("Access Denied");
				  	    	  }
				  	      }
		  	      }
				 else if(name.contentEquals(NameTokens.contractsCommittee)){
			  		 
				  		Log.info("Section "+NameTokens.contractsCommittee);
				  		
			  	    	   for(Permission permission: permissions){
				
					  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
					  	
					  	      PlaceRequest myRequest = new PlaceRequest(name);
					  	       
					  	      placeManager.revealPlace(myRequest);
					  	       
					  	    //  getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
					  	 //   getView().getWestLayout().setVisible(false);
					  	    	  }// End of if
					  	    	  else{
					  	    		  
					  	    	//	 SC.warn("Access Denied");
					  	    	  }
					  	      }
			  	      }
				 else if(name.contentEquals(NameTokens.evaluationCommittee)){
			  		 
				  		Log.info("Section "+NameTokens.evaluationCommittee);
				  		
			  	    	   for(Permission permission: permissions){
					  	
					  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_VIEW_ADMINISTRATION)){
					  	    	
					  	      PlaceRequest myRequest = new PlaceRequest(name);
					  	       
					  	      placeManager.revealPlace(myRequest);
					  	       
					  	  //    getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
					  	  //  getView().getWestLayout().setVisible(false);
					  	    	  }// End of if
					  	    	  else{
					  	    		  
					  	    	//	 SC.warn("Access Denied");
					  	    	  }
					  	      }
			  	      }
				 else if(name.contentEquals(NameTokens.bids)){
			  		 
				  		Log.info("Section "+NameTokens.bids);
				  		
			  	    	   for(Permission permission: permissions){

					  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_DISPLAY_TENDER)){

					  	      PlaceRequest myRequest = new PlaceRequest(name);
					  	       
					  	      placeManager.revealPlace(myRequest);
					  	       
					  	  //    getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
					  	  //  getView().getWestLayout().setVisible(false);
					  	    	  }
					  	    	  else{
					  	    		  
					  	    	//	 SC.warn("Access Denied");
					  	    	  }
					  	      }
			  	      }
				 else if(name.contentEquals(NameTokens.receiptBids)){
			  		 
				  		Log.info("Section "+NameTokens.receiptBids);
				  		
			  	    	   for(Permission permission: permissions){

					  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_DISPLAY_TENDER)){

					  	      PlaceRequest myRequest = new PlaceRequest(name);
					  	       
					  	      placeManager.revealPlace(myRequest);
					  	       
					  	  //    getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
					  	  //  getView().getWestLayout().setVisible(false);
					  	    	  }
					  	    	  else{
					  	    		  
					  	    	//	 SC.warn("Access Denied");
					  	    	  }
					  	      }
			  	      }
				 else if(name.contentEquals(NameTokens.evaluationBids)){
			  		 
				  		Log.info("Section "+NameTokens.evaluationBids);
				  		
			  	    	   for(Permission permission: permissions){

					  	    	  if(permission.getName().contentEquals(PermissionConstants.PERM_DISPLAY_TENDER)){

					  	      PlaceRequest myRequest = new PlaceRequest(name);
					  	       
					  	      placeManager.revealPlace(myRequest);
					  	       
					  	   //   getView().getNavigationPaneHeader().setContextAreaHeaderLabelContents(name);
					  	 //   getView().getWestLayout().setVisible(false);
					  	    	  }
					  	    	  else{
					  	    		  
					  	    	//	 SC.warn("Access Denied");
					  	    	  }
					  	      }
			  	      }
			  	 else{
	
			  		 Log.info("Section "+name);
			  	    }
			  	    
			  	    }*/
			  	  }   
		  
		  public class ApplicationMenuClickHandler implements ClickHandler{

			/* (non-Javadoc)
			 * @see com.smartgwt.client.widgets.menu.events.ClickHandler#onClick(com.smartgwt.client.widgets.menu.events.MenuItemClickEvent)
			 */
			public void onClick(MenuItemClickEvent event) {
				String applicationName = event.getItem().getTitle();
		     // SC.say("You clicked: " + applicationName);
		      
		      if(applicationName.contains("Log Out")){
		    	  
		      }
			}
			  
		  }

	/*	 (non-Javadoc)
		 * @see com.planetsystems.procnet.gwtui.client.events.MainPageUiHandlers#onGetLoggedInUser()
		 
		public void onGetLoggedInUser() {
			  
		  // get the data for the View's tabs
			    dispatcher.execute(new GetLoggedInUserAction(),
			        new AsyncCallback<GetLoggedInUserResult>() {
			      public void onFailure(Throwable caught) {
			      //  Log.debug("onFailure() - " + caught.getMessage());
			    	  GWT.log("onFailure() - "+caught.getMessage(),null);
			    	 getView().setGetLoggedInUserError("An Error Occurred: "+caught.getMessage());
			    	  caught.printStackTrace();
			      }

				public void onSuccess(GetLoggedInUserResult result) {
					 GWT.log("onSuccess().. Logged In user",null);
				 
				 getView().getMastHead().setSignedInUserLabelContents(result.getLoggedInUser().getFullName()+"<br>"+result.getLoggedInUser().getDepartmentName()+"<br>"+result.getLoggedInUser().getVoteName());

					   
					 getView().setUserPermissions(result.getLoggedInUser().getPermissions());
					
				}

			    });
			
		}*/

	/*	 (non-Javadoc)
		 * @see com.planetsystems.procnet.gwtui.client.events.MainPageUiHandlers#onChangedUserPasswordClicked()
		 
		public void onChangedUserPasswordClicked() {
			
			PlaceRequest myRequest = new PlaceRequest(NameTokens.changePassword);
		       
		      placeManager.revealPlace(myRequest);
			
			
		}*/

	/*	 (non-Javadoc)
		 * @see com.planetsystems.procnet.gwtui.client.events.MainPageUiHandlers#onSectionPermissionClicked()
		 
		public void onSectionPermissionClicked() {
			// TODO Auto-generated method stub
			
		}*/
/*
		 (non-Javadoc)
		 * @see com.planetsystems.procnet.gwtui.client.events.MainPageUiHandlers#onGetLoggedInUserPermissions()
		 
		public void onGetLoggedInUserPermissions() {
			
		    dispatcher.execute(new GetLoggedInUserAction(),
			        new AsyncCallback<GetLoggedInUserResult>() {
			      public void onFailure(Throwable caught) {
			     
			    	  GWT.log("onGetLoggedInUserPermissions:onFailure() - "+caught.getMessage(),null);
			    	 getView().setGetLoggedInUserError("An Error Occurred: "+caught.getMessage());
			    	  caught.printStackTrace();
			      }

				public void onSuccess(GetLoggedInUserResult result) {
					 GWT.log("onGetLoggedInUserPermissions:onSuccess().. Logged In user",null);

				permissions = result.getLoggedInUser().getPermissions();
	
				}

			    });
			
		}

		 (non-Javadoc)
		 * @see com.planetsystems.procnet.gwtui.client.events.MainPageUiHandlers#onBudgetSectionClickHandler()
		 
		public void onBudgetSectionClickHandler() {
			
			getView().getNavigationPane().addRecordClickHandler(procnetura.getConstants().BudgetStackSectionName(), new NavigationPaneClickHandler());
			
		}

		 (non-Javadoc)
		 * @see com.planetsystems.procnet.gwtui.client.events.MainPageUiHandlers#onPlanSectionClickHandler()
		 
		public void onPlanSectionClickHandler() {
			
			getView().getNavigationPane().addRecordClickHandler("Plans", new NavigationPaneClickHandler());
		}

		 (non-Javadoc)
		 * @see com.planetsystems.procnet.gwtui.client.events.MainPageUiHandlers#onRequisitionSectionClickHandler()
		 
		public void onRequisitionSectionClickHandler() {
			getView().getNavigationPane().addRecordClickHandler("Requsitions", new NavigationPaneClickHandler());
			
		}

		 (non-Javadoc)
		 * @see com.planetsystems.procnet.gwtui.client.events.MainPageUiHandlers#onTenderSectionClickHandler()
		 
		public void onTenderSectionClickHandler() {
			getView().getNavigationPane().addRecordClickHandler("Tenders", new NavigationPaneClickHandler());
			
		}

		 (non-Javadoc)
		 * @see com.planetsystems.procnet.gwtui.client.events.MainPageUiHandlers#onCommitteeSectionClickHandler()
		 
		public void onCommitteeSectionClickHandler() {
			getView().getNavigationPane().addRecordClickHandler("Committees", new NavigationPaneClickHandler());
			
		}

		 (non-Javadoc)
		 * @see com.planetsystems.procnet.gwtui.client.events.MainPageUiHandlers#onAdministrationSectionClickHandler()
		 
		public void onAdministrationSectionClickHandler() {
			
			getView().getNavigationPane().addRecordClickHandler(procnetura.getConstants().SystemAdministrationStackSectionName(), new NavigationPaneClickHandler());
			
		}
		  
		  }*/

	

		
	
		  }
		  
		
			/*public void onBudgetSectionClickHandler() {
				
				getView().getNavigationPane().addRecordClickHandler(procnet.getConstants().BudgetStackSectionName(), new NavigationPaneClickHandler());
				
			}

			public void onPlanSectionClickHandler() {
				
				getView().getNavigationPane().addRecordClickHandler(procnet.getConstants().PlansStackSectionName(), new NavigationPaneClickHandler());
			}
			
			public void onRequisitionSectionClickHandler() {
				getView().getNavigationPane().addRecordClickHandler(procnet.getConstants().RequisitionsStackSectionName(), new NavigationPaneClickHandler());
				
			}*/
			
		/*public void onAdministrationSectionClickHandler() {
			
			getView().getNavigationPane().addRecordClickHandler(procnet.getConstants().SystemAdministrationStackSectionName(), new NavigationPaneClickHandler());
			
		}*/

		/*public void onGetLoggedInUser() {
			
			Log.info("onGetLoggedInUser...");
			
			dispatcher.execute(new UsersAction(NameTokens.getLoggedInUser,NameTokens.users), new AsyncCallback<UsersResult>(){

				public void onFailure(Throwable caught) {
					
					Log.error("onFailure",caught);
					
					getView().setGetLoggedInUserError(caught.getLocalizedMessage());
					
				}

				public void onSuccess(UsersResult result) {
					
					Log.info("onSucces...");
					
					if(result.isOperationStatus() == true){
						
						Log.info("onSuccess:true");
				
						
						Log.info("Set Logged In User Permissions");
						getView().setUserPermissions(result.getUser().getPermissions());
			
						
					}
					else {
						
						Log.info("onSuccess:false");
						
						getView().setGetLoggedInUserError(result.getServerResponse());
						
						
					}
					
				}
				
			});
		}
*/
		/*public void getActiveFinancialYear() {
			
			Log.info("getActiveFinancialYear... ");
			
			dispatcher.execute(new FinancialYearAction(NameTokens.getActiveFinancialYear), new AsyncCallback<FinancialYearResult>(){

				public void onFailure(Throwable caught) {
					
					Log.error("onFailure... ",caught);
					
					getView().setGetLoggedInUserError(caught.getLocalizedMessage());
					
				}

				public void onSuccess(FinancialYearResult result) {
					
					Log.info("success... ");
					
					if(result.isOperationStatus() == true){
						
						Log.info("success:true ");
		
						activeFinancialYear.setId(result.getFinancialYear().getId());
						activeFinancialYear.setFinancialYear_desc(result.getFinancialYear().getFinancialYear_desc());
						
					}
					else{
						
						Log.info("success:false ");
						
						getView().setGetLoggedInUserError(result.getServerResponse());
					}
				}
				
			});
		}
*/
		public void onBookingsSectionClickHandler() {
			// TODO Auto-generated method stub
			
		}
		
		public void onAdministrationSectionClickHandler() {
		
		getView().getNavigationPane().addRecordClickHandler(bookingSystem.getConstants().SystemAdministrationStackSectionName(), new NavigationPaneClickHandler());
		
	}

		
}
