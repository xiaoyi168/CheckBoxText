package com.yideng168.checkboxtextlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/27 0027.
 */

public class CheckBoxTexView extends LinearLayout {

    private ImageView mImg;
    private TextView mName;
    private View mView;
    private float mTextSize;
    private int mTextColorChecked;
    private int mTextColorUnChecked;
    private Drawable mCheckedDrawable;
    private Drawable mUncheckedDrawable;
    private String mText;
    private boolean mCheckFlag;
    private  onCheckChangeListener mOnCheckChangeListener;

    public onCheckChangeListener getOnCheckChangeListener() {
        return mOnCheckChangeListener;
    }

    public void setOnCheckChangeListener(onCheckChangeListener onCheckChangeListener) {
        mOnCheckChangeListener = onCheckChangeListener;
    }

    public CheckBoxTexView(Context context) {
        super(context);
    }

    public CheckBoxTexView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CheckBoxTexView, 0, 0);
        mTextColorChecked = typedArray.getColor(R.styleable.CheckBoxTexView_textColorChecked, Color.RED);
        mTextColorUnChecked = typedArray.getColor(R.styleable.CheckBoxTexView_textColorUnChecked, Color.BLACK);
        mTextSize = typedArray.getDimension(R.styleable.CheckBoxTexView_textSize, 12f);
        mCheckedDrawable = typedArray.getDrawable(R.styleable.CheckBoxTexView_checkedDrawable);
        mUncheckedDrawable = typedArray.getDrawable(R.styleable.CheckBoxTexView_uncheckedDrawable);
        mText = typedArray.getString(R.styleable.CheckBoxTexView_text);

        mView = LayoutInflater.from(context).inflate(R.layout.checkbox_layout, this, true);
        mImg = (ImageView) mView. findViewById(R.id.id_img);
        mName = (TextView) mView.findViewById(R.id.id_name);

        mName.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1.0f)); //权重
        mName.setTextSize(mTextSize);  //文字大小

        if(!TextUtils.isEmpty(mText)){  //文字
            mName.setText(mText);
        }
        if(mUncheckedDrawable!=null){  //图片
            mImg.setImageDrawable(mUncheckedDrawable);
        }

        mName.setTextColor(mTextColorUnChecked);//文字颜色

        mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                mCheckFlag =!mCheckFlag;
                showView();

            }
        });

    }



    private void showView() {
        mImg.setImageDrawable(mCheckFlag?mCheckedDrawable:mUncheckedDrawable); //背景颜色
        mName.setTextColor(mCheckFlag?mTextColorChecked:mTextColorUnChecked);//文字颜色
        if(mOnCheckChangeListener!=null){
            mOnCheckChangeListener.isChecked(mCheckFlag);
        }

    }

    public  void setChecked(boolean isChecked){
        mCheckFlag=isChecked;
        showView();

    }

     public  interface  onCheckChangeListener{
        void isChecked(boolean isChecked);

    }

}
