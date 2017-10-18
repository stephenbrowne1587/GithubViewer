package com.stephen_browne.githubviewer.Utils;

import com.stephen_browne.githubviewer.models.Profile;

/**
 * Created by steph on 10/16/2017.
 */

public interface ProfilePreparedCallbacks {
    void onProfilePreparedSuccess(Profile profile);
    void onProfilePrefaredFailure();
}
