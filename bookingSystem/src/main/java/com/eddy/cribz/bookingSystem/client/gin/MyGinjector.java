/**
 * 
 */
package com.eddy.cribz.bookingSystem.client.gin;

import com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.mvp.client.proxy.PlaceManager;


/**
 * @author Planet Developer 001
 * 
 */
@GinModules({ DispatchAsyncModule.class, ProcnetModule.class })
public interface MyGinjector extends Ginjector {

	PlaceManager getPlaceManager();

	EventBus getEventBus();

	Provider<MainPagePresenter> getMainPagePresenter();

	/*AsyncProvider<UsersPresenter> getUsersPresenter();

	AsyncProvider<FinancialYearPresenter> getFinancialYearPresenter();

	AsyncProvider<CurrencyPresenter> getCurrencyPresenter();

	AsyncProvider<AuditTrailPresenter> getAuditTrailPresenter();

	AsyncProvider<TasksPresenter> getTasksPresenter();
	
	AsyncProvider<OrganizationalUnitPresenter> getOrganizationalUnitPresenter();*/

	

}
