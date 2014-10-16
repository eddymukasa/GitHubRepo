package com.eddy.cribz.bookingSystem.core.templating;

import java.util.HashMap;

public interface TemplatingEngine {

	/**
	 * default placeholder for name
	 */
	static final String DEFAULT_PLACEHOLDER_NAME = "${name}";
	
	
	/**
	 * 
	 */
	static final String RESPONSIBLE_OFFICER = "${officer}";
	
	/**
	 * 
	 */
	static final String PROJECT_STARTDATE = "${startdate}";
	
	/**
	 * 
	 */
	static final String PROJECT_ENDDATE = "${enddate}";
	/**
	 * default place holder for a link
	 */
	static final String DEFAULT_PLACEHOLDER_LINK = "${link}";
	/**
	 * default place holder for a password
	 */
	static final String DEFAULT_PLACEHOLDER_PASSWORD = "${password}";

	static final String DEFAULT_PLACEHOLDER_TASK_NAME = "${taskname}";

	static final String DEFAULT_PLACEHOLDER_TASK_INPUTFORM_PARAMETER = "${inputPlanFormId }";

	static final String DEFAULT_PLACEHOLDER_TASK_APPROVEPLANFORM_PARAMETER = "${approvePlanFormId}";
	/**
	 * the application settings key that can be used to access the value for the
	 * placeholder {@link #DEFAULT_PLACEHOLDER_NAME} if a value is not supplied
	 * in a place holder map when using the {@link #process(HashMap, String)}
	 * method
	 */
	static String APP_SETTING_KEY_DEFAULT_NAME_PLACEHOLDER_VALUE = "NAME_PLACEHOLDER_VALUE";

	/**
	 * the default value for the {@link #DEFAULT_PLACEHOLDER_NAME} of a value is
	 * not supplied in a place holder map when using the
	 * {@link #process(HashMap, String)} method
	 */
	static String DEFAULT_NAME_PLACEHOLDER_VALUE = "Friend";

	/**
	 * process a given message by replacing the placeholders with their values
	 * as given in the placeHolderMap
	 * 
	 * @param placeHolderMap
	 *            hash map containing the placeholders to be processed. The
	 *            first parameter string in the map is the placeholder while the
	 *            second parameter is the value to replace the placeholder in
	 *            the given messag.
	 * @param message
	 * @return
	 */
	String process(HashMap<String, String> placeHolderMap, String message);
}
