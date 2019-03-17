package org.redquark.retrofit.gerrit.api;

import java.util.List;

import org.redquark.retrofit.gerrit.model.Change;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Anirudh
 * 
 * API for Gerrit
 */
public interface GerritAPI {

	/**
	 * Get all the changes
	 */
	@GET("changes/")
	Call<List<Change>> getChanges(@Query("q") String status);
}
