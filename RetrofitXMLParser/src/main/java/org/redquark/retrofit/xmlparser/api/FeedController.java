package org.redquark.retrofit.xmlparser.api;

import static org.redquark.retrofit.xmlparser.constants.AppConstants.URL;

import org.redquark.retrofit.xmlparser.model.Feed;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * @author Anirudh Sharma
 *
 */
@SuppressWarnings("deprecation")
public class FeedController implements Callback<Feed> {

	public void run() {

		Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(SimpleXmlConverterFactory.create())
				.build();

		RSSAPI rssapi = retrofit.create(RSSAPI.class);

		Call<Feed> call = rssapi.getFeed();
		call.enqueue(this);
	}

	public void onResponse(Call<Feed> call, Response<Feed> response) {

		if (response.isSuccessful()) {

			Feed feed = response.body();

			System.out.println("Channel Title: " + feed.getChannelTitle());
			System.out.println("----------------------------------------------\n");

			feed.getArticleList().forEach(article -> System.out.println("Title: " + article.getTitle() + "\nLink: "
					+ article.getLink() + "\n"));

		} else {
			System.out.println(response.errorBody());
		}
	}

	public void onFailure(Call<Feed> call, Throwable t) {
		
		t.printStackTrace();

	}

}
