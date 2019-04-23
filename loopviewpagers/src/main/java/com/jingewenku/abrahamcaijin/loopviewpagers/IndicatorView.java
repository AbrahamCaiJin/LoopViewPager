package com.jingewenku.abrahamcaijin.loopviewpagers;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jingewenku.abrahamcaijin.loopviewpagers.interfaces.IndicatorAnimator;

/**
 * 主要功能:
 *
 * @Prject: LoopViewPager
 * @Package: com.jingewenku.abrahamcaijin.loopviewpagers
 * @author: Abraham
 * @date: 2019年04月20日 14:07
 * @Copyright: 个人版权所有
 * @Company:
 * @version: 1.0.0
 */


public class IndicatorView extends LinearLayout {
    private Context context;
    private int loopNowIndicatorImg;
    private int loopIndicatorImg;
    private IndicatorAnimator indicatorAnimator;

    public IndicatorView(Context context, int loopNowIndicatorImg,
        int loopIndicatorImg, IndicatorAnimator indicatorAnimator) {
        this(context,null);
        this.loopNowIndicatorImg=loopNowIndicatorImg;
        this.loopIndicatorImg=loopIndicatorImg;
        this.indicatorAnimator=indicatorAnimator;
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        setOrientation(HORIZONTAL);
    }

    public void initView(int viewSize){
        for(int i=0;i<viewSize;i++){
            ImageView imageView=new ImageView(context);
            LayoutParams layoutParams=new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity= Gravity.CENTER;
            imageView.setLayoutParams(layoutParams);
            if(i==0){
                imageView.setImageResource(this.loopNowIndicatorImg);
            }else{
                imageView.setImageResource(this.loopIndicatorImg);
            }
            addView(imageView);
        }
    }

    public void changeIndicator(int select){
        if(getChildCount()==0){
            return;
        }
        for(int i=0;i<getChildCount();i++){
            ((ImageView)getChildAt(i)).setImageResource(this.loopIndicatorImg);
        }
        ImageView imageView=(ImageView)getChildAt(select);
        imageView.setImageResource(this.loopNowIndicatorImg);
        if(this.indicatorAnimator!=null){
            indicatorAnimator.indicatorView(imageView);
        }
    }
}