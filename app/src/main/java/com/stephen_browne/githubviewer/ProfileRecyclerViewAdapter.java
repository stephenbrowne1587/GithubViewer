package com.stephen_browne.githubviewer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by steph on 10/15/2017.
 */

public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.ProfileViewHolder> {

    private String[] items = {"repos", "gists", "subscriptions", "stars", "following", "followers" , "another", "and another"};

    public ProfileRecyclerViewAdapter(){
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_list_row, parent, false);



        return new ProfileViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        holder.renderInfo(items[position]);

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public static class ProfileViewHolder extends RecyclerView.ViewHolder{
        TextView itemTextView;

        public ProfileViewHolder(View itemView) {
            super(itemView);
            itemTextView = (TextView)itemView.findViewById(R.id.profile_item_tv);

        }

        public void renderInfo(String item){
            itemTextView.setText(item);
        }
    }
}
