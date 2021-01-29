package com.github.ginirohikocha.statusbarutil.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.github.ginirohikocha.statusbarutil.R;
import com.github.ginirohikocha.statusbarutil.adapter.TabLayoutAdapter;
import com.github.ginirohikocha.statusbarutil.fragment.FragmentHomepage;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends ChaStatusBarActivity {

    protected DrawerLayout root;
    protected RelativeLayout rtToolBar;
    protected TabLayout tab;
    protected ViewPager viewpager;
    protected ImageView btnMenu;

    private boolean isSliding = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_01190906);

        setImmersiveSystemBar(TRANSPARENT_SYSTEM_BAR);
        setStatusBarLightMode();
        setNavigationBarLightMode();

        findViewById();
        initViews();
    }

    protected void findViewById() {
        root = findViewById(R.id.root);
        rtToolBar = findViewById(R.id.main_rtToolBar);
        tab = findViewById(R.id.tab);
        viewpager = findViewById(R.id.viewpager);
        btnMenu = findViewById(R.id.toolBar_menu);
    }

    protected void initViews() {
        rtToolBar.setPadding(0, getStatusBarHeight(), 0, 0);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.openDrawer(GravityCompat.START);
            }
        });
        initTab();
        root.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
                if (v == 0) {
                    isSliding = false;
                    setImmersiveSystemBar(TRANSPARENT_SYSTEM_BAR);
                    setStatusBarLightMode();
                    setNavigationBarLightMode();
                } else if (v == 1) {
                    isSliding = false;
                    setImmersiveSystemBar(TRANSPARENT_STATUS_BAR_AND_TRANSLUCENT_NAVIGATION_BAR);
                } else {
                    if (!isSliding) {
                        isSliding = true;
                        setImmersiveSystemBar(TRANSPARENT_STATUS_BAR_AND_HIDDEN_NAVIGATION_BAR);
                    }
                }
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
            }

            @Override
            public void onDrawerStateChanged(int i) {
            }
        });
    }

    protected String[] tabTitles;
    protected Fragment[] tabFragments = {
            FragmentHomepage.newInstance(),
            FragmentHomepage.newInstance(),
            FragmentHomepage.newInstance()};

    protected void initTab() {
        tabTitles = new String[]{
                getResources().getString(R.string.homepage),
                getResources().getString(R.string.discover),
                getResources().getString(R.string.message)};

        TabLayoutAdapter adapter = new TabLayoutAdapter(getSupportFragmentManager());
        for (int i=0; i<tabTitles.length; i++)
            adapter.addFragment(tabFragments[i], tabTitles[i]);

        viewpager.setAdapter(adapter);
        tab.setupWithViewPager(viewpager);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (root.isDrawerOpen(GravityCompat.START)) {
                root.closeDrawer(GravityCompat.START);
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
