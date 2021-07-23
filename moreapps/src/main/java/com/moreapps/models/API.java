package com.moreapps.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moreapps.interfaces.MoreAppsList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    Gson gson = new GsonBuilder().setLenient().create();

    private static <T> T builder(Class<T> endpoint) {
        return new Retrofit.Builder()
                .baseUrl("http://srcinappads.srcinfoworld.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(endpoint);

    }

    public static MoreAppsList moreAppsList() { return builder(MoreAppsList.class); }


}
