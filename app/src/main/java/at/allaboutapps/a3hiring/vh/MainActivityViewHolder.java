package at.allaboutapps.a3hiring.vh;

import at.allaboutapps.a3hiring.R;
import android.widget.ProgressBar;
import android.app.Activity;

/**
* ViewHolderGenerator: version 0.24.0 (15.04.2016)
* 
* file last modified: 06.11.2017
*/
public class MainActivityViewHolder {

    // CHECKSTYLE:OFF
    public final android.support.design.widget.CoordinatorLayout vgMainLayout;
    public final android.support.v7.widget.Toolbar toolbar;
    public final ProgressBar progress;
    public final android.support.v7.widget.RecyclerView clubList;
    // CHECKSTYLE:ON

    public MainActivityViewHolder(Activity root) {

        vgMainLayout = (android.support.design.widget.CoordinatorLayout) root.findViewById(R.id.vgMainLayout);
        toolbar = (android.support.v7.widget.Toolbar) root.findViewById(R.id.toolbar);
        progress = (ProgressBar) root.findViewById(R.id.progress);
        clubList = (android.support.v7.widget.RecyclerView) root.findViewById(R.id.clubList);
    }

}