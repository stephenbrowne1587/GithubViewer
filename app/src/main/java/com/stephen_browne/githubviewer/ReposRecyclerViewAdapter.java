package com.stephen_browne.githubviewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stephen_browne.githubviewer.models.Repository;

import java.util.ArrayList;

/**
 * Created by steph on 10/19/2017.
 */

public class ReposRecyclerViewAdapter extends RecyclerView.Adapter<ReposRecyclerViewAdapter.RepoViewHolder>  {
    private ArrayList<Repository> repositories;
    private Context context;
    private MainActivity mainActivity;
    private RecyclerView recyclerView;

    public ReposRecyclerViewAdapter(ArrayList<Repository> repositories, Context context,
                                    MainActivity mainActivity, RecyclerView recyclerView){
        this.repositories = repositories;
        this.context = context;
        this.mainActivity = mainActivity;
        this.recyclerView = recyclerView;

    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_list_row, parent, false);
        return new RepoViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.renderRepoInfo(repositories.get(position));

    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {

        private TextView repoNameTextView;
        private TextView repoDescriptionTextView;
        public RepoViewHolder(View itemView) {
            super(itemView);
            repoNameTextView = (TextView) itemView.findViewById(R.id.repo_name_tv);
            repoDescriptionTextView = (TextView)itemView.findViewById(R.id.repo_description_tv);
        }

        private void renderRepoInfo(Repository repo){
            repoNameTextView.setText(repo.getName());
            repoDescriptionTextView.setText(repo.getDescription());
        }


    }
}
