package com.example.githubdemo.view;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.Observable;

/**
 * Created by Idtk on 2017/3/8.
 * Blog : http://www.idtkm.com
 * GitHub : https://github.com/Idtk
 * des : 九宫格Adapter
 */

//变化的通知者
public abstract class IKNinePhotoViewAdapter<T extends IKNinePhotoViewHolder> extends Observable {


    public IKNinePhotoViewAdapter() {
        super();
    }

    /**
     * 获取view的总数
     * @return
     */
    public int getItemCount(){
        return 0;
    }

    public abstract T onCreateViewHolder(ViewGroup parent);

    public abstract void onBindViewHolder(T holder, int position,int maxWidth,boolean isSingle);


    public void notifyDataSetChanged(){
        setChanged();
        notifyObservers();
    }

}