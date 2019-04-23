package com.jingewenku.abrahamcaijin.loopviewpagers.util;

import android.content.Context;
import android.util.TypedValue;

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
public class DensityUtils {
    private DensityUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(1, dpVal, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float spVal) {
        return (int)TypedValue.applyDimension(2, spVal, context.getResources().getDisplayMetrics());
    }

    public static float px2dp(Context context, float pxVal) {
        float scale = context.getResources().getDisplayMetrics().density;
        return pxVal / scale;
    }

    public static float px2sp(Context context, float pxVal) {
        return pxVal / context.getResources().getDisplayMetrics().scaledDensity;
    }
}
