package com.moreapps.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.moreapps.R;
import com.moreapps.adapter.AppsCategoryAdapter;
import com.moreapps.interfaces.CategoryWiseApps;
import com.moreapps.models.AppsDetails;
import com.moreapps.models.MoreappsAdapter;
import com.moreapps.utils.MoreAppsConstant;

import java.util.ArrayList;

import static com.moreapps.CallIt.ShowMoreAppsGrid.getAdBackground;
import static com.moreapps.CallIt.ShowMoreAppsGrid.getAppNameTextColor;
import static com.moreapps.CallIt.ShowMoreAppsGrid.getInstallButtonBackground;
import static com.moreapps.CallIt.ShowMoreAppsGrid.getInstallTextColor;
import static com.moreapps.CallIt.ShowMoreAppsGrid.getItemBackground;

public class MoreAppsActivity extends AppCompatActivity implements CategoryWiseApps {


    RecyclerView rv_category, rv_subcategory;
    ShimmerFrameLayout shimmerLinear, shimmerGrid;

    public static int installTextColor = 0;
    public static int appNameTextColor = 0;
    public Drawable adIcon = null;
    public Drawable installButtonBackground = null;

    RelativeLayout lay_toolbar_moreapps;
    TextView tv_title_moreapps;
    LinearLayout lay_moreapps;

//    public class OnlyMoreApps {
//        public OnlyMoreApps(int installTextColor, int appNameTextColor, Drawable adIcon, Drawable installButtonBackground ){
//            this.installTextColor
//        }
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_apps);

        installTextColor = getInstallTextColor();
        appNameTextColor = getAppNameTextColor();
        adIcon = getAdBackground();
        installButtonBackground = getInstallButtonBackground();

        rv_category = findViewById(R.id.rv_category);
        rv_subcategory = findViewById(R.id.rv_subcategory);
        shimmerLinear = findViewById(R.id.shimmerLinear);
        shimmerGrid = findViewById(R.id.shimmerGrid);
        lay_toolbar_moreapps = findViewById(R.id.lay_toolbar_moreapps);
        tv_title_moreapps = findViewById(R.id.tv_title_moreapps);
        lay_moreapps = findViewById(R.id.lay_moreapps);


        if (MoreAppsConstant.isLightTheme) {
            setCategory("light");
            lay_toolbar_moreapps.setBackgroundColor(Color.WHITE);
            tv_title_moreapps.setTextColor(Color.BLACK);
            lay_moreapps.setBackgroundColor(Color.WHITE);
        } else {
            setCategory("dark");
            lay_toolbar_moreapps.setBackgroundColor(Color.BLACK);
            tv_title_moreapps.setTextColor(Color.WHITE);
            lay_moreapps.setBackgroundColor(Color.BLACK);
        }

    }

    public void setCategory(String theme) {
        shimmerLinear.setVisibility(View.VISIBLE);
        shimmerGrid.setVisibility(View.VISIBLE);
        rv_category.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmerLinear.setVisibility(View.GONE);
                shimmerGrid.setVisibility(View.GONE);
                rv_category.setVisibility(View.VISIBLE);
                AppsCategoryAdapter adapter = new AppsCategoryAdapter(MoreAppsActivity.this, MoreAppsConstant.category, theme);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MoreAppsActivity.this, RecyclerView.HORIZONTAL, false);
                rv_category.setLayoutManager(layoutManager);
                rv_category.setItemAnimator(new DefaultItemAnimator());
                rv_category.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, 1500);
    }

    @Override
    public void subcategoryApps(ArrayList<AppsDetails> subcategoryList, String theme) {
        MoreappsAdapter adapter = new MoreappsAdapter(MoreAppsActivity.this, subcategoryList, "grid", theme, getAppNameTextColor(), getInstallButtonBackground(), getInstallTextColor(), getAdBackground(), getItemBackground());
        LinearLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        rv_subcategory.setLayoutManager(layoutManager);
        rv_subcategory.setItemAnimator(new DefaultItemAnimator());
        rv_subcategory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}