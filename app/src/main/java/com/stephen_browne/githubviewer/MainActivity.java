package com.stephen_browne.githubviewer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SearchFragment fragment = new SearchFragment();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_content, fragment, "fragment")
                .addToBackStack(null);
        ft.commit();


    }
}
