package com.example.githubdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.example.githubdemo.view.IKNinePhotoViewAdapter;
import com.example.githubdemo.view.IKNinePhotoViewHolder;


import java.util.List;


/**
 * Created by Idtk on 2017/3/9.
 * Blog : http://www.idtkm.com
 * GitHub : https://github.com/Idtk
 * 描述 :
 */

public class DemoAdapter extends IKNinePhotoViewAdapter<DemoAdapter.MyHolder> {

    private Context mContext;
    private List<String> urls;


    public DemoAdapter(Context context, List<String> urls) {
        super();
        mContext = context;
        this.urls = urls;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
        return new MyHolder(view);
    }


    @Override
    public void onBindViewHolder(final MyHolder holder, final int position, final int maxWidth, final boolean isSingle) {

        Glide.with(mContext)
                .load(urls.get(position))
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        if(isSingle){ //自己设置view
                            double width = resource.getIntrinsicWidth();
                            double height = resource.getIntrinsicHeight();
                            double radio = height/width;
                            int newHeight = (int)(radio * maxWidth);
                            Log.e("fuck",maxWidth+" "+newHeight);
                            holder.getItemView().setLayoutParams(new ViewGroup.LayoutParams(maxWidth, newHeight));
                            holder.mImageView.layout(0,0,maxWidth,newHeight);
                        }
                        holder.mImageView.setImageDrawable(resource);
                    }
                });

        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    class MyHolder extends IKNinePhotoViewHolder {

        ImageView mImageView;

        public MyHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.nine_pic);

        }
    }

}
