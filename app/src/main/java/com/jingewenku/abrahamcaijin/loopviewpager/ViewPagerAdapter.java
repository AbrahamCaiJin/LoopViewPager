package com.jingewenku.abrahamcaijin.loopviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 主要功能:
 *
 * @Prject: LoopViewPager
 * @Package: com.jingewenku.abrahamcaijin.loopviewpager
 * @author: Abraham
 * @date: 2019年04月20日 14:15
 * @Copyright: 个人版权所有
 * @Company:
 * @version: 1.0.0
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public List<Fragment> listFragment=new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> listFragment) {
        super(fm);
        this.listFragment=listFragment;
    }

    @Override
    public Fragment getItem(int i) {
        return listFragment.get(i);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }



}