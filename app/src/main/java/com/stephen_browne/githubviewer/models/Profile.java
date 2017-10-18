package com.stephen_browne.githubviewer.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.stephen_browne.githubviewer.Utils.ProfilePreparedCallbacks;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by steph on 10/16/2017.
 */

public class Profile {
    private String login;
    private Bitmap image;
    private String url;
    private String followersURL;
    private String followingURL;
    private String gistsURL;
    private String starredURL;
    private String organizationsURL;
    private String reposURL;
    private String name;
    private String company;
    private String location;
    private int numRepos;
    private int numGists;
    private int numFollowers;
    private int numFollowing;


    public Profile(JSONObject json, final ProfilePreparedCallbacks callbacks, Context context) throws JSONException{
        String loginVal = json.getString("login");
        String bitmapURL = json.getString("avatar_url");
        String urlVal = json.getString("url");
        String followersURL = json.getString("followers_url");
        String followingURL = json.getString("following_url");
        String gistsURL = json.getString("gists_url");
        String starredURL = json.getString("starred_url");
        String organizationsURL = json.getString("organizations_url");
        String reposURL = json.getString("repos_url");
        String name = json.getString("name");
        String company = json.getString("company");
        String location = json.getString("location");
        int numRepos = json.getInt("public_repos");
        int numGists = json.getInt("public_gists");
        int numFollowers = json.getInt("followers");
        int numFollowing = json.getInt("following");
        this.login = loginVal;
//        this.image = DataAccessObject.getBitmapFromURL(bitmapURL);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        imageLoader.loadImage(bitmapURL, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Profile.this.image = loadedImage;
                callbacks.onProfilePreparedSuccess(Profile.this);
            }
        });
        this.url = urlVal;
        this.followersURL = followersURL;
        this.followingURL = followingURL;
        this.gistsURL = gistsURL;
        this.starredURL = starredURL;
        this.organizationsURL = organizationsURL;
        this.reposURL = reposURL;
        this.name = name;
        this.company = company;
        this.location = location;
        this.numRepos = numRepos;
        this.numGists = numGists;
        this.numFollowers = numFollowers;
        this.numFollowing = numFollowing;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getFollowersURL() {
        return followersURL;
    }

    public void setFollowersURL(String followersURL) {
        this.followersURL = followersURL;
    }

    public String getFollowingURL() {
        return followingURL;
    }

    public void setFollowingURL(String followingURL) {
        this.followingURL = followingURL;
    }

    public String getGistsURL() {
        return gistsURL;
    }

    public void setGistsURL(String gistsURL) {
        this.gistsURL = gistsURL;
    }

    public String getStarredURL() {
        return starredURL;
    }

    public void setStarredURL(String starredURL) {
        this.starredURL = starredURL;
    }

    public String getOrganizationsURL() {
        return organizationsURL;
    }

    public void setOrganizationsURL(String organizationsURL) {
        this.organizationsURL = organizationsURL;
    }

    public String getReposURL() {
        return reposURL;
    }

    public void setReposURL(String reposURL) {
        this.reposURL = reposURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumRepos() {
        return numRepos;
    }

    public void setNumRepos(int numRepos) {
        this.numRepos = numRepos;
    }

    public int getNumGists() {
        return numGists;
    }

    public void setNumGists(int numGists) {
        this.numGists = numGists;
    }

    public int getNumFollowers() {
        return numFollowers;
    }

    public void setNumFollowers(int numFollowers) {
        this.numFollowers = numFollowers;
    }

    public int getNumFollowing() {
        return numFollowing;
    }

    public void setNumFollowing(int numFollowing) {
        this.numFollowing = numFollowing;
    }
}
