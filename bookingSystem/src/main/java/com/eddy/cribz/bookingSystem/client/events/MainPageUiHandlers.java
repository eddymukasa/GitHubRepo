package com.eddy.cribz.bookingSystem.client.events;

import com.gwtplatform.mvp.client.UiHandlers;

public interface MainPageUiHandlers extends UiHandlers {
  
  void onNavigationPaneSectionHeaderClicked(String name);
  void onNavigationPaneSectionClicked(String name);
/*  void onGetLoggedInUser();
  //void onChangedUserPasswordClicked();
  void onSectionPermissionClicked();
  void onGetLoggedInUserPermissions();
  
  void onBudgetSectionClickHandler();
  void onPlanSectionClickHandler();
 // 
  //void onTenderSectionClickHandler();
  void onCommitteeSectionClickHandler();
  void onAdministrationSectionClickHandler();
  
  */
  
 // void getActiveFinancialYear();
 // void onGetLoggedInUser();
 void onBookingsSectionClickHandler();
  void onAdministrationSectionClickHandler();
}
