package id.ac.unand.fti.mobile_ta_b12.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetLogbookResponse {

	@SerializedName("count")
	private int count;

	@SerializedName("logbooks")
	private List<LogbooksItem> logbooks;

	@SerializedName("status")
	private String status;

	public int getCount(){
		return count;
	}

	public List<LogbooksItem> getLogbooks(){
		return logbooks;
	}

	public String getStatus(){
		return status;
	}
}