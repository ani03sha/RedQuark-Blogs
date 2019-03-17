package org.redquark.osgi.starter.core;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 * This class acts the bundle activator for this bundle
 */
public class Activator implements BundleActivator, ServiceListener {

	// Logger
	private static final Logger log = LoggerFactory.getLogger(Activator.class);

	@Override
	public void start(BundleContext context) throws Exception {
		
		log.info("Starting to listen for service events");
		// Adding the service listener
		context.addServiceListener(this);
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		// Releasing the service listener
		context.removeServiceListener(this);
		log.info("Stopped listening for service events");
	}

	@Override
	public void serviceChanged(ServiceEvent event) {

		String[] classes = (String[]) event.getServiceReference().getProperty("objectClass");

		if (event.getType() == ServiceEvent.REGISTERED) {
			log.info("Service of type " + classes[0] + " is registered");
		} else if (event.getType() == ServiceEvent.UNREGISTERING) {
			log.info("Service of type " + classes[0] + " is unregistering");
		} else if (event.getType() == ServiceEvent.MODIFIED) {
			log.info("Service of type " + classes[0] + " is modified");
		}
	}
}
