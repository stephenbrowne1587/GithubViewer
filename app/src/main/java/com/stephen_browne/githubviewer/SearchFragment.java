package com.stephen_browne.githubviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.stephen_browne.githubviewer.Utils.DataAccessObject;
import com.stephen_browne.githubviewer.Utils.ProfileCallbacks;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by steph on 10/15/2017.
 */

public class SearchFragment extends Fragment implements ProfileCallbacks {
    MainActivity mainActivity;
    TextView searchTextView;
    EditText searchEditText;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public SearchFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    public static SearchFragment newInstance(int sectionNumber) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.search_fragment, container, false);
        searchTextView = (TextView) rootView.findViewById(R.id.search_tv);
        searchEditText = (EditText) rootView.findViewById(R.id.search_edittext);

        searchTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = searchEditText.getText().toString();
                DataAccessObject.getProfile(getContext(), username, SearchFragment.this);
            }
        });
        return rootView;
    }

    @Override
    public void onProfileSuccess(JSONObject profileJSON) {
        ProfileFragment fragment = new ProfileFragment();
        fragment.object = profileJSON;
        FragmentTransaction ft = getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content, fragment, "fragment")
                .addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onProfileFailure(VolleyError error) {
        String body;
        try {
            body = new String(error.networkResponse.data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            body = "";
        }
        Log.i("network response date", body);

    }
}
