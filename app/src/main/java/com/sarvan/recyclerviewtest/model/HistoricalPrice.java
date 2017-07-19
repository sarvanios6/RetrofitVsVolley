
package com.sarvan.recyclerviewtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoricalPrice {

    @SerializedName("price")

    public String price;
    @SerializedName("date")

    public String date;
    @SerializedName("timeStamp")

    public String timeStamp;

}
