package com.zcz.dangerous;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.zcz.dangerous.common.activity.BaseActivity;
import com.zcz.dangerous.main.fragment.HomeFragment;
import com.zcz.dangerous.main.fragment.ProfileFragment;
import com.zcz.dangerous.main.fragment.SearchFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by zhaocz on 2016/1/5.
 */
@EActivity(R.layout.main_activity)
public class MainActivity extends BaseActivity {

    @ViewById(R.id.tabhost)
    FragmentTabHost mTabHost;

    @AfterViews
    void afterViews() {
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        initMainTabs();
    }

    public void initMainTabs() {
        MainTab[] tabs = MainTab.values();
        for (int i = 0; i < tabs.length; i++) {
            MainTab tab = tabs[i];
            TabHost.TabSpec spec = mTabHost.newTabSpec(getString(tab.getResName()));
            View indicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, null);
            ImageView tabIcon = (ImageView) indicator.findViewById(R.id.tab_icon);
            tabIcon.setImageResource(tab.getResIcon());

            TextView tabTitle = (TextView) indicator.findViewById(R.id.tab_title);
            tabTitle.setText(tab.getResName());

            spec.setIndicator(indicator);
            mTabHost.addTab(spec, tab.getClz(), null);
            mTabHost.getTabWidget().setShowDividers(TabWidget.SHOW_DIVIDER_NONE);
        }
    }

    public enum MainTab {

        HOME(0, R.string.main_tab_name_home, R.drawable.tab_icon_home, HomeFragment.class),
        SEARCH(0, R.string.main_tab_name_search, R.drawable.tab_icon_search, SearchFragment.class),
        PROFILE(0, R.string.main_tab_name_profile, R.drawable.tab_icon_profile, ProfileFragment.class);

        private int resId;
        private int resName;
        private int resIcon;
        private Class<?> clz;

        private MainTab(int resId, int resName, int resIcon, Class<?> clz) {
            this.resId = resId;
            this.resName = resName;
            this.resIcon = resIcon;
            this.clz = clz;
        }

        public int getResId() {
            return resId;
        }

        public void setResId(int resId) {
            this.resId = resId;
        }

        public int getResName() {
            return resName;
        }

        public void setResName(int resName) {
            this.resName = resName;
        }

        public int getResIcon() {
            return resIcon;
        }

        public void setResIcon(int resIcon) {
            this.resIcon = resIcon;
        }

        public Class<?> getClz() {
            return clz;
        }

        public void setClz(Class<?> clz) {
            this.clz = clz;
        }
    }

}
