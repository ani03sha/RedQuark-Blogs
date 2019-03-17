package org.redquark.osgi.starter.core.services;

/**
 * @author Anirudh Sharma
 *
 */
public interface DictionaryService {
	
	/**
	 * This method checks if the passed word is present in the dictionary or not
	 * @param word
	 * @return {@link Boolean}
	 */
	public boolean checkWord(String word);

}
