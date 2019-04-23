package com.jingewenku.abrahamcaijin.loopviewpagers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

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

public class IndicatiorCanvasView extends LinearLayout {
    private int select_origin;
    private float positionOffsetData;
    private Bitmap originBitmap;
    private ImageView firstView;
    private ImageView secondView;
    private Context context;
    private int numView;

    private int[] firstViewLocation=new int[2];
    private int[] secondViewLocation=new int[2];
    private int originMargin=0;

    public IndicatiorCanvasView(Context context,int origin,int select_origin) {
        this(context,null);
        originBitmap= BitmapFactory.decodeResource(context.getResources(), origin);
        this.select_origin=select_origin;
        this.context=context;
    }

    public IndicatiorCanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public IndicatiorCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                firstView.getLocationInWindow(firstViewLocation);
                secondView.getLocationInWindow(secondViewLocation);
                originMargin=secondViewLocation[0]-firstViewLocation[0];
            }
        });
    }

    public void initView(int size){
        this.numView=size;
        for(int i=0;i<size;i++){
            ImageView originView=new ImageView(context);
            LayoutParams layoutParams=new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity= Gravity.CENTER;
            originView.setLayoutParams(layoutParams);
            originView.setImageResource(select_origin);
            if(i==0){
                firstView=originView;
            }else if(i==1){
                secondView=originView;
            }
            addView(originView);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.translate(this.positionOffsetData,0);
        canvas.drawBitmap(originBitmap,0,0,new Paint());
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
        int num=position%this.numView;
        this.positionOffsetData=(num*originMargin)+originMargin*positionOffset;
        invalidate();
    }

}
