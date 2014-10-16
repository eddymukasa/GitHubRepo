package com.eddy.cribz.bookingSystem.client.gin;

import com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter;
import com.eddy.cribz.bookingSystem.client.utils.NameTokens;
import com.eddy.cribz.bookingSystem.client.views.MainPageView;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;



public class ProcnetModule extends AbstractPresenterModule {

	@Override
	protected void configure() {

		install(new DefaultModule(ProcnetPlaceManager.class));

		// Constants
		bindConstant().annotatedWith(DefaultPlace.class)
				.to(NameTokens.mainPage);

		// Presenters
		bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
				MainPageView.class, MainPagePresenter.MyProxy.class);

		/*bindPresenter(UsersPresenter.class, UsersPresenter.MyView.class,
				UsersView.class, UsersPresenter.MyProxy.class);

		bindPresenter(FinancialYearPresenter.class,
				FinancialYearPresenter.MyView.class, FinancialYearView.class,
				FinancialYearPresenter.MyProxy.class);

		bindPresenter(CurrencyPresenter.class, CurrencyPresenter.MyView.class,
				CurrencyView.class, CurrencyPresenter.MyProxy.class);

		bindPresenter(AuditTrailPresenter.class,
				AuditTrailPresenter.MyView.class, AuditTrailView.class,
				AuditTrailPresenter.MyProxy.class);

		bindPresenter(TasksPresenter.class, TasksPresenter.MyView.class,
				TasksView.class, TasksPresenter.MyProxy.class);

		bindPresenter(OrganizationalUnitPresenter.class, OrganizationalUnitPresenter.MyView.class,
				OrganizationalUnitsView.class, OrganizationalUnitPresenter.MyProxy.class);*/
		

	}

}
