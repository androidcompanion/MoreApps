package com.moreapps.interfaces;

import com.moreapps.models.MoreApps;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoreAppsList {

    @GET("CategoryDetails")
    Call<MoreApps> getAppsDetails();

}
