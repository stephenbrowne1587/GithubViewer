package com.stephen_browne.githubviewer.models;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by steph on 10/16/2017.
 */

public class FullProfile {
    private String login;
    private Bitmap image;
    private ArrayList<SimpleProfile> followers;
    private ArrayList<SimpleProfile> following;
    private ArrayList<Gist> gists;



}
