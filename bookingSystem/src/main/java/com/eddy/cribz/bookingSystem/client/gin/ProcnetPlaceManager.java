/**
 * 
 */
package com.eddy.cribz.bookingSystem.client.gin;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

/**
 * @author Planet Developer 001
 * 
 */
public class ProcnetPlaceManager extends PlaceManagerImpl {
	private final PlaceRequest defaultPlaceRequest;

	/**
	 * @param eventBus
	 * @param tokenFormatter
	 */
	@Inject
	public ProcnetPlaceManager(final EventBus eventBus,
			final TokenFormatter tokenFormatter,
			@DefaultPlace String defaultNameToken) {
		super(eventBus, tokenFormatter);
		this.defaultPlaceRequest = new PlaceRequest(defaultNameToken);

	}

	public void revealDefaultPlace() {
		revealPlace(defaultPlaceRequest);

	}
}
