package id.ac.unand.fti.mobile_ta_b12.models;

import com.google.gson.annotations.SerializedName;

public class PembatalanTugasAkhirResponse{

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}