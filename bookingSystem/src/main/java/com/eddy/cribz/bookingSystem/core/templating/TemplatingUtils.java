package com.eddy.cribz.bookingSystem.core.templating;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class TemplatingUtils {

	/**
	 * loads a template represented by the given path and returns the content as
	 * a string
	 * 
	 * @param templatePath
	 * @return
	 * @throws IOException
	 */
	public static String getTemplateString(String templatePath)
			throws IOException {
		InputStream stream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(templatePath);
		return IOUtils.toString(stream, "UTF-8");
	}
}
