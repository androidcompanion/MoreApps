package com.moreapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moreapps.CallIt.ShowMoreAppsGrid;
import com.moreapps.CallIt.ShowMoreAppsLinear;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new ShowMoreAppsGrid(this,"light", findViewById(R.id.lay_more_main)).showMore(findViewById(R.id.lay_more_main));
        ShowMoreAppsLinear showMoreAppsGrid = new ShowMoreAppsLinear(this,"ligght", findViewById(R.id.lay_more_main));
        showMoreAppsGrid.setSeeMoreButtonBackground(getResources().getDrawable(R.drawable.bg_btn_moreapps));
        showMoreAppsGrid.setAdbackground(getResources().getDrawable(R.drawable.bg_btn_moreapps));
        showMoreAppsGrid.setSeeMoreButtonTextColor(getResources().getColor(R.color.appColor));
        showMoreAppsGrid.setInstallButtonTextColor(getResources().getColor(R.color.white));
    }
}