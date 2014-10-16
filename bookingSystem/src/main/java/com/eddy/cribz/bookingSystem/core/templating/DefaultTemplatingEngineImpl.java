package com.eddy.cribz.bookingSystem.core.templating;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Implementation of the {@link TemplatingEngine} to provide support for the
 * place holder replacement in emails and sms messages. <br/>
 * <br/>
 * 
 */
@Component("templatingEngine")
public class DefaultTemplatingEngineImpl implements TemplatingEngine {

	public String process(HashMap<String, String> placeHolderMap, String message) {
		if (placeHolderMap != null) {

			Iterator<String> keys = placeHolderMap.keySet().iterator();
			if (keys != null) {
				while (keys.hasNext()) {

					String placeHolder = keys.next();
					if (StringUtils.isNotBlank(placeHolder)
							&& message.contains(placeHolder)) {
						String replacementValue = placeHolderMap
								.get(placeHolder);

						if (StringUtils.isBlank(replacementValue))
							replacementValue = "Unknown";

						message = message
								.replace(placeHolder, replacementValue);
					}
				}
			}
		}

		return message;
	}

}
