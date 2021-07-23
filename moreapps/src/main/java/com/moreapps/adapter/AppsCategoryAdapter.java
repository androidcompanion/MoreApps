package com.moreapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.moreapps.CallIt.ShowMoreAppsGrid;
import com.moreapps.R;
import com.moreapps.interfaces.CategoryWiseApps;
import com.moreapps.utils.MoreAppsConstant;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.moreapps.utils.MoreAppsConstant.arraylist;
import static com.moreapps.utils.MoreAppsConstant.category;

public class AppsCategoryAdapter extends RecyclerView.Adapter<AppsCategoryAdapter.Viewholder> {

    private Context context;
    private List<String> categoryList;
    CategoryWiseApps categoryWiseApps;
    String theme="";


    public AppsCategoryAdapter(Context context, List<String> categoryList,String theme) {
        this.context = context;
        this.categoryList = categoryList;
        this.theme = theme;
    }

    @NotNull
    @Override
    public AppsCategoryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_moreapps, parent, false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppsCategoryAdapter.Viewholder holder, int position) {

        categoryWiseApps = (CategoryWiseApps) context;

        if (theme.equals("light")) {
            holder.tv_catName.setTextColor(context.getResources().getColor(R.color.black));
        } else {
            holder.tv_catName.setTextColor(context.getResources().getColor(R.color.white));
        }

        holder.tv_catName.setText(MoreAppsConstant.category.get(position));
        holder.tv_catName.setSelected(true);

        categoryWiseApps.subcategoryApps(MoreAppsConstant.arraylist.get(0),theme);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryWiseApps.subcategoryApps(MoreAppsConstant.arraylist.get(position),theme);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {

        private ImageView appimage;
        private TextView tvname, tv_catName;

        public Viewholder(@NonNull @NotNull View itemView) {
            super(itemView);

            appimage = itemView.findViewById(R.id.appimage);
            tvname = itemView.findViewById(R.id.tvname);
            tv_catName = itemView.findViewById(R.id.tv_catName);

        }
    }
}
