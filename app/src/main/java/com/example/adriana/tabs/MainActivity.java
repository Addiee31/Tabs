package com.example.adriana.tabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


import android.content.Context;
import com.example.adriana.tabs.MyFragmentPageAdapter;
import com.example.adriana.tabs.FragmentArtista;
import com.example.adriana.tabs.FragmentAlbum;
import com.example.adriana.tabs.FragmentCanciones;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;



public class MainActivity extends ActionBarActivity  implements
        OnTabChangeListener, OnPageChangeListener {
    private TabHost tabHost;
    private ViewPager viewPager;
    private MyFragmentPageAdapter myViewPagerAdapter;
    int i = 0;

    // fake content for tabhost
    class FakeContent implements TabContentFactory {
        private final Context mContext;

        public FakeContent(Context context) {
            mContext = context;
        }

        @Override
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumHeight(0);
            v.setMinimumWidth(0);
            return v;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i++;

        // init tabhost
        this.initializeTabHost(savedInstanceState);

        // init ViewPager
        this.initializeViewPager();


        /*

        actionBar.setTitle("Agregar");
        actionBar.setSubtitle("Opciones a agregar");


        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        ActionBar.Tab tab = actionBar.newTab().setText("Album").setTabListener(new TabsListener(
                this, "album", FragmentAlbum.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Artista")
                .setTabListener(new TabsListener(   this, "artista", FragmentArtista.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Canciones")
                .setTabListener(new TabsListener(
                        this, "canciones", FragmentCanciones.class));
        actionBar.addTab(tab);
        */
    }
    private void initializeViewPager() {
        List<Fragment> fragments = new Vector<Fragment>();

        fragments.add(new FragmentAlbum());
        fragments.add(new FragmentArtista());


        this.myViewPagerAdapter = new MyFragmentPageAdapter(
                getSupportFragmentManager(), fragments);
        this.viewPager = (ViewPager) super.findViewById(R.id.view_pager);
        this.viewPager.setAdapter(this.myViewPagerAdapter);
        this.viewPager.setOnPageChangeListener(this);

        onRestart();

    }

    private void initializeTabHost(Bundle args) {

        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        for (int i = 1; i <= 2; i++) {

            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec("Tab " + i);
            tabSpec.setIndicator("Tab " + i);
            tabSpec.setContent(new FakeContent(this));
            tabHost.addTab(tabSpec);
        }
        tabHost.setOnTabChangedListener(this);
    }


    public void onTabChanged(String tabId) {
        int pos = this.tabHost.getCurrentTab();
        this.viewPager.setCurrentItem(pos);

        HorizontalScrollView hScrollView = (HorizontalScrollView) findViewById(R.id.hScrollView);
        View tabView = tabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft()
                - (hScrollView.getWidth() - tabView.getWidth()) / 2;
        hScrollView.smoothScrollTo(scrollPos, 0);

    }


    public void onPageScrollStateChanged(int arg0) {
    }


    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }


    public void onPageSelected(int position) {
        this.tabHost.setCurrentTab(position);
    }


/*
    public class TabsListener implements ActionBar.TabListener {

        public final Fragment fragment;
        public final String tag;

        public TabsListener(Activity activity, String tag, Class cls) {
            this.tag = tag;
            fragment=Fragment.instantiate(activity, cls.getName());
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
            ft.replace(android.R.id.content, fragment, tag);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
            ft.remove(fragment);
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

        }
    }

    */

}
