package com.example.githubdemo;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.githubdemo.model.CommunityContent;
import com.example.githubdemo.view.IKNinePhotoView;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{
    private Activity mContext;
    private List<CommunityContent> mContentList;
    private LayoutInflater inflater;
    private static final int VIDEO = 0;
    private static final int PICTURE = 1;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userHead;
        TextView userName;
        TextView userLevel;
        TextView contentText;
        IKNinePhotoView photoView;


        public ViewHolder(View view) {
            super(view);
            userHead = view.findViewById(R.id.user_head);
            userName = view.findViewById(R.id.user_name);
            userLevel = view.findViewById(R.id.user_level);
            contentText = view.findViewById(R.id.content_text);
            photoView = view.findViewById(R.id.photoview);
        }
    }


    public FriendAdapter(Activity context, List<CommunityContent> friendList) {
        mContext = context;
        mContentList = friendList;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_bbs_nine_grid,parent,false);
        return new ViewHolder(view);
    }




    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        CommunityContent content = mContentList.get(position);
        holder.userName.setText(content.getName());
        holder.userLevel.setText(content.getLevel());
        holder.contentText.setText(content.getText());
        Glide.with(mContext)
                .load(content.getHeadUrl())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(holder.userHead);
        DemoAdapter adapter = new DemoAdapter(mContext,mContentList.get(position).getContentPicUrls());
        holder.photoView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return mContentList == null ? 0 : mContentList.size();
    }

    public void refreshView(List<CommunityContent> list){
        mContentList.clear();
        mContentList.addAll(list);
        notifyDataSetChanged();
    }

}
