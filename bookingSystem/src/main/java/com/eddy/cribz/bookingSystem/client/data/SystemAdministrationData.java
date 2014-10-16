/**
 * 
 */
package com.eddy.cribz.bookingSystem.client.data;



import com.eddy.cribz.bookingSystem.client.utils.NameTokens;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * @author Planet Developer 001
 *
 */
public class SystemAdministrationData {

private static ListGridRecord[] records;
	
	public static ListGridRecord[] getRecords(){
		if(records == null){
			records = getNewRecords();
			
		}
		return records;
		
	}
	
	public static ListGridRecord createRecord(String pk, String icon, String name )
	{
		ListGridRecord record = new ListGridRecord();
		record.setAttribute("pk", pk);
		record.setAttribute("icon", icon);
		record.setAttribute("name", name);
		return record;
	}
	
	public static ListGridRecord[] getNewRecords(){
		
			return new ListGridRecord[]{
					//createRecord("","audittrail",NameTokens.auditTrail),
					
					createRecord("","users",NameTokens.users),
					//createRecord("","task","Tasks"),
					createRecord("","calendar",NameTokens.bookings),
					//createRecord("","votes","Votes"),
					createRecord("","organizations",NameTokens.events),
					createRecord("","currency",NameTokens.passwordPolicy),
					//createRecord("","contents",NameTokens.principles),
					//createRecord("","products","Products"),
					//createRecord("","contents",NameTokens.items),
					//createRecord("","outputs","Outputs"),*/
					//createRecord("","history","Measurement Units"),
					//createRecord("","suppliers",NameTokens.suppliers)

			};
		
	}
}
