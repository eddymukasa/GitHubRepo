
package com.eddy.cribz.bookingSystem.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

/**
 * @author Planet Developer 001
 *
 */
public class BookingDataSource extends DataSource{

private static BookingDataSource instance = null;
	
	public static BookingDataSource getInstance(){
			
			if(instance == null){
				instance = new BookingDataSource("localBookingsDataSource");
			}
			return instance;
		}
		
		public BookingDataSource(String id){
			
			 DataSourceTextField pk = new DataSourceTextField("pk", "Primary Key");  
	        DataSourceTextField icon = new DataSourceTextField("icon", "ICON");  
	        DataSourceTextField name = new DataSourceTextField("name", "Name");  
	        setFields(pk, icon, name);  
	          
	        setTestData(BookingData.getNewRecords());  
	        setClientOnly(true);  
		}
}
