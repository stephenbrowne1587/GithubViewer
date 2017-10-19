package com.stephen_browne.githubviewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stephen_browne.githubviewer.models.Profile;

/**
 * Created by steph on 10/15/2017.
 */

public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.ProfileViewHolder> {

    private String[] items = {"Repositories", "Gists",  "Following", "Followers" ,"Stars", "Organizations", "another", "and another"};
    private Profile profile;
    private ProfileOnClickListener clickListener;
    private MainActivity mainActivity;


    public ProfileRecyclerViewAdapter(Profile profile, Context context, RecyclerView recyclerView, MainActivity mainActivity){
        this.profile = profile;
        this.clickListener = new ProfileOnClickListener(context, recyclerView, mainActivity, profile);
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_list_row, parent, false);
        inflatedView.setOnClickListener(clickListener);

        return new ProfileViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        holder.renderInfo(position, items,  profile);

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public static class ProfileViewHolder extends RecyclerView.ViewHolder{
        private TextView itemTextView;
        private TextView numberTextView;

        public ProfileViewHolder(View itemView) {
            super(itemView);
            itemTextView = (TextView)itemView.findViewById(R.id.profile_item_tv);
            numberTextView = (TextView) itemView.findViewById(R.id.number_text_view);

        }


        public void renderInfo(int position, String[] items, Profile profile){
            itemTextView.setText(items[position]);
            switch (position){
                case 0:
                    numberTextView.setText(String.valueOf(profile.getNumRepos()));
                    break;
                case 1:
                    numberTextView.setText(String.valueOf(profile.getNumGists()));
                    break;
                case 2:
                    numberTextView.setText(String.valueOf(profile.getNumFollowing()));
                    break;
                case 3:
                    numberTextView.setText(String.valueOf(profile.getNumFollowers()));
                    break;
                default:
                    numberTextView.setVisibility(View.INVISIBLE);
            }


        }
    }
}
