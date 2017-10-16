package com.stephen_browne.githubviewer.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.stephen_browne.githubviewer.MainActivity;
import com.stephen_browne.githubviewer.Utils.DataAccessObject;
import com.stephen_browne.githubviewer.Utils.ProfilePreparedCallbacks;

import org.json.JSONObject;

/**
 * Created by steph on 10/16/2017.
 */

public class SimpleProfile {
    private String login;
    private Bitmap image;
    private String url;

    public SimpleProfile(JSONObject json, final ProfilePreparedCallbacks callbacks, Context context){
        String loginVal = json.optString("login");
        String bitmapURL = json.optString("avatar_url");
        String urlVal = json.optString("url");

        this.login = loginVal;
//        this.image = DataAccessObject.getBitmapFromURL(bitmapURL);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        imageLoader.loadImage(bitmapURL, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                SimpleProfile.this.image = loadedImage;
                callbacks.onProfilePreparedSuccess(SimpleProfile.this);
            }
        });
        this.url = urlVal;
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
}
