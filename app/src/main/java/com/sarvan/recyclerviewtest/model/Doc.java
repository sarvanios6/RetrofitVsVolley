
package com.sarvan.recyclerviewtest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Doc {
    @SerializedName("code")
    public String code;
    @SerializedName("company")
    public String company;
    @SerializedName("52WeekLow")
    public String _52WeekLow;
    @SerializedName("52WeekHigh")
    public String _52WeekHigh;
    @SerializedName("lastTradePrice")
    public String lastTradePrice;
    @SerializedName("price")
    public List<Price> price = null;
    @SerializedName("historicalPrice")
    public List<HistoricalPrice> historicalPrice = null;
    @SerializedName("change")
    public String change;
    @SerializedName("eps")
    public String eps;
    @SerializedName("peRatio")
    public String peRatio;
    @SerializedName("socialVelocity")
    public SocialVelocity socialVelocity;
    @SerializedName("sentiments")
    public List<Sentiment> sentiments = null;
    @SerializedName("historicalSentiments")
    public List<HistoricalSentiment> historicalSentiments = null;
    @SerializedName("sentimentIndex")
    public SentimentIndex sentimentIndex;
    @SerializedName("revenuePrediction")
    public String revenuePrediction;
    @SerializedName("estimize")
    public List<Estimize> estimize = null;
    @SerializedName("div")
    public String div;
    @SerializedName("mrktCap")
    public String mrktCap;
    @SerializedName("confidenceMeter")
    public String confidenceMeter;
    @SerializedName("averageTargetPrice")
    public String averageTargetPrice;
    @SerializedName("cmChangeDate")
    public String cmChangeDate;
}
