package com.sarvan.recyclerviewtest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.sarvan.recyclerviewtest.model.Doc;
import com.sarvan.recyclerviewtest.model.Model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Sarvan on 19/07/17.
 */

public class VolleyFragment extends Fragment {
    private ArrayList<String> symbols = new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView textView;
    private LinearLayout progressBar;
    private LinearLayoutManager layoutManager;
    private long startTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.volley_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        textView = view.findViewById(R.id.textView);
        progressBar = view.findViewById(R.id.linlaHeaderProgress);
        layoutManager = new LinearLayoutManager(getActivity());
        if (symbols.size() == 0 && Helper.networkConnected(getActivity())) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
        if (Helper.networkConnected(getActivity())) {
            startTime = System.currentTimeMillis();
            String URL = "https://www.stockalapi.com/api/streams/symbols/4/trending/20";
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    progressBar.setVisibility(View.GONE);
                    Gson gson = new Gson();
                    Model responseModel = gson.fromJson(response.toString(), Model.class);
                    long elapsedTime = System.currentTimeMillis() - startTime;
                    Toast.makeText(getActivity(), String.valueOf(elapsedTime/1000)+" Sec", Toast.LENGTH_LONG).show();
                    if (responseModel != null && responseModel.docs.size() > 0) {
                        progressBar.setVisibility(View.GONE);
                        for (int i = 0; i < responseModel.docs.size(); i++) {
                            Doc doc = responseModel.docs.get(i);
                            symbols.add(doc.code);
                        }
                        recyclerView.setLayoutManager(layoutManager);
                        TrendingAdapter trendingAdapter = new TrendingAdapter(getActivity(), symbols);
                        recyclerView.setAdapter(trendingAdapter);
                    } else {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("NO DATA");
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressBar.setVisibility(View.VISIBLE);
                    Log.i("$$$$$$$$$$$$$", error.toString());
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("accept", "application/json");
                    params.put("stockal-secret-key", "CSee0VMAcZwo60ZHRlvhSeD8gwviaF1FfECbRAd3mKb1wNccCWF");
                    return params;
                }
            };
            // RetryPolicy 5secs delay...
            RetryPolicy policy = new DefaultRetryPolicy(5000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            request.setRetryPolicy(policy);
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            queue.add(request);
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText("Internet is not connected...");
        }
        return view;
    }
}
