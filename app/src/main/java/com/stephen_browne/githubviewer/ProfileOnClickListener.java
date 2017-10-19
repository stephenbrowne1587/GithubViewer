package com.stephen_browne.githubviewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.stephen_browne.githubviewer.Utils.DataAccessObject;
import com.stephen_browne.githubviewer.Utils.RepoCallbacks;
import com.stephen_browne.githubviewer.models.Profile;
import com.stephen_browne.githubviewer.models.Repository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by steph on 10/19/2017.
 */

public class ProfileOnClickListener implements View.OnClickListener, RepoCallbacks {
    private Context context;
    private RecyclerView recyclerView;
    private MainActivity mainActivity;
    private Profile profile;

    public ProfileOnClickListener(Context context, RecyclerView recyclerView,
                                  MainActivity mainActivity, Profile profile) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.mainActivity = mainActivity;
        this.profile = profile;
    }

    @Override
    public void onClick(View v) {
        int position = recyclerView.getChildLayoutPosition(v);
        switch(position){
            case 0:
//                mainActivity.profileToRepos();
                DataAccessObject.getRepos(context, profile.getReposURL(), this);


        }
//        Toast.makeText(context, "clicked " + position, Toast.LENGTH_SHORT).show();

    }
    private ArrayList<Repository> getRepositoryList(JSONArray repos) throws JSONException{
        ArrayList<Repository> reposArrayList = new ArrayList<>();
        for (int i = 0; i < repos.length(); i++) {
            Repository curRepo = new Repository(repos.getJSONObject(i));
            reposArrayList.add(curRepo);
        }
        return reposArrayList;
    }

    @Override
    public void onRepoSuccess(JSONArray repos)  {
        try {
            mainActivity.profileToRepos(getRepositoryList(repos));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRepoFailure(VolleyError error) {

    }
}
