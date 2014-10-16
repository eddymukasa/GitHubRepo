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
public class BookingData {

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
					createRecord("","calendar",NameTokens.makeBooking),
					createRecord("","task",NameTokens.changePassword),
					
					
					
				
			};
		
	}
}
