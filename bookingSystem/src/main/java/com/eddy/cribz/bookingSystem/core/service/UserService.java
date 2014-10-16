package com.eddy.cribz.bookingSystem.core.service;

import java.util.List;

import com.eddy.cribz.bookingSystem.model.Permission;
import com.eddy.cribz.bookingSystem.model.Role;
import com.eddy.cribz.bookingSystem.model.User;
import com.eddy.cribz.bookingSystem.model.exceptions.OperationFailedException;
import com.eddy.cribz.bookingSystem.model.exceptions.SessionExpiredException;
import com.eddy.cribz.bookingSystem.model.exceptions.ValidationFailedException;
import com.googlecode.genericdao.search.Search;

/**
 * @author
 */
public interface UserService {

	/**
	 * @param user
	 */
	public void activateUserAccount(User user);

	/**
	 * @param id
	 * @return
	 */
	//PasswordPolicy getPasswordPolicyById(String id);
	
	/**
	 * @param policy
	 */
	/*void activatePolicy(PasswordPolicy policy);
	
	*//**
	 * @return
	 *//*
	List<PasswordPolicy> getPasswordpolicies();
	
	*//**
	 * @param policy
	 * @return
	 * @throws ValidationFailedException
	 *//*
	PasswordPolicy editPasswordPolicy(PasswordPolicy policy) throws ValidationFailedException;
	
	*//**
	 * @param policy
	 * @return
	 * @throws ValidationFailedException
	 *//*
	PasswordPolicy savePasswordPolicy(PasswordPolicy policy) throws ValidationFailedException;
	
	*//**
	 * @param policy
	 *//*
	void deletePasswordPolicy(PasswordPolicy policy);
	*/
	/**
	 * @param user
	 * @throws ValidationFailedException
	 */
	void enforcePasswordPolicy(User user) throws ValidationFailedException;
	/**
	 * changes the password for the given user. Using the given clear text
	 * password
	 * 
	 * @param password
	 *            new password for the user.
	 * @param user
	 *            the user whose password is to be changed.
	 * @throws ValidationFailedException
	 */
	void changePassword(String password, User user)
			throws ValidationFailedException;

	/**
	 * 
	 * @param password
	 *            new password for the user
	 * @param user
	 *            the user whose password is to be changed
	 * @param sendChangePasswordNotification
	 *            whether to send a change password notification.
	 * @throws ValidationFailedException
	 */
	User changePassword(String password, User user,
			boolean sendChangePasswordNotification)
					throws ValidationFailedException;

	User changePassword(String password, User user,
			boolean sendChangePasswordNotification,
			boolean enforcePasswordPolicy) throws ValidationFailedException;

	/**
	 * @param search
	 * @return
	 */
	int countUsers(Search search);

	/**
	 * @param user
	 * @throws ValidationFailedException 
	 * @throws SessionExpiredException 
	 */
	public void deactivateUserAccount(User user) throws ValidationFailedException, SessionExpiredException;

	/**
	 * deletes a given role from the system
	 * 
	 * @param role
	 * @throws OperationFailedException
	 *             thrown when the delete operation fails.
	 * @throws ValidationFailedException 
	 */
	void deleteRole(Role role) throws OperationFailedException, ValidationFailedException;

	/**
	 * deletes a given user from the system
	 * 
	 * @param user
	 * @throws OperationFailedException
	 *             thrown when the delete operation fails
	 * @throws ValidationFailedException 
	 */
	void deleteUser(User user) throws OperationFailedException, ValidationFailedException;

	/**
	 * @param role
	 * @return
	 * @throws ValidationFailedException
	 */
	Role editRole(Role role) throws ValidationFailedException;

	/**
	 * @param user
	 * @return
	 * @throws ValidationFailedException
	 */
	User editUser(User user) throws ValidationFailedException;

	/**
	 * finds roles whose name(s) are like the searchString provided. This means
	 * that if a search string like 'ct' is provided, all roles whose names
	 * begin with ct characters are returned
	 * 
	 * @param searchString
	 * @return
	 */
	List<Role> findRolesByName(String searchString);

	/**
	 * gets a user based on their username
	 * 
	 * @param username
	 *            string for login name
	 * @return User or null if no much found
	 */
	User findUserByUsername(String username);

	/**
	 * finds users whose username(s) are like the query provided. This means
	 * that if a query like 'ct' is provided, all users who begin with the ct
	 * characters are returned
	 * 
	 * @param query
	 * @return
	 */
	List<User> findUsersByUsername(String query);

