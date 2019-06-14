package com.example.omniademe;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebRequester {

    public WebRequester() {
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit.Builder retrofit = new Retrofit.Builder().baseUrl(String.valueOf(R.string.instagram_url));

    }

}
