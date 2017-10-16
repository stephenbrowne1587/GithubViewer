package com.stephen_browne.githubviewer.Utils;

import com.android.volley.VolleyError;
import com.stephen_browne.githubviewer.models.SimpleProfile;

import org.json.JSONObject;

/**
 * Created by steph on 10/16/2017.
 */

public interface ProfilePreparedCallbacks {
    void onProfilePreparedSuccess(SimpleProfile simpleProfile);
    void onProfilePrefaredFailure();
}