	/**
	 * gets total number of users who meet the search criteria
	 * 
	 * @param query
	 * @return
	 */
	int getNumberOfUsersInSearch(String query);

	/**
	 * gets the permission with the given id
	 * 
	 * @param id
	 * @return
	 */
	Permission getPermissionById(String id);

	/**
	 * gets a list of all permissions
	 * 
	 * @return
	 */
	List<Permission> getPermissions();

	/**
	 * @param text
	 * @return
	 */
	Role getRoleById(String text);

	/**
	 * gets a list of all
	 * 
	 * @return
	 */
	List<Role> getRoles();

	/**
	 * gets the list of roles starting at the given offset and ending at the
	 * given limit.
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Role> getRoles(int offset, int limit);

	/**
	 * gets the roles for a given user starting at the given offset and ending
	 * at the given limit.
	 * 
	 * @param user
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Role> getRoles(User user, int offset, int limit);

	/**
	 * gets a list of roles on a given page number
	 * 
	 * @param pageNo
	 * @return
	 */
	List<Role> getRolesByPage(Integer pageNo);

	/**
	 * gets the total number of roles in the system.
	 * 
	 * @return
	 */
	int getTotalNumberOfRoles();

	/**
	 * gets the total number of roles for the given user.
	 * 
	 * @param user
	 * @return
	 */
	int getTotalNumberOfRoles(User user);

	/**
	 * @return
	 */
	int getTotalNumberOfUsers();

	/**
	 * gets a user with a given Id
	 * 
	 * @param userId
	 * @return
	 */
	User getUserById(String userId);

	/**
	 * @param roleName
	 * @return
	 */
	User getUserByRoleName(String roleName);

	/**
	 * gets the username with the given username
	 * 
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);

	/**
	 * gets a list of all users in the system
	 * 
	 * @return
	 */
	List<User> getUsers();

	/**
	 * gets the list of users starting at the given offset and ending at the
	 * given limit.
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<User> getUsers(int offset, int limit);

	/**
	 * gets a list of users on a given page number
	 * 
	 * @param pageNo
	 * @return
	 */
	List<User> getUsers(Integer pageNo);

	/**
	 * gets a list of users based on a role with the given name.
	 * 
	 * @param roleName
	 * @return
	 */
	List<User> getUsersByRoleName(String roleName);

	/**
	 * saves a given {@link Permission}
	 * 
	 * @param permission
	 * @throws ValidationFailedException
	 *             thrown when the validation of the user fails.
	 */
	void savePermision(Permission permission) throws ValidationFailedException;

	/**
	 * saves a given role
	 * 
	 * @param role
	 * @return
	 * @throws ValidationFailedException
	 *             thrown when the validation of the user fails.
	 */
	Role saveRole(Role role) throws ValidationFailedException;

	/**
	 * saves a given user
	 * 
	 * @param user
	 * @return
	 * @throws ValidationFailedException
	 *             thrown when the validation of the user fails.
	 */
	User saveUser(User user) throws ValidationFailedException;

	/**
	 * gets a list of users that contain a given query in their name
	 * 
	 * @param query
	 * @return searched user
	 */
	List<User> searchUserByLoginName(String query);

	/**
	 * gets a paged list of users that contain a given query in their name
	 * 
	 * @param query
	 * @param pageNo
	 * @return
	 */
	List<User> searchUserByLoginName(String query, Integer pageNo);

	/**
	 * @param search
	 * @return
	 */
	List<User> searchUsers(Search search);

	/**
	 * @throws ValidationFailedException
	 * @throws SessionExpiredException
	 */
	void validateDisplayAdmin() throws ValidationFailedException,
	SessionExpiredException;

	/**
	 * @throws ValidationFailedException
	 * @throws SessionExpiredException
	 */
	void validateDisplayBudget() throws ValidationFailedException,
	SessionExpiredException;

	/**
	 * @throws ValidationFailedException
	 * @throws SessionExpiredException
	 */
	

	/**
	 * @param roleId
	 * @return
	 */
	List<User> getUsersByRoleId(String roleId);
	
	/**
	 * @param roleId
	 * @return
	 */
	User getUserByRoleId(String roleId);
	
	/**
	 * @param exp
	 */
	//void genRegex(RegularExpression exp);
	
	/**
	 * @return
	 */
	String getPasswordPolicyString();
}
