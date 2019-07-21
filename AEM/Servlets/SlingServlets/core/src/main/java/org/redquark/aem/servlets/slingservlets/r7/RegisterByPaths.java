package org.redquark.aem.servlets.slingservlets.r7;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 */
@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/servlet/example")
public class RegisterByPaths extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = -6898349387838877172L;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
		log.info("Executing servlet via R7 path type");
		response.getWriter().println("Executing servlet via R7 path type");
	}
}
