package com.example.myapplication;


import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{
    private Activity mContext;
    private List<CommunityContent> mContentList;
    private int width;


    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userHead;
        TextView userName;
        TextView userLevel;
        TextView contentText;
        ImageView contentPic;
        GridView contentGrid;

        public ViewHolder(View view) {
            super(view);
            userHead = view.findViewById(R.id.user_head);
            userName = view.findViewById(R.id.user_name);
            userLevel = view.findViewById(R.id.user_level);
            contentText = view.findViewById(R.id.content_text);
            contentPic = view.findViewById(R.id.content_pic);
            contentGrid = view.findViewById(R.id.content_gridView);
        }
    }

    public FriendAdapter(Activity context, List<CommunityContent> friendList) {
        mContext = context;
        mContentList = friendList;
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.friend_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        CommunityContent content = mContentList.get(position);
        holder.userName.setText(content.getName());
        holder.userLevel.setText(content.getLevel());
        holder.contentText.setText(content.getText());
        setBigPicture(holder.contentPic);




        Picasso.with(mContext)
                .load(content.getContentPicUrl())
                .into(holder.contentPic);
        Picasso.with(mContext)
                .load(content.getHeadUrl())
                .into(holder.userHead);

    }

    private void setBigPicture(ImageView imageView){
        ViewGroup.LayoutParams lp = imageView.getLayoutParams();
        lp.width = width;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        imageView.setLayoutParams(lp);
        imageView.setMaxWidth(width);
        imageView.setMaxHeight(1659);// 这里其实可以根据需求而定，我这里测试为最大宽度的1.5倍
    }

    @Override
    public int getItemCount() {
        return mContentList.size();
    }

}
