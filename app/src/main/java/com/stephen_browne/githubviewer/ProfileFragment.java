package com.stephen_browne.githubviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.stephen_browne.githubviewer.Utils.CustomImageView;
import com.stephen_browne.githubviewer.models.Profile;

/**
 * Created by steph on 10/15/2017.
 */

public class ProfileFragment extends Fragment {

    private MainActivity mainActivity;
    private RecyclerView profileRV;
    private CustomImageView imageView;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;
    private RelativeLayout profileContent;
    private LinearLayout infoLinearLayout;
    private TextView nameTextView;
    private TextView companyTextView;
    private TextView locationTextView;
    private TextView blogTextView;


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
        appBarLayout = (AppBarLayout)rootView.findViewById(R.id.appbar_layout);
        profileContent = (RelativeLayout)rootView.findViewById(R.id.profile_content);
        infoLinearLayout = (LinearLayout)rootView.findViewById(R.id.info_linear_layout);
        nameTextView = (TextView)rootView.findViewById(R.id.name_text_view);
        companyTextView = (TextView) rootView.findViewById(R.id.company_text_view);
        locationTextView = (TextView)rootView.findViewById(R.id.location_text_view);
        blogTextView = (TextView)rootView.findViewById(R.id.blog_text_view);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setAutoMeasureEnabled(false);
        profileRV.setLayoutManager(llm);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                infoLinearLayout.setAlpha(1.0f -  2 * Math.abs(verticalOffset / (float)
                        appBarLayout.getTotalScrollRange()));
            }
        });

        return rootView;
    }

    public void renderProfile(){

        ProfileRecyclerViewAdapter adapter = new ProfileRecyclerViewAdapter();
        profileRV.setAdapter(adapter);

        imageView.setImageBitmap(profile.getImage());
        collapsingToolbarLayout.setTitle(profile.getLogin());
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        nameTextView.setText(profile.getName());
        companyTextView.setText(profile.getCompany());
        locationTextView.setText(profile.getLocation());
        blogTextView.setText(profile.getBlog());
    }


}
