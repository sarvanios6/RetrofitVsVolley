package com.sarvan.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sarvan.recyclerviewtest.model.Doc;
import com.sarvan.recyclerviewtest.model.Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by Sarvan on 18/07/17.
 */

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> symbols;

    /**
     * Constructor
     */
    TrendingAdapter(Context context, ArrayList<String>symbols) {
        this.context = context;
        this.symbols = symbols;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.symbolView.setText(symbols.get(position));
    }

    @Override
    public int getItemCount() {
        return symbols.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView symbolView;

        public MyViewHolder(View itemView) {
            super(itemView);
            symbolView = (TextView) itemView.findViewById(R.id.symbol_view);
        }
    }
}

