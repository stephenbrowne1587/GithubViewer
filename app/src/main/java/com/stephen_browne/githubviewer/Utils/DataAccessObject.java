package com.stephen_browne.githubviewer.Utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by steph on 10/15/2017.
 */

public class DataAccessObject {

    private static final String URL_BASE = "https://api.github.com/users/";

    public static void getProfile(final Context context, final String username, final ProfileCallbacks callbacks) {

        String url = URL_BASE + username;

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    callbacks.onProfileSuccess(new JSONObject(response));
                    Log.i("success", "it worked");
                } catch (JSONException e) {
                    callbacks.onProfileSuccess(new JSONObject());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callbacks.onProfileFailure(error);
                Log.i("error", "It didn't work");

            }
        }){

        };
        queue.add(stringRequest);
    }




}
