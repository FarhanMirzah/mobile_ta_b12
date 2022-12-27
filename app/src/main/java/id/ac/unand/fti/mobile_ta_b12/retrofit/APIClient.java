package id.ac.unand.fti.mobile_ta_b12.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static  InterfaceDosen service;
    public static InterfaceDosen getService() {

        if (service == null) {
            String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.client(httpClient.build()).build();

            service = retrofit.create(InterfaceDosen.class);
        }
        return service;

    }
}
