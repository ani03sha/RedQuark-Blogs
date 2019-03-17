package org.redquark.osgi.starter.core;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.redquark.osgi.starter.core.services.DictionaryService;
import org.redquark.osgi.starter.core.services.impl.DictionaryServiceImpl;

/**
 * @author Anirudh Sharma
 *
 */
public class DictionaryActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		
		Dictionary<String, String> props = new Hashtable<>();
		props.put("Language", "English");
		
		context.registerService(DictionaryService.class.getName(), new DictionaryServiceImpl(), props);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

}
