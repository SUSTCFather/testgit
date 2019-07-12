package com.example.githubdemo.view;

import android.view.View;

/**
 * Created by Idtk on 2017/3/8.
 * Blog : http://www.idtkm.com
 * GitHub : https://github.com/Idtk
 * des : 九宫格ViewHolder
 */

public abstract class IKNinePhotoViewHolder {
    /**
     * 标记此viewHolder是否被使用
     */
    private boolean used = false;
    private View itemView;

    public IKNinePhotoViewHolder(View itemView) {
        if (itemView == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.itemView = itemView;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public View getItemView() {
        return itemView;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
    }
}
