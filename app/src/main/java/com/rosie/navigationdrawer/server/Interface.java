package com.rosie.navigationdrawer.server;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Interface {

    @GET("3/discover/{data}")
    Call<ResponseBody> getData(@Path("data")String data,
                               @Query("api_key")String API_KEY,
                               @Query("language")String language);

    @GET("/3/movie/{data}")
    Call<ResponseBody> getData2(@Path("data")String data,
                               @Query("api_key")String API_KEY,
                               @Query("language")String language);





}




