package com.eddy.cribz.bookingSystem.client;

import com.allen_sauer.gwt.log.client.Log;
import com.eddy.cribz.bookingSystem.client.gin.MyGinjector;
import com.eddy.cribz.bookingSystem.client.utils.Constants;
import com.eddy.cribz.bookingSystem.client.utils.CribzMessages;
import com.eddy.cribz.bookingSystem.client.utils.UiUtils;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.Window;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class bookingSystem implements EntryPoint {

	public final MyGinjector procnetGinjector = GWT.create(MyGinjector.class);
	private static Constants constants;

	private static CribzMessages messages;
	private long startTimeMillis;

	public void onModuleLoad() {

		Log.setUncaughtExceptionHandler();

		// use deferred command to catch initialization exceptions in
		// onModuleLoad2
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			public void execute() {
				onModuleLoad2();
			}
		});

	}

	private void onModuleLoad2() {
		try {

			if (!Log.isLoggingEnabled()) {
				Window.alert("Logging is disabled.");
			}

			if (Log.isDebugEnabled()) {
				startTimeMillis = System.currentTimeMillis();
			}

			// No code guard necessary as the code will be
			// complied out when log_level=OFF
			Log.debug("onModuleLoad2()");
			// Log.trace("This is a 'TRACE' test message");
			// Log.info("This is a 'INFO' test message");
			// Log.warn("This is a 'WARN' test message");
			// Log.error("This is a 'ERROR' test message");
			// Log.fatal("This is a 'FATAL' test message");

			// Auto-publish the method into JS when the GWT module loads.
			// initComplete(this);

			constants = (Constants) GWT.create(Constants.class);

			messages = (CribzMessages) GWT.create(CribzMessages.class);

			DelayedBindRegistry.bind(procnetGinjector);

			procnetGinjector.getPlaceManager().revealCurrentPlace();

			// Use a code guard e.g. "if (Log.isDebugEnabled() {...}"
			// to ensure unnecessary code is complied out when log_level=OFF
			// or any log_level higher than DEBUG
			if (Log.isDebugEnabled()) {
				long endTimeMillis = System.currentTimeMillis();
				float durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
				Log.debug("Duration: " + durationSeconds + " seconds");
			}

		} catch (Exception e) {
			Log.error("e: " + e);
			e.printStackTrace();

			Window.alert(e.getMessage());
		}
	}

	/**
	 * @return the procnetGinjector
	 */
	public MyGinjector getProcnetGinjector() {
		return procnetGinjector;
	}

	/**
	 * @return the constants
	 */
	public static Constants getConstants() {
		return constants;
	}

	public static void logout() {
		UiUtils.goToRelativePage("ServiceLogout");
	}

	/**
	 * @return the messages
	 */
	public static CribzMessages getMessages() {
		return messages;
	}
 
}
