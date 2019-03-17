package org.redquark.osgi.starter.core;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.redquark.osgi.starter.core.services.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 *
 */
public class DictionaryClientActivator implements BundleActivator {
	
	private static final Logger log = LoggerFactory.getLogger(DictionaryClientActivator.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void start(BundleContext context) throws Exception {
		
		ServiceReference[] refs = context.getServiceReferences(DictionaryService.class.getName(), "(Language=*)");
		
		if(refs != null) {
			
			try {
				
				String word = "osgi";
				
				DictionaryService service = (DictionaryService) context.getService(refs[0]);
				
				if(service.checkWord(word)) {
					
					log.info("Word has found");
				} else {
					log.info("Word has not found");
				}
				
				context.ungetService(refs[0]);
				
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		} else {
			log.info("Could not find any dictionary service");
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
		// The service will be automatically released
	}

}
