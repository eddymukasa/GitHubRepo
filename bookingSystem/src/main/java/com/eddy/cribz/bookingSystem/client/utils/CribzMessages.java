package com.eddy.cribz.bookingSystem.client.utils;


import com.google.gwt.i18n.client.Messages;

public interface CribzMessages extends Messages{

	  @DefaultMessage("{0} of {1} selected")
	  String selected(int arg0, int arg1);

	  @DefaultMessage("Page {0}")
	  String page(int arg0);
	  
}
