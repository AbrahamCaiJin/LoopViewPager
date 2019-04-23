package com.jingewenku.abrahamcaijin.loopviewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class ViewPagerFragment extends Fragment {
    public TextView viewText;
    public String name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_view_pager,container,false);
        viewText=view.findViewById(R.id.view_text);
        Bundle bundle=getArguments();
        name=bundle.getString("name");
        viewText.setText(name);
        Log.e("Fragment_onCreate",name);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("Fragment_onDestroy",name);
    }

}
