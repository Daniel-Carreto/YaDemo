package com.naat.yademo.networking;

import com.naat.yademo.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface NetworkService {
    @Headers({
            "Content-Type:application/json",
            "SO:Android",
            "Version:2.5.2"
    })
    @POST("/AgenteMovil.svc/agMov/login")
    Call<User> loginRequest(@Body User user);

}
