package org.redquark.aem.servlets.slingservlets.r7;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 */
@Component(service = Servlet.class)
@SlingServletResourceTypes(
		resourceTypes = "/apps/redquark/servlets/example", 
		methods = "GET", 
		extensions = "html", 
		selectors = "pdf")
public class RegisterByResourceTypes extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 4959156685027825423L;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		log.info("Executing a servlet using new R7 resourceType annotations");
	}
}
