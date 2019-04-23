package com.jingewenku.abrahamcaijin.loopviewpagers.util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

/**
 * 主要功能:
 *
 * @Prject: LoopViewPager
 * @Package: com.jingewenku.abrahamcaijin.loopviewpagers.util
 * @author: Abraham
 * @date: 2019年04月20日 14:06
 * @Copyright: 个人版权所有
 * @Company:
 * @version: 1.0.0
 */

public class LoopViewPagerScroller extends Scroller {
    // 滑动速度
    private int mScrollDuration = 2000;

    /**
     * 设置速度速度
     * @param duration
     */
    public void setScrollDuration(int duration){
        this.mScrollDuration = duration;
    }

    public LoopViewPagerScroller(Context context) {
        super(context);
    }

    public LoopViewPagerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public LoopViewPagerScroller(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mScrollDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, mScrollDuration);
    }

    public void initViewPagerScroll(ViewPager viewPager) {
        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            mScroller.set(viewPager, this);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}