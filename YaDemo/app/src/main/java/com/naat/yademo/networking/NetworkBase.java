package com.naat.yademo.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkBase {

    public static  String URL_BASE = "https://agentemovil.pagatodo.com";

    public static NetworkService NETWORK_API_SERVICE = null;
    public static NetworkService getNetworkInstance(){
        if(NETWORK_API_SERVICE == null){
            Retrofit retrofit  = new Retrofit.Builder().baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            NETWORK_API_SERVICE = retrofit.create(NetworkService.class);
        }
        return NETWORK_API_SERVICE;
    }
}
