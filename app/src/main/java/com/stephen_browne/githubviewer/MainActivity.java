package com.stephen_browne.githubviewer;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ProfileFragment fragment = new ProfileFragment();
////        fragment.object = profileJSON;
//        FragmentTransaction ft = getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.main_content, fragment, "fragment")
//                .addToBackStack(null);
//        ft.commit();


        SearchFragment fragment = new SearchFragment();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_content, fragment, "fragment")
                .addToBackStack(null);
        ft.commit();



    }
}
