package dev.smart.e_akademik.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fnatic Anxdre on 3/22/2018.
 */

public class Retrofit_Instance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://api.learn2crack.com";

    public static Retrofit getRetrofit() {

        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
