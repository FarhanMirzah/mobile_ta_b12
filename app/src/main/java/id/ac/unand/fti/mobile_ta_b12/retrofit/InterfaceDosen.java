package id.ac.unand.fti.mobile_ta_b12.retrofit;

import id.ac.unand.fti.mobile_ta_b12.models.GetLogbookResponse;
import id.ac.unand.fti.mobile_ta_b12.models.GetProfileResponse;
import id.ac.unand.fti.mobile_ta_b12.models.LoginResponse;
import id.ac.unand.fti.mobile_ta_b12.models.LogoutResponse;
import id.ac.unand.fti.mobile_ta_b12.models.PembatalanTugasAkhirResponse;
import id.ac.unand.fti.mobile_ta_b12.models.UpdateProfileResponse;
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

    @FormUrlEncoded
    @POST("api/me/update")
    Call<UpdateProfileResponse> updateProfile(@Header("Authorization") String token, @Field("email") String email, @Field("name") String name);

    @GET("api/theses/309/logbooks")
    Call<GetLogbookResponse> getListLogbook(@Header("Authorization") String token);

    @POST("api/theses/277/trials")
    Call<PembatalanTugasAkhirResponse> batalTA(@Header("Authorization") String token);

    @POST("api/logout")
    Call<LogoutResponse> logout(@Header("Authorization") String token);
}
