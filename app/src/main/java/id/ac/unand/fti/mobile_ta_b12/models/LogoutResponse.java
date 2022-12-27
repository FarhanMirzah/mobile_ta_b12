package id.ac.unand.fti.mobile_ta_b12.models;

import com.google.gson.annotations.SerializedName;

public class LogoutResponse{


    @SerializedName("message")
    private String message;

    public String getMessage(){
        return message;
    }
}