package org.redquark.retrofit.gerrit;

import org.redquark.retrofit.gerrit.controller.GerritController;

/**
 * 
 * @author Anirudh Sharma
 * 
 * Main class to run the application
 */
public class GerritApp 
{
	public static void main(String[] args) {
		GerritController controller = new GerritController();
		controller.run();
	}
}
