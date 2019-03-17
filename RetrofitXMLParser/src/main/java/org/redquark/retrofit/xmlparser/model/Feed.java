/**
 * 
 */
package org.redquark.retrofit.xmlparser.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * @author Anirudh Sharma
 *
 */
@Root(name = "rss", strict = false)
public class Feed {

	@Element(name = "title")
	@Path("channel")
	private String channelTitle;

	@ElementList(name = "item", inline = true)
	@Path("channel")
	private List<Article> articleList;

	/**
	 * @return the channelTitle
	 */
	public String getChannelTitle() {
		return channelTitle;
	}

	/**
	 * @param channelTitle the channelTitle to set
	 */
	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}

	/**
	 * @return the articleList
	 */
	public List<Article> getArticleList() {
		return articleList;
	}

	/**
	 * @param articleList the articleList to set
	 */
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
}
