package com.example.githubdemo.view;

import android.content.Context;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.githubdemo.R;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Idtk on 2017/3/8.
 * Blog : http://www.idtkm.com
 * GitHub : https://github.com/Idtk
 * des : 九宫格View
 */

public class IKNinePhotoView extends ViewGroup implements Observer{

    private IKNinePhotoViewAdapter adapter;
    private int contentWidth;
    /**
     * 图片间隔
     */
    private int border = 5;
    /**
     * 子控件大小宽高写死
     */
    private int childSize;
    private ArrayList<IKNinePhotoViewHolder> mRecyclerList = new ArrayList<>();
    /**
     *  有几列
     */
    private int mColumns;
    /**
     *  有几行
     */
    private int mRows;

    private ImageView mAddView = null;

    private Context context;

    private boolean showAddView = false;

    public void setShowAddView(boolean showAddView) {
        this.showAddView = showAddView;
    }

    public IKNinePhotoView(@NonNull Context context) {
        this(context, null);
    }

    public IKNinePhotoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IKNinePhotoView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("wu","onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ninePhotoMeasure(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //super.onLayout(changed, left, top, right, bottom);
        if (!showAddView && adapter.getItemCount() == 1) { //不显示添加按钮且item数为1，特殊显示
            Log.e("haha",left+" "+top+" "+right+" "+bottom);
            onePicChildLayout();
        }else {
            childLayout();
        }
    }

    /**
     * 添加子view
     */
    private void ninePhotoCreateView(){
        removeAllViews();
        if(canShowAddView()){
            addView(getAddPhotoView(),generateDefaultLayoutParams()); //显示添加按钮
        }
        for (int i = 0; i < adapter.getItemCount(); i++) {
            addView(generateViewHolder(i).getItemView(),generateDefaultLayoutParams());
        }
    }

    /**
     * 当前没有item时的添加图片view
     */
    public ImageView getAddPhotoView(){
        if(mAddView == null ){
            mAddView = new ImageView(context);
            mAddView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mAddView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        return mAddView;
    }

    /**
     * 根据图片个数确定行列数量
     *
     * @param length
     */
    private void generateChildrenLayout(int length) {
        if (length <= 3) {
            mRows = 1;
            mColumns = length;
        }
        else if(length == 4){
            mRows = 2;
            mColumns = 2;
        }
        else if (length <= 6) {
            mRows = 2;
            mColumns = 3;
        } else {
            mColumns = 3;
            mRows = 3;
        }

    }

    /**
     * 测量控件长度并添加控件
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    private void ninePhotoMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //控件的宽度写死，永远等于父控件给予的宽度
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        contentWidth = parentWidth - getPaddingLeft() - getPaddingRight();
        int height;
        if (adapter == null) return;

        if (adapter.getItemCount() < 0 || adapter.getItemCount() > 9) {
            throw new IllegalStateException("itemCount may not be more than 9 or less than 0");
        }
        childSize = (contentWidth - border * 2) / 3;

        if (!showAddView && adapter.getItemCount() == 0) { //不显示添加按钮且item数为0，不显示view
            setMeasuredDimension(0, 0);
            return;
        }

        if (!showAddView && adapter.getItemCount() == 1) { //不显示添加按钮且item数为1，特殊显示
            ninePhotoCreateView();
            return;
        }

        //根据item数目获取行与列数
        if(canShowAddView()){
            generateChildrenLayout(adapter.getItemCount()+1); //显示添加按钮
        }else {
            generateChildrenLayout(adapter.getItemCount());
        }

        //根据子view数量确定高度
        height = childSize * mRows + border * (mRows - 1) + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(parentWidth, height);
        ninePhotoCreateView();
    }

    private boolean canShowAddView() {
        return showAddView && adapter.getItemCount() < 9;
    }

    /**
     * 一张图的特殊显示
     */
    private void onePicChildLayout(){
        if (adapter == null) return;

        if (adapter.getItemCount() < 0 || adapter.getItemCount() > 9) {
            throw new IllegalStateException("itemCount may not be more than 9 or less than 0");
        }

        if (mRecyclerList.get(0) != null && !mRecyclerList.get(0).isUsed()) {
            adapter.onBindViewHolder(generateViewHolder(0), 0,contentWidth,true);
            mRecyclerList.get(0).setUsed(true);//标记已被使用
        }

    }

    private void childLayout() {
	    
	    if (adapter == null) return;

        if (adapter.getItemCount() < 0 || adapter.getItemCount() > 9) {
            throw new IllegalStateException("itemCount may not be more than 9 or less than 0");
        }

        int startIndex = 0;
        if(canShowAddView()){
            startIndex = 1;
            mAddView.layout(getPaddingLeft(), getPaddingTop(), getPaddingLeft()+childSize, getPaddingTop()+childSize);
            mAddView.setImageResource(R.drawable.addpic);
        }
        int count = adapter.getItemCount();

        for (int i = 0; i < count; i++) {
            int viewIndex = i + startIndex;
            View childView = getChildAt(viewIndex);

            if (childView == null){
                return;
            }
            int rows = viewIndex / mColumns;
            int cols = viewIndex % mColumns;

            int childLeft = getPaddingLeft() + (childSize + border) * cols;
            int childTop = getPaddingTop() + (childSize + border) * rows;
            int childRight = childLeft + childSize;
            int childBottom = childTop + childSize;
            childView.layout(childLeft, childTop, childRight, childBottom);

            if (mRecyclerList.get(i) != null && !mRecyclerList.get(i).isUsed()) {
                adapter.onBindViewHolder(generateViewHolder(i), i,contentWidth,false);
                mRecyclerList.get(i).setUsed(true);//标记已被使用
            }
        }
    }


    public void setAdapter(IKNinePhotoViewAdapter adapter){
        Log.e("wu","setAdapter "+adapter.getItemCount());
        this.adapter = adapter;
        adapter.addObserver(this);
        adapter.notifyDataSetChanged();
    }

    public void setBorder(int border){
        this.border = border;
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.e("wu","update");
        if (o instanceof IKNinePhotoViewAdapter){
            for(IKNinePhotoViewHolder holder: mRecyclerList){
                holder.setUsed(false);
            }
            Log.e("wu","requestLayout");
            requestLayout();
        }
    }

    private IKNinePhotoViewHolder generateViewHolder(int position){
        if (position < mRecyclerList.size()) { //足够
            return mRecyclerList.get(position);
        } else {
            if (adapter != null){ //adapter不为空，但不足够
                IKNinePhotoViewHolder holder = adapter.onCreateViewHolder(IKNinePhotoView.this);
                if (holder == null){
                    return null;
                }
                mRecyclerList.add(holder);
                return holder;
            } else
                return null;
        }
    }

    public void clearRecycler(){
        mRecyclerList.clear();
    }
}
