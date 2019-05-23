package org.redquark.aem.bulkusercreation.core.services;

import java.util.List;

import org.redquark.aem.bulkusercreation.core.models.UserDetails;

/**
 * @author Anirudh Sharma
 */
public interface UserCreationService {

	/**
	 * This method takes the users in the form of a list and create them one by one
	 * in AEM instance
	 * 
	 * @param users
	 */
	void createUsers(List<UserDetails> users);
}
