package com.stephen_browne.githubviewer.Utils;

import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;

import org.json.JSONObject;

/**
 * Created by steph on 10/15/2017.
 */

public interface ProfileCallbacks {
    void onProfileSuccess(JSONObject profileJSON);
    void onProfileFailure(VolleyError error);

}
