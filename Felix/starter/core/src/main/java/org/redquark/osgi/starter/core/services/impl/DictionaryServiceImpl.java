package org.redquark.osgi.starter.core.services.impl;

import org.redquark.osgi.starter.core.services.DictionaryService;

/**
 * @author Anirudh Sharma
 *
 */
public class DictionaryServiceImpl implements DictionaryService {
	
	String[] words = {"welcome", "to", "the", "osgi", "tutorial"};

	@Override
	public boolean checkWord(String word) {
		
		word = word.toLowerCase();
		
		// Iterate through the entire dictionary one by one - Linear Search
		for(String w : words) {
			
			if(w.equals(word)) {
				return true;
			}
		}
		
		return false;
	}

}
