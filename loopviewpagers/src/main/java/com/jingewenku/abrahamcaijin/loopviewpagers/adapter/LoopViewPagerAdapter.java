package com.jingewenku.abrahamcaijin.loopviewpagers.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.jingewenku.abrahamcaijin.loopviewpagers.interfaces.CreateView;
import com.jingewenku.abrahamcaijin.loopviewpagers.interfaces.OnPageClickListener;

import java.util.List;

/**
 * 主要功能:
 *
 * @Prject: LoopViewPager
 * @Package: com.jingewenku.abrahamcaijin.loopviewpagers.adapter
 * @author: Abraham
 * @date: 2019年04月20日 14:05
 * @Copyright: 个人版权所有
 * @Company:
 * @version: 1.0.0
 */

public class LoopViewPagerAdapter<T> extends PagerAdapter {
    private OnPageClickListener onClickListener;
    private CreateView mCreateView;
    private Context context;
    private List<T> mData;

    public LoopViewPagerAdapter(Context context, List<T> list, CreateView createView, OnPageClickListener onClickListener){
        this.onClickListener=onClickListener;
        this.mCreateView=createView;
        this.context=context;
        this.mData=list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position=position%mData.size();
        if(mCreateView==null){
            return new View(context);
        }
        View view=mCreateView.createView(position);
        final int finalPosition = position;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onClickListener!=null){
                    onClickListener.onClick(view, finalPosition);
                }
            }
        });
        ViewParent vp = view.getParent();
        if (vp != null) {
            ViewGroup parent = (ViewGroup)vp;
            parent.removeView(view);
        }
        mCreateView.updateView(view,position,mData.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
        mCreateView.deleteView(position);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
        return arg0==arg1;
    }

}