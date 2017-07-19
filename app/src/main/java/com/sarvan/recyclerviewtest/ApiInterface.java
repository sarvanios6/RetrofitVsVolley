package com.sarvan.recyclerviewtest;

import com.sarvan.recyclerviewtest.model.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Sarvan on 18/07/17.
 */

interface ApiInterface {
    @Headers({
            "Accept: application/json",
            "stockal-secret-key: CSeeVMAcZwo60ZHRlvhSeD8gwviaF1FfECbRAd3mKb1wNccCWF"
    })

    @GET("/api/streams/symbols/4/trending/20")
    Call<Model> getSymbols();
}
