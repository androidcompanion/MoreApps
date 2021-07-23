package com.moreapps.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoreApps {

@SerializedName("Success")
@Expose
private Integer success;
@SerializedName("Message")
@Expose
private String message;
@SerializedName("Category Data")
@Expose
private List<AppsDetails> appsDetailsList = null;

public Integer getSuccess() {
return success;
}

public void setSuccess(Integer success) {
this.success = success;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public List<AppsDetails> getAppsDetailsList() {
return appsDetailsList;
}

public void setAppsDetailsList(List<AppsDetails> appsDetailsList) {
this.appsDetailsList = appsDetailsList;
}

}