
package com.sarvan.recyclerviewtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sentiment {

    @SerializedName("tsent")

    public String tsent;
    @SerializedName("date")

    public String date;
    @SerializedName("timeStamp")

    public String timeStamp;
    @SerializedName("_id")

    public String id;

}
