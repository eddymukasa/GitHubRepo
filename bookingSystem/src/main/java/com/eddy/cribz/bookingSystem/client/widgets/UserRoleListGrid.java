/**
 * 
 */
package com.eddy.cribz.bookingSystem.client.widgets;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordExpandEvent;
import com.smartgwt.client.widgets.grid.events.RecordExpandHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * @author Planet Developer 001
 *
 */
public class UserRoleListGrid extends ListGrid{

	private static final String ICON = "icon";
	private static final String ICON_DISPLAY_NAME="#";
	private static final String ROLE_ID="roleID";
	private static final String ROLE_ID_DISPLAY="Role ID";
	private static final String ROLE_NAME="roleName";
	private static final String ROLE_NAME_DISPLAY="Role Name";
	private static final String ROLE_DESCRIPTION="roleDescription";
	private static final String ROLE_DESCRIPTION_DISPLAY="Role Description";
	private static final String ROLE_ASSIGN_CHECKBOX="roleCheckBox";
	private static final String ROLE_ASSIGN_CHECKBOX_DISPLAY="Assign";
	private static final String EMPTY_FIELD = "emptyField"; 
	private static final String EMPTY_FIELD_DISPLAY_NAME = " "; 
	private static final String URL_PREFIX = "icons/16/";
	private static final String URL_SUFFIX = ".png";
	private static final String CREATED_BY= "createdBy";
	private static final String CREATED_BY_DISPLAY= "Created By";
	private static final String CHANGED_BY= "changedBy";
	private static final String CHANGED_BY_DISPLAY= "ChangedBy";
	
	  private static final int ICON_COLUMN_LENGTH = 27; 	 
	  
	  
		final PermissionsListGrid permissionsGrid = new PermissionsListGrid();
	public UserRoleListGrid(){
		super();
		
		//this.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		 // initialize the List Grid fields  
	    ListGridField iconField = new ListGridField(ICON, ICON_DISPLAY_NAME, ICON_COLUMN_LENGTH);
	    iconField.setImageSize(16); 
	    iconField.setAlign(Alignment.CENTER);
	    iconField.setType(ListGridFieldType.IMAGE);  
	    iconField.setImageURLPrefix(URL_PREFIX);  
	    iconField.setImageURLSuffix(URL_SUFFIX);
	    
	    ListGridField roleIDField = new ListGridField(ROLE_ID, ROLE_ID_DISPLAY);
	    roleIDField.setHidden(true);
	    ListGridField roleNameField = new ListGridField(ROLE_NAME, ROLE_NAME_DISPLAY);
	    roleNameField.setWidth("40%");
	    ListGridField roleDescriptionField = new ListGridField(ROLE_DESCRIPTION, ROLE_DESCRIPTION_DISPLAY);
	    roleDescriptionField.setWidth("40%");
	    ListGridField roleCheckField = new ListGridField(ROLE_ASSIGN_CHECKBOX, ROLE_ASSIGN_CHECKBOX_DISPLAY);
	    roleCheckField.setWidth("");
	    ListGridField emptyField = new ListGridField(EMPTY_FIELD, EMPTY_FIELD_DISPLAY_NAME);
	    emptyField.setWidth("");
		ListGridField createdByField = new ListGridField(CREATED_BY, CREATED_BY_DISPLAY); 
		createdByField.setWidth("15%");
		ListGridField changedByField = new ListGridField(CHANGED_BY, CHANGED_BY_DISPLAY); 
		changedByField.setWidth("15%");
	     this.setDrawAheadRatio(4);  
	     this.setCanExpandRecords(true); 
	    // set the fields into the List Grid  
	    this.setFields(new ListGridField[] {iconField, roleIDField, roleNameField, roleDescriptionField,createdByField,changedByField});
	   
	  
	}
	
	/**
	 * @return the permissionsGrid
	 */
	public ListGrid getPermissionsGrid() {
		return permissionsGrid;
	}

	// Expansion Component
	protected Canvas getExpansionComponent(final ListGridRecord record){
		
		final ListGrid grid = this;
		
		for(ListGridRecord gr :  grid.getRecords())
		{
			if(gr!=record)
			{
				grid.collapseRecord(gr);
			}
		}
		grid.selectRecord(record);
		
		VLayout layout = new VLayout(5);
		layout.setPadding(5);
		
	
		permissionsGrid.setWidth(800);
		permissionsGrid.setHeight(224);
		permissionsGrid.setCellHeight(22);
		//permissionsGrid.setDataSource(record);
		
		layout.addMember(permissionsGrid);
		
		 HLayout hLayout = new HLayout(10);  
         hLayout.setAlign(Alignment.CENTER);  

         IButton saveButton = new IButton("Save");  
         saveButton.setTop(250);  
         saveButton.addClickHandler(new ClickHandler() {  
             public void onClick(ClickEvent event) {  
            	// permissionsGrid.saveAllEdits();  
             }  
         });  
        // hLayout.addMember(saveButton);  

         IButton discardButton = new IButton("Discard");  
         discardButton.addClickHandler(new ClickHandler() {  
             public void onClick(ClickEvent event) {  
            	 //permissionsGrid.discardAllEdits();  
             }  
         });  
       //  hLayout.addMember(discardButton);  

         IButton closeButton = new IButton("Close");  
         closeButton.addClickHandler(new ClickHandler() {  
             public void onClick(ClickEvent event) {  
                 grid.collapseRecord(record);  
             }  
         });  
         hLayout.addMember(closeButton);  
                                          
         layout.addMember(hLayout);  

         return layout;  
	
       
		
	}
	
}
