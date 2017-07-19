package com.sarvan.recyclerviewtest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Sarvan on 19/07/17.
 */

public class Helper {

    public static boolean networkConnected(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
