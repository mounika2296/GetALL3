package com.l9ench.getall;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by viswanath on 24-01-2017.
 */

public class SecondClass extends Application {
    public static final String TAG = SecondClass.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private static SecondClass mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

    }

    public static synchronized SecondClass getInstance() {
        return mInstance;
    }


    public RequestQueue getRequestQueue() {

        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req) {

        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}

