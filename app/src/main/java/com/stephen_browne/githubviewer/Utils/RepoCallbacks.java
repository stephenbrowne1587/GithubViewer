package com.stephen_browne.githubviewer.Utils;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;

/**
 * Created by steph on 10/19/2017.
 */

public interface RepoCallbacks {

    void onRepoSuccess(JSONArray repos);
    void onRepoFailure(VolleyError error);
}
