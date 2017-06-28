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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/27 0027.
 */

public class CheckBoxTexView extends LinearLayout {

    private boolean mChecked;
    private ImageView mImg;
    private TextView mName;
    private View mView;
    private int mTextWeight;
    private float mTextSize;
    private int mTextColorChecked;
    private int mTextColorUnChecked;
    private int mPressColor;
    private Drawable mCheckedDrawable;
    private Drawable mUncheckedDrawable;
    private String mText;
    private  OnCheckedChangeListener mOnCheckedChangeListener;

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        mOnCheckedChangeListener = onCheckedChangeListener;
    }

    public CheckBoxTexView(Context context) {
        super(context);
    }

    public CheckBoxTexView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CheckBoxTexView, 0, 0);
        mTextWeight = typedArray.getInt(R.styleable.CheckBoxTexView_textWeight, 1);
        mTextColorChecked = typedArray.getColor(R.styleable.CheckBoxTexView_textColorChecked, Color.RED);
        mTextColorUnChecked = typedArray.getColor(R.styleable.CheckBoxTexView_textColorUnChecked, Color.BLACK);
        mTextSize = typedArray.getDimension(R.styleable.CheckBoxTexView_textSize, 12f);
        mPressColor = typedArray.getColor(R.styleable.CheckBoxTexView_pressColor, getResources().getColor(R.color.trant));

        mCheckedDrawable = typedArray.getDrawable(R.styleable.CheckBoxTexView_checkedDrawable);
        mUncheckedDrawable = typedArray.getDrawable(R.styleable.CheckBoxTexView_uncheckedDrawable);
        mText = typedArray.getString(R.styleable.CheckBoxTexView_text);

        mChecked = false;
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

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();


        switch (action){
            case MotionEvent.ACTION_DOWN:

                mChecked=!mChecked;

                mOnCheckedChangeListener.onCheckedChanged(mChecked); //接口回调

                mView.setBackgroundColor(mPressColor);  //按下时的背景色


                if(mChecked){

                    if(mCheckedDrawable==null){  //图片
                        mImg.setImageResource(R.drawable.on);
                    }
                    else{
                        mImg.setImageDrawable(mCheckedDrawable);
                    }
                    mName.setTextColor(mTextColorChecked);//文字颜色


                }
                else {

                    if(mUncheckedDrawable==null){  //图片
                        mImg.setImageResource(R.drawable.off);
                    }
                    else{
                        mImg.setImageDrawable(mUncheckedDrawable);
                    }

                    mName.setTextColor(mTextColorUnChecked);//文字颜色

                }

                break;
            case MotionEvent.ACTION_UP:

                mView.setBackgroundColor(Color.TRANSPARENT);
                break;

        }

        return true;

    }

    public  interface OnCheckedChangeListener {
        void onCheckedChanged( boolean isChecked);
    }

}
