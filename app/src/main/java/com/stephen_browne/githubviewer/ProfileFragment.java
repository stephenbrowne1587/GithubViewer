package com.stephen_browne.githubviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.stephen_browne.githubviewer.Utils.CustomImageView;
import com.stephen_browne.githubviewer.models.Profile;

/**
 * Created by steph on 10/15/2017.
 */

public class ProfileFragment extends Fragment {

    MainActivity mainActivity;
    RecyclerView profileRV;
    CustomImageView imageView;
    CollapsingToolbarLayout collapsingToolbarLayout;

    Profile profile;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity)getActivity();
    }

    public ProfileFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ProfileFragment newInstance(int sectionNumber) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();

//        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_fragment, container, false);
        profileRV = (RecyclerView) rootView.findViewById(R.id.profile_rv);
        imageView = (CustomImageView) rootView.findViewById(R.id.profile_imageview);
        collapsingToolbarLayout = (CollapsingToolbarLayout)rootView.findViewById(R.id.collapsing_layout);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setAutoMeasureEnabled(false);
        profileRV.setLayoutManager(llm);

        return rootView;
    }

    public void renderProfile(){

        ProfileRecyclerViewAdapter adapter = new ProfileRecyclerViewAdapter();
        profileRV.setAdapter(adapter);

        imageView.setImageBitmap(profile.getImage());
        collapsingToolbarLayout.setTitle(profile.getLogin());
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
    }


}
