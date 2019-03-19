package dev.smart.e_akademik.network;

import dev.smart.e_akademik.model.JSONResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Fnatic Anxdre on 3/22/2018.
 */

public interface API_Interface {
    @GET("android/jsonandroid")
    Call<JSONResponse>getJSON();
}
