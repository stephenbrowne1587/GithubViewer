package com.stephen_browne.githubviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stephen_browne.githubviewer.models.Repository;

import java.util.ArrayList;

/**
 * Created by steph on 10/19/2017.
 */

public class RepositoriesFragment extends Fragment {
    RecyclerView reposRecyclerView;
    ArrayList<Repository> repositories;
    private MainActivity mainActivity;

    public static RepositoriesFragment newInstance(ArrayList<Repository> repositories) {

        Bundle args = new Bundle();

        RepositoriesFragment fragment = new RepositoriesFragment();
        fragment.setArguments(args);
        fragment.repositories = repositories;
        return fragment;
    }





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity)getActivity();




    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.repos_fragment, container, false);
        reposRecyclerView = (RecyclerView) rootView.findViewById(R.id.repos_recyclerview);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        reposRecyclerView.setLayoutManager(llm);
        ReposRecyclerViewAdapter reposRecyclerViewAdapter = new ReposRecyclerViewAdapter(repositories, getContext(), mainActivity, reposRecyclerView);
        reposRecyclerView.setAdapter(reposRecyclerViewAdapter);


        return rootView;




    }
}
