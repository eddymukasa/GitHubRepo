package com.eddy.cribz.bookingSystem.client.gin;

import com.google.gwt.core.client.GWT;

public class MyGinjectorImpl implements com.eddy.cribz.bookingSystem.client.gin.MyGinjector {
  public com.google.web.bindery.event.shared.EventBus getEventBus() {
    return get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$();
  }
  
  public com.google.inject.Provider<com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter> getMainPagePresenter() {
    return get_Key$type$com$google$inject$Provider$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$$_annotation$$none$$();
  }
  
  public com.gwtplatform.mvp.client.proxy.PlaceManager getPlaceManager() {
    return get_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$();
  }
  
  
  /**
   * Binding for java.lang.String declared at:
   *   com.eddy.cribz.bookingSystem.client.gin.ProcnetModule.configure(ProcnetModule.java:19)
   */
  private java.lang.String create_Key$type$java$lang$String$_annotation$$com$eddy$cribz$bookingSystem$client$gin$DefaultPlace$() {
    return "MainPage";
  }
  
  
  /**
   * Binding for java.lang.String declared at:
   *   com.eddy.cribz.bookingSystem.client.gin.ProcnetModule.configure(ProcnetModule.java:19)
   */
  private java.lang.String get_Key$type$java$lang$String$_annotation$$com$eddy$cribz$bookingSystem$client$gin$DefaultPlace$() {
    return create_Key$type$java$lang$String$_annotation$$com$eddy$cribz$bookingSystem$client$gin$DefaultPlace$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.ExceptionHandler declared at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:179)
   */
  private com.gwtplatform.dispatch.client.ExceptionHandler create_Key$type$com$gwtplatform$dispatch$client$ExceptionHandler$_annotation$$none$$() {
    return get_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.ExceptionHandler declared at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:179)
   */
  private com.gwtplatform.dispatch.client.ExceptionHandler get_Key$type$com$gwtplatform$dispatch$client$ExceptionHandler$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$dispatch$client$ExceptionHandler$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.NavigationPane declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.NavigationPane, annotation=[none]]
   */
  private void memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPane$_annotation$$none$$(com.eddy.cribz.bookingSystem.client.widgets.NavigationPane injectee) {
    
  }
  
  private com.eddy.cribz.bookingSystem.client.widgets.NavigationPane create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPane$_annotation$$none$$() {
    Object created = GWT.create(com.eddy.cribz.bookingSystem.client.widgets.NavigationPane.class);
    assert created instanceof com.eddy.cribz.bookingSystem.client.widgets.NavigationPane;
    com.eddy.cribz.bookingSystem.client.widgets.NavigationPane result = (com.eddy.cribz.bookingSystem.client.widgets.NavigationPane) created;
    
    memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPane$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.NavigationPane declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.NavigationPane, annotation=[none]]
   */
  private com.eddy.cribz.bookingSystem.client.widgets.NavigationPane get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPane$_annotation$$none$$() {
    return create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPane$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:123)
   */
  private native void com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection(com.gwtplatform.mvp.client.HandlerContainerImpl injectee, com.gwtplatform.mvp.client.AutobindDisable _0) /*-{
    injectee.@com.gwtplatform.mvp.client.HandlerContainerImpl::automaticBind(Lcom/gwtplatform/mvp/client/AutobindDisable;)(_0);
  }-*/;
  
  private void memberInject_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$_annotation$$none$$(com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter injectee) {
    com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection(injectee, get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  private com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter_MainPagePresenter_methodInjection(com.google.web.bindery.event.shared.EventBus _0, com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyView _1, com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyProxy _2, com.gwtplatform.mvp.client.proxy.PlaceManager _3, com.gwtplatform.dispatch.shared.DispatchAsync _4) {
    return new com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter(_0, _1, _2, _3, _4);
  }
  
  private com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter create_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$_annotation$$none$$() {
    com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter result = com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter_MainPagePresenter_methodInjection(get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyView$_annotation$$none$$(), get_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyProxy$_annotation$$none$$(), get_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$(), get_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$());
    memberInject_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$_annotation$$none$$(result);
    return result;
  }
  
  private com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter singleton_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:123)
   */
  private com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter get_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$_annotation$$none$$ = create_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.proxy.TokenFormatter declared at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:48)
   */
  private com.gwtplatform.mvp.client.proxy.TokenFormatter create_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$() {
    return get_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$();
  }
  
  private com.gwtplatform.mvp.client.proxy.TokenFormatter singleton_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:48)
   */
  private com.gwtplatform.mvp.client.proxy.TokenFormatter get_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$ = create_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry declared at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:181)
   */
  private com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry create_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$() {
    return get_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$();
  }
  
  private com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry singleton_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:181)
   */
  private com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry get_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$ = create_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu, annotation=[none]]
   */
  private void memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$ApplicationMenu$_annotation$$none$$(com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu injectee) {
    
  }
  
  private com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$ApplicationMenu$_annotation$$none$$() {
    Object created = GWT.create(com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu.class);
    assert created instanceof com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu;
    com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu result = (com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu) created;
    
    memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$ApplicationMenu$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu, annotation=[none]]
   */
  private com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$ApplicationMenu$_annotation$$none$$() {
    return create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$ApplicationMenu$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.dispatch.shared.DispatchAsync declared at:
   *   protected com.gwtplatform.dispatch.shared.DispatchAsync com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.provideDispatchAsync(com.gwtplatform.dispatch.client.ExceptionHandler,com.gwtplatform.dispatch.shared.SecurityCookieAccessor,com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry)
   */
  private native com.gwtplatform.dispatch.shared.DispatchAsync com$gwtplatform$dispatch$client$gin$DispatchAsyncModule_provideDispatchAsync_methodInjection(com.gwtplatform.dispatch.client.gin.DispatchAsyncModule injectee, com.gwtplatform.dispatch.client.ExceptionHandler _0, com.gwtplatform.dispatch.shared.SecurityCookieAccessor _1, com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry _2) /*-{
    return injectee.@com.gwtplatform.dispatch.client.gin.DispatchAsyncModule::provideDispatchAsync(Lcom/gwtplatform/dispatch/client/ExceptionHandler;Lcom/gwtplatform/dispatch/shared/SecurityCookieAccessor;Lcom/gwtplatform/dispatch/client/actionhandler/ClientActionHandlerRegistry;)(_0, _1, _2);
  }-*/;
  
  private com.gwtplatform.dispatch.shared.DispatchAsync create_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$() {
    return com$gwtplatform$dispatch$client$gin$DispatchAsyncModule_provideDispatchAsync_methodInjection(new com.gwtplatform.dispatch.client.gin.DispatchAsyncModule(), get_Key$type$com$gwtplatform$dispatch$client$ExceptionHandler$_annotation$$none$$(), get_Key$type$com$gwtplatform$dispatch$shared$SecurityCookieAccessor$_annotation$$none$$(), get_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$());
  }
  
  private com.gwtplatform.dispatch.shared.DispatchAsync singleton_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   protected com.gwtplatform.dispatch.shared.DispatchAsync com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.provideDispatchAsync(com.gwtplatform.dispatch.client.ExceptionHandler,com.gwtplatform.dispatch.shared.SecurityCookieAccessor,com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry)
   */
  private com.gwtplatform.dispatch.shared.DispatchAsync get_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$ = create_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.web.bindery.event.shared.EventBus declared at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:47)
   */
  private com.google.web.bindery.event.shared.EventBus create_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$() {
    return get_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$();
  }
  
  private com.google.web.bindery.event.shared.EventBus singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:47)
   */
  private com.google.web.bindery.event.shared.EventBus get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$() {
    if (singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$ = create_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter$MyView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  private com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyView create_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyView$_annotation$$none$$() {
    return get_Key$type$com$eddy$cribz$bookingSystem$client$views$MainPageView$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter$MyView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  private com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyView get_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyView$_annotation$$none$$() {
    return create_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.RootPresenter declared at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:49)
   */
  private native void com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_(com.gwtplatform.mvp.client.HandlerContainerImpl injectee, com.gwtplatform.mvp.client.AutobindDisable _0) /*-{
    injectee.@com.gwtplatform.mvp.client.HandlerContainerImpl::automaticBind(Lcom/gwtplatform/mvp/client/AutobindDisable;)(_0);
  }-*/;
  
  private void memberInject_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$(com.gwtplatform.mvp.client.RootPresenter injectee) {
    com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_(injectee, get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  private com.gwtplatform.mvp.client.RootPresenter com$gwtplatform$mvp$client$RootPresenter_RootPresenter_methodInjection(com.google.web.bindery.event.shared.EventBus _0, com.gwtplatform.mvp.client.RootPresenter.RootView _1) {
    return new com.gwtplatform.mvp.client.RootPresenter(_0, _1);
  }
  
  private com.gwtplatform.mvp.client.RootPresenter create_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$() {
    com.gwtplatform.mvp.client.RootPresenter result = com$gwtplatform$mvp$client$RootPresenter_RootPresenter_methodInjection(get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$());
    memberInject_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$(result);
    return result;
  }
  
  private com.gwtplatform.mvp.client.RootPresenter singleton_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:49)
   */
  private com.gwtplatform.mvp.client.RootPresenter get_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$ = create_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar, annotation=[none]]
   */
  private void memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$MainStatusBar$_annotation$$none$$(com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar injectee) {
    
  }
  
  private com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$MainStatusBar$_annotation$$none$$() {
    Object created = GWT.create(com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar.class);
    assert created instanceof com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar;
    com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar result = (com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar) created;
    
    memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$MainStatusBar$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar, annotation=[none]]
   */
  private com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$MainStatusBar$_annotation$$none$$() {
    return create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$MainStatusBar$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.inject.Provider<com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter>, annotation=[none]]
   */
  private com.google.inject.Provider<com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter> create_Key$type$com$google$inject$Provider$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$$_annotation$$none$$() {
    return new com.google.inject.Provider<com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter>() { 
      public com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter get() { 
        return get_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$_annotation$$none$$();
      }
    };
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter>, annotation=[none]]
   */
  private com.google.inject.Provider<com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter> get_Key$type$com$google$inject$Provider$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$$_annotation$$none$$() {
    return create_Key$type$com$google$inject$Provider$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics declared at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:50)
   */
  private com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics create_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$() {
    return get_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$();
  }
  
  private com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics singleton_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:50)
   */
  private com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics get_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$ = create_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$(com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor injectee) {
    
  }
  
  private com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor create_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$() {
    Object created = GWT.create(com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor.class);
    assert created instanceof com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor;
    com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor result = (com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor) created;
    
    memberInject_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor, annotation=[none]]
   */
  private com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor get_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.views.MainPageView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:124)
   */
  private void memberInject_Key$type$com$eddy$cribz$bookingSystem$client$views$MainPageView$_annotation$$none$$(com.eddy.cribz.bookingSystem.client.views.MainPageView injectee) {
    
  }
  
  private com.eddy.cribz.bookingSystem.client.views.MainPageView com$eddy$cribz$bookingSystem$client$views$MainPageView_MainPageView_methodInjection(com.eddy.cribz.bookingSystem.client.widgets.Masthead _0, com.eddy.cribz.bookingSystem.client.widgets.ApplicationMenu _1, com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader _2, com.eddy.cribz.bookingSystem.client.widgets.NavigationPane _3, com.eddy.cribz.bookingSystem.client.widgets.StatusBar _4, com.eddy.cribz.bookingSystem.client.widgets.MainStatusBar _5) {
    return new com.eddy.cribz.bookingSystem.client.views.MainPageView(_0, _1, _2, _3, _4, _5);
  }
  
  private com.eddy.cribz.bookingSystem.client.views.MainPageView create_Key$type$com$eddy$cribz$bookingSystem$client$views$MainPageView$_annotation$$none$$() {
    com.eddy.cribz.bookingSystem.client.views.MainPageView result = com$eddy$cribz$bookingSystem$client$views$MainPageView_MainPageView_methodInjection(get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$Masthead$_annotation$$none$$(), get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$ApplicationMenu$_annotation$$none$$(), get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPaneHeader$_annotation$$none$$(), get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPane$_annotation$$none$$(), get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$StatusBar$_annotation$$none$$(), get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$MainStatusBar$_annotation$$none$$());
    memberInject_Key$type$com$eddy$cribz$bookingSystem$client$views$MainPageView$_annotation$$none$$(result);
    return result;
  }
  
  private com.eddy.cribz.bookingSystem.client.views.MainPageView singleton_Key$type$com$eddy$cribz$bookingSystem$client$views$MainPageView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:124)
   */
  private com.eddy.cribz.bookingSystem.client.views.MainPageView get_Key$type$com$eddy$cribz$bookingSystem$client$views$MainPageView$_annotation$$none$$() {
    if (singleton_Key$type$com$eddy$cribz$bookingSystem$client$views$MainPageView$_annotation$$none$$ == null) {
      singleton_Key$type$com$eddy$cribz$bookingSystem$client$views$MainPageView$_annotation$$none$$ = create_Key$type$com$eddy$cribz$bookingSystem$client$views$MainPageView$_annotation$$none$$();
    }
    return singleton_Key$type$com$eddy$cribz$bookingSystem$client$views$MainPageView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$(com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry injectee) {
    
  }
  
  private com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry create_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$() {
    Object created = GWT.create(com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry.class);
    assert created instanceof com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry;
    com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry result = (com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry) created;
    
    memberInject_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry, annotation=[none]]
   */
  private com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry get_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.proxy.PlaceManager declared at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:51)
   */
  private com.gwtplatform.mvp.client.proxy.PlaceManager create_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$() {
    return get_Key$type$com$eddy$cribz$bookingSystem$client$gin$ProcnetPlaceManager$_annotation$$none$$();
  }
  
  private com.gwtplatform.mvp.client.proxy.PlaceManager singleton_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:51)
   */
  private com.gwtplatform.mvp.client.proxy.PlaceManager get_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$ = create_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader, annotation=[none]]
   */
  private void memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPaneHeader$_annotation$$none$$(com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader injectee) {
    
  }
  
  private com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPaneHeader$_annotation$$none$$() {
    Object created = GWT.create(com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader.class);
    assert created instanceof com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader;
    com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader result = (com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader) created;
    
    memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPaneHeader$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader, annotation=[none]]
   */
  private com.eddy.cribz.bookingSystem.client.widgets.NavigationPaneHeader get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPaneHeader$_annotation$$none$$() {
    return create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$NavigationPaneHeader$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$(com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter injectee) {
    
  }
  
  private com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter_ParameterTokenFormatter_methodInjection() {
    return new com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter();
  }
  
  private com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter create_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$() {
    com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter result = com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter_ParameterTokenFormatter_methodInjection();
    memberInject_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter, annotation=[none]]
   */
  private com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter get_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.AutobindDisable declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.AutobindDisable, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$(com.gwtplatform.mvp.client.AutobindDisable injectee) {
    
  }
  
  private native com.gwtplatform.mvp.client.AutobindDisable com$gwtplatform$mvp$client$AutobindDisable_AutobindDisable_methodInjection() /*-{
    return @com.gwtplatform.mvp.client.AutobindDisable::new()();
  }-*/;
  
  private com.gwtplatform.mvp.client.AutobindDisable create_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$() {
    com.gwtplatform.mvp.client.AutobindDisable result = com$gwtplatform$mvp$client$AutobindDisable_AutobindDisable_methodInjection();
    memberInject_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$(result);
    return result;
  }
  
  private com.gwtplatform.mvp.client.AutobindDisable singleton_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.AutobindDisable, annotation=[none]]
   */
  private com.gwtplatform.mvp.client.AutobindDisable get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$ = create_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.Masthead declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.Masthead, annotation=[none]]
   */
  private void memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$Masthead$_annotation$$none$$(com.eddy.cribz.bookingSystem.client.widgets.Masthead injectee) {
    
  }
  
  private com.eddy.cribz.bookingSystem.client.widgets.Masthead create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$Masthead$_annotation$$none$$() {
    Object created = GWT.create(com.eddy.cribz.bookingSystem.client.widgets.Masthead.class);
    assert created instanceof com.eddy.cribz.bookingSystem.client.widgets.Masthead;
    com.eddy.cribz.bookingSystem.client.widgets.Masthead result = (com.eddy.cribz.bookingSystem.client.widgets.Masthead) created;
    
    memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$Masthead$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.Masthead declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.Masthead, annotation=[none]]
   */
  private com.eddy.cribz.bookingSystem.client.widgets.Masthead get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$Masthead$_annotation$$none$$() {
    return create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$Masthead$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$(com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl injectee) {
    
  }
  
  private com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl create_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$() {
    Object created = GWT.create(com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl.class);
    assert created instanceof com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl;
    com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl result = (com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl) created;
    
    memberInject_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl, annotation=[none]]
   */
  private com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl get_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.gin.ProcnetPlaceManager declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.gin.ProcnetPlaceManager, annotation=[none]]
   */
  private void memberInject_Key$type$com$eddy$cribz$bookingSystem$client$gin$ProcnetPlaceManager$_annotation$$none$$(com.eddy.cribz.bookingSystem.client.gin.ProcnetPlaceManager injectee) {
    
  }
  
  private com.eddy.cribz.bookingSystem.client.gin.ProcnetPlaceManager com$eddy$cribz$bookingSystem$client$gin$ProcnetPlaceManager_ProcnetPlaceManager_methodInjection(com.google.web.bindery.event.shared.EventBus _0, com.gwtplatform.mvp.client.proxy.TokenFormatter _1, java.lang.String _2) {
    return new com.eddy.cribz.bookingSystem.client.gin.ProcnetPlaceManager(_0, _1, _2);
  }
  
  private com.eddy.cribz.bookingSystem.client.gin.ProcnetPlaceManager create_Key$type$com$eddy$cribz$bookingSystem$client$gin$ProcnetPlaceManager$_annotation$$none$$() {
    com.eddy.cribz.bookingSystem.client.gin.ProcnetPlaceManager result = com$eddy$cribz$bookingSystem$client$gin$ProcnetPlaceManager_ProcnetPlaceManager_methodInjection(get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$(), get_Key$type$java$lang$String$_annotation$$com$eddy$cribz$bookingSystem$client$gin$DefaultPlace$());
    memberInject_Key$type$com$eddy$cribz$bookingSystem$client$gin$ProcnetPlaceManager$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.gin.ProcnetPlaceManager declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.gin.ProcnetPlaceManager, annotation=[none]]
   */
  private com.eddy.cribz.bookingSystem.client.gin.ProcnetPlaceManager get_Key$type$com$eddy$cribz$bookingSystem$client$gin$ProcnetPlaceManager$_annotation$$none$$() {
    return create_Key$type$com$eddy$cribz$bookingSystem$client$gin$ProcnetPlaceManager$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.StatusBar declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.StatusBar, annotation=[none]]
   */
  private void memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$StatusBar$_annotation$$none$$(com.eddy.cribz.bookingSystem.client.widgets.StatusBar injectee) {
    
  }
  
  private com.eddy.cribz.bookingSystem.client.widgets.StatusBar create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$StatusBar$_annotation$$none$$() {
    Object created = GWT.create(com.eddy.cribz.bookingSystem.client.widgets.StatusBar.class);
    assert created instanceof com.eddy.cribz.bookingSystem.client.widgets.StatusBar;
    com.eddy.cribz.bookingSystem.client.widgets.StatusBar result = (com.eddy.cribz.bookingSystem.client.widgets.StatusBar) created;
    
    memberInject_Key$type$com$eddy$cribz$bookingSystem$client$widgets$StatusBar$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.widgets.StatusBar declared at:
   *   Implicit binding for Key[type=com.eddy.cribz.bookingSystem.client.widgets.StatusBar, annotation=[none]]
   */
  private com.eddy.cribz.bookingSystem.client.widgets.StatusBar get_Key$type$com$eddy$cribz$bookingSystem$client$widgets$StatusBar$_annotation$$none$$() {
    return create_Key$type$com$eddy$cribz$bookingSystem$client$widgets$StatusBar$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.web.bindery.event.shared.SimpleEventBus declared at:
   *   Implicit binding for Key[type=com.google.web.bindery.event.shared.SimpleEventBus, annotation=[none]]
   */
  private void memberInject_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$(com.google.web.bindery.event.shared.SimpleEventBus injectee) {
    
  }
  
  private com.google.web.bindery.event.shared.SimpleEventBus create_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$() {
    Object created = GWT.create(com.google.web.bindery.event.shared.SimpleEventBus.class);
    assert created instanceof com.google.web.bindery.event.shared.SimpleEventBus;
    com.google.web.bindery.event.shared.SimpleEventBus result = (com.google.web.bindery.event.shared.SimpleEventBus) created;
    
    memberInject_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.google.web.bindery.event.shared.SimpleEventBus declared at:
   *   Implicit binding for Key[type=com.google.web.bindery.event.shared.SimpleEventBus, annotation=[none]]
   */
  private com.google.web.bindery.event.shared.SimpleEventBus get_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$() {
    return create_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.RootPresenter$RootView declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.RootPresenter$RootView, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$(com.gwtplatform.mvp.client.RootPresenter.RootView injectee) {
    
  }
  
  private com.gwtplatform.mvp.client.RootPresenter.RootView create_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$() {
    Object created = GWT.create(com.gwtplatform.mvp.client.RootPresenter.RootView.class);
    assert created instanceof com.gwtplatform.mvp.client.RootPresenter.RootView;
    com.gwtplatform.mvp.client.RootPresenter.RootView result = (com.gwtplatform.mvp.client.RootPresenter.RootView) created;
    
    memberInject_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.RootPresenter$RootView declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.RootPresenter$RootView, annotation=[none]]
   */
  private com.gwtplatform.mvp.client.RootPresenter.RootView get_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.DefaultExceptionHandler declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.DefaultExceptionHandler, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$(com.gwtplatform.dispatch.client.DefaultExceptionHandler injectee) {
    
  }
  
  private com.gwtplatform.dispatch.client.DefaultExceptionHandler create_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$() {
    Object created = GWT.create(com.gwtplatform.dispatch.client.DefaultExceptionHandler.class);
    assert created instanceof com.gwtplatform.dispatch.client.DefaultExceptionHandler;
    com.gwtplatform.dispatch.client.DefaultExceptionHandler result = (com.gwtplatform.dispatch.client.DefaultExceptionHandler) created;
    
    memberInject_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.DefaultExceptionHandler declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.DefaultExceptionHandler, annotation=[none]]
   */
  private com.gwtplatform.dispatch.client.DefaultExceptionHandler get_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.dispatch.shared.SecurityCookieAccessor declared at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:180)
   */
  private com.gwtplatform.dispatch.shared.SecurityCookieAccessor create_Key$type$com$gwtplatform$dispatch$shared$SecurityCookieAccessor$_annotation$$none$$() {
    return get_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.shared.SecurityCookieAccessor declared at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:180)
   */
  private com.gwtplatform.dispatch.shared.SecurityCookieAccessor get_Key$type$com$gwtplatform$dispatch$shared$SecurityCookieAccessor$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$dispatch$shared$SecurityCookieAccessor$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter$MyProxy declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:125)
   */
  private void memberInject_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyProxy$_annotation$$none$$(com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyProxy injectee) {
    
  }
  
  private com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyProxy create_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyProxy$_annotation$$none$$() {
    Object created = GWT.create(com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyProxy.class);
    assert created instanceof com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyProxy;
    com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyProxy result = (com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyProxy) created;
    
    memberInject_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyProxy$_annotation$$none$$(result);
    return result;
  }
  
  private com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyProxy singleton_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyProxy$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:125)
   */
  private com.eddy.cribz.bookingSystem.client.presenters.MainPagePresenter.MyProxy get_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyProxy$_annotation$$none$$() {
    if (singleton_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyProxy$_annotation$$none$$ == null) {
      singleton_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyProxy$_annotation$$none$$ = create_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyProxy$_annotation$$none$$();
    }
    return singleton_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyProxy$_annotation$$none$$;
  }
  
  public MyGinjectorImpl() {
    // Eager singleton bound at:
    //   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:181)
    get_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$();
    // Eager singleton bound at:
    //   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:49)
    get_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$();
    // Eager singleton bound at:
    //   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:125)
    get_Key$type$com$eddy$cribz$bookingSystem$client$presenters$MainPagePresenter$MyProxy$_annotation$$none$$();
    
  }
  
}
