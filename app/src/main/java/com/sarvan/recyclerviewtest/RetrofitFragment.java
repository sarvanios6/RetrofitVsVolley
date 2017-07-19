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

import com.sarvan.recyclerviewtest.model.Doc;
import com.sarvan.recyclerviewtest.model.Model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sarvan on 19/07/17.
 */

public class RetrofitFragment extends Fragment {
    private ArrayList<String> symbols = new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView textView;
    private LinearLayout progressBar;
    private LinearLayoutManager layoutManager;
    private long startTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.retrofit_fragment, container, false);
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
            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<Model> call = apiInterface.getSymbols();
            call.enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {
                    Model responseModel = response.body();
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

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Log.i("$$$$$$$$$$$$$", t.toString());
                    progressBar.setVisibility(View.VISIBLE);
                }
            });
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText("Internet is not connected...");
        }
        return view;
    }
}
