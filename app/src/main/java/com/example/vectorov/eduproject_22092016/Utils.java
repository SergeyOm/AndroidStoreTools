package com.example.vectorov.eduproject_22092016;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by vectorov on 17.10.2016.
 */

public class Utils {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Log.v(TAG, " ConnectivityManager: " + " " + "networkInfo.isConnected()");
            return true;
        } else {
            Log.v(TAG, " ConnectivityManager: " + " " + "networkInfo = null");
            return false;
        }
    }
}
