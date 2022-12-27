package id.ac.unand.fti.mobile_ta_b12.retrofit;

import id.ac.unand.fti.mobile_ta_b12.models.GetProfileResponse;
import id.ac.unand.fti.mobile_ta_b12.models.LoginResponse;
import id.ac.unand.fti.mobile_ta_b12.models.LogoutResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface InterfaceDosen {
    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login (@Field("username") String username, @Field("password") String password);

    @GET("api/me")
    Call<GetProfileResponse> getProfile(@Header("Authorization") String token);

    @POST("api/logout")
    Call<LogoutResponse> logout(@Header("Authorization") String token);
}
