package org.redquark.retrofit.xmlparser.api;

import org.redquark.retrofit.xmlparser.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Anirudh Sharma
 *
 * This is the REST API for Retrofit via interface
 */
public interface RSSAPI {

	@GET("rssfeedstopstories.cms")
	Call<Feed> getFeed();
}
