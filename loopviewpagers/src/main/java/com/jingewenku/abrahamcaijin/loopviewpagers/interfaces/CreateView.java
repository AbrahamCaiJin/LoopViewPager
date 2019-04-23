package com.jingewenku.abrahamcaijin.loopviewpagers.interfaces;

import android.view.View;

/**
 * 主要功能:
 *
 * @Prject: LoopViewPager
 * @Package: com.jingewenku.abrahamcaijin.loopviewpagers.interfaces
 * @author: Abraham
 * @date: 2019年04月20日 14:05
 * @Copyright: 个人版权所有
 * @Company:
 * @version: 1.0.0
 */

public interface CreateView<T> {

    View createView(int position);

    void updateView(View view, int position, T item);

    void deleteView(int position);

}