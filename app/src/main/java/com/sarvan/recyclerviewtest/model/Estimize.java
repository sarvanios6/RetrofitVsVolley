
package com.sarvan.recyclerviewtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Estimize {

    @SerializedName("_id")

    public String id;
    @SerializedName("timestamp")

    public String timestamp;
    @SerializedName("release_date")

    public String releaseDate;
    @SerializedName("wallstreet_eps_estimate")

    public String wallstreetEpsEstimate;
    @SerializedName("wallstreet_revenue_estimate")

    public String wallstreetRevenueEstimate;
    @SerializedName("consensus_revenue_estimate")

    public String consensusRevenueEstimate;
    @SerializedName("consensus_eps_estimate")

    public String consensusEpsEstimate;
    @SerializedName("revenue")

    public String revenue;
    @SerializedName("eps")

    public String eps;
    @SerializedName("fiscal_quarter")

    public String fiscalQuarter;
    @SerializedName("fiscal_year")

    public String fiscalYear;

}
