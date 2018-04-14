package com.example.hp.imdb;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by HP on 10-04-2018.
 */

public class PersonImages {

   // @SerializedName("profiles")
    private ArrayList<Profiles> profiles;

    public ArrayList<Profiles> getProfileList() {
        return profiles;
    }

    public void setProfiles(ArrayList<Profiles> profiles) {
        this.profiles = profiles;
    }
}
