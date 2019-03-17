package org.redquark.retrofit.xmlparser.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author Anirudh Sharma
 * 
 * The 'Article' class represents one single article and only stores the title, link and description of it.
 */
@Root(name = "item", strict = false)
public class Article {

	@Element(name = "title")
	private String title;
	
	@Element(name = "link")
	private String link;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

}
