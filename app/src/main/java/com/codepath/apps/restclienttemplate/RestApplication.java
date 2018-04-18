package com.codepath.apps.restclienttemplate;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

/*
 * This is the Android application itself and is used to configure various settings
 * including the image cache in memory and on disk. This also adds a singleton
 * for accessing the relevant rest client.
 *
 *     RestClient client = RestApplication.getRestClient(Context context);
 *     // use client to send requests to API
 *
 */
public class RestApplication extends Application {

    MyDatabase database;

	@Override
	public void onCreate() {
		super.onCreate();

		database = Room.databaseBuilder(this, MyDatabase.class, MyDatabase.DATABASE_NAME).build();
	}

	public static RestClient getRestClient(Context context) {
		return (RestClient) RestClient.getInstance(RestClient.class, context);
	}
}