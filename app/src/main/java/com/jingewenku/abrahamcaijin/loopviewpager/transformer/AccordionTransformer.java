package com.jingewenku.abrahamcaijin.loopviewpager.transformer;

import android.view.View;

/**
 * 主要功能:
 *
 * @Prject: LoopViewPager
 * @Package: com.jingewenku.abrahamcaijin.loopviewpager.transformer
 * @author: Abraham
 * @date: 2019年04月20日 14:14
 * @Copyright: 个人版权所有
 * @Company:
 * @version: 1.0.0
 */
public class AccordionTransformer extends ABaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        view.setPivotX(position < 0 ? 0 : view.getWidth());
        view.setScaleX(position < 0 ? 1f + position : 1f - position);
    }

}
