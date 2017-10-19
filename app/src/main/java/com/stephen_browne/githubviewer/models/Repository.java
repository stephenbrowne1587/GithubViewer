package com.stephen_browne.githubviewer.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by steph on 10/19/2017.
 */

public class Repository {
    private String name;
    private String description;
    private String url;
    private String language;



    public Repository (JSONObject repoJSON) throws JSONException{
        String name = repoJSON.getString("name");
        String description = repoJSON.getString("description");
        String url = repoJSON.getString("url");
        String language = repoJSON.getString("language");

        this.name = name;
        this.description = description;
        this.url = url;
        this.language = language;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
