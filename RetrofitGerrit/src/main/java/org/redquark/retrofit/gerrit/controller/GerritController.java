package org.redquark.retrofit.gerrit.controller;

import java.util.List;

import org.redquark.retrofit.gerrit.api.GerritAPI;
import org.redquark.retrofit.gerrit.constants.AppConstants;
import org.redquark.retrofit.gerrit.model.Change;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Anirudh Sharma
 * 
 * This class calls the API and handles the JSON response.
 */
public class GerritController implements Callback<List<Change>> {

	public void run() {

		Gson gson = new GsonBuilder().setLenient().create();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(AppConstants.URL)
				.addConverterFactory(GsonConverterFactory.create(gson)).build();

		GerritAPI api = retrofit.create(GerritAPI.class);

		Call<List<Change>> call = api.getChanges("status:open");
		call.enqueue(this);
	}

	public void onResponse(Call<List<Change>> call, Response<List<Change>> response) {

		if (response.isSuccessful()) {

			List<Change> changes = response.body();

			changes.forEach(change -> System.out.println("Subject: " + change.getSubject() + "\nStatus: "
					+ change.getStatus() + "\nOwner: " + change.getOwner() + "\nProject: " + change.getProject()
					+ "\nBranch: " + change.getBranch()));
		} else {
			
			System.out.println(response.errorBody());
		}
	}

	public void onFailure(Call<List<Change>> call, Throwable t) {
		
		t.printStackTrace();
	}

}
