/**
 * 
 */
package com.eddy.cribz.bookingSystem.server;








import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.gwtplatform.dispatch.server.actionvalidator.ActionValidator;
import com.gwtplatform.dispatch.server.spring.HandlerModule;
import com.gwtplatform.dispatch.server.spring.actionvalidator.DefaultActionValidator;
import com.gwtplatform.dispatch.server.spring.configuration.DefaultModule;


/**
 * @author Planet Developer 001
 *
 */
@Configuration
@Import(DefaultModule.class)
public class ServerModule extends HandlerModule{

	// Required
	public ServerModule(){
		
	}
	
	//Required
	 @Bean
	  public ActionValidator getDefaultActionValidator() {
	    return new DefaultActionValidator();
	  }

	 
	// Users
	/*@Bean
    public UsersHandler getAddUsersHandler(){
		
		return new UsersHandler();
	}
	
	@Bean
    public CurrencyHandler getCurrencyHandler(){
		
		return new CurrencyHandler();
	}
	
	
	@Bean
    public FinancialYearHandler FinancialYearHandler(){
		
		return new FinancialYearHandler();
	}
	
	
	
	@Bean
    public OrganizationalUnitsHandler OrganizationalUnitsHandler(){
		
		return new OrganizationalUnitsHandler();
	}
	*/
	/*@Bean
    public ItemHandler ItemHandler(){
		
		return new ItemHandler();
	}
	
	
	@Bean
    public MeasurementUnitsHandler MeasurementUnitsHandler(){
		
		return new MeasurementUnitsHandler();
	}
	
	
	*/
	/*@Bean
    public AuditTrailHandler AuditTrailHandler(){
		
		return new AuditTrailHandler();
	}
	
	@Bean
    public TaskHandler TaskHandler(){
		
		return new TaskHandler();
	}*/
	
	/*@Bean
    public ApprovalsHandler ApprovalsHandler(){
		
		return new  ApprovalsHandler();
	}*/
	
	@Override
	protected void configureHandlers() {
		
		
		//bindHandler(UsersAction.class, UsersHandler.class);
		
		//bindHandler(CurrencyAction.class, CurrencyHandler.class);
		
		//bindHandler(FundingAgencyAction.class, FundingAgencyHandler.class);
		
		//bindHandler(FinancialYearAction.class, FinancialYearHandler.class);
		
		
		//bindHandler(OrganizationalUnitsAction.class, OrganizationalUnitsHandler.class);
		
		//bindHandler(ItemAction.class, ItemHandler.class);
		
		
		//bindHandler(MeasurementUnitsAction.class, MeasurementUnitsHandler.class);
		//bindHandler(AuditTrailAction.class,AuditTrailHandler.class);
		
		//bindHandler(TaskAction.class,TaskHandler.class);
		//bindHandler(ApprovalsAction.class,ApprovalsHandler.class);
		
	}

}
