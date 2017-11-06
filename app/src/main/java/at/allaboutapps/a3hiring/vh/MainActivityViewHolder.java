package at.allaboutapps.a3hiring.vh;

import at.allaboutapps.a3hiring.R;
import android.app.Activity;

/**
* ViewHolderGenerator: version 0.24.0 (15.04.2016)
* 
* file last modified: 06.11.2017
*/
public class MainActivityViewHolder {

    // CHECKSTYLE:OFF
    public final android.support.v7.widget.Toolbar toolbar;
    public final android.support.v7.widget.RecyclerView clubList;
    public final android.support.design.widget.FloatingActionButton fab;
    // CHECKSTYLE:ON

    public MainActivityViewHolder(Activity root) {

        toolbar = (android.support.v7.widget.Toolbar) root.findViewById(R.id.toolbar);
        clubList = (android.support.v7.widget.RecyclerView) root.findViewById(R.id.clubList);
        fab = (android.support.design.widget.FloatingActionButton) root.findViewById(R.id.fab);
    }

}