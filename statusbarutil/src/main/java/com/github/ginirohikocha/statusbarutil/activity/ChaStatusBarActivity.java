package com.github.ginirohikocha.statusbarutil.activity;

import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 沉浸式状态栏工具
 * @author GinirohikoCha
 */
public class ChaStatusBarActivity extends AppCompatActivity {

    /*
     * 切换窗口后恢复底部状态栏原来状态
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (isHiddenBottom)
            hideBottomVirtualNavigation();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (isHiddenBottom)
            hideBottomVirtualNavigation();
    }

    private int visibility;

    // 全透明状态栏与半透明底部虚拟按键
    public static final int TRANSPARENT_STATUS_BAR_AND_TRANSLUCENT_NAVIGATION_BAR = 0;
    // 全透明状态栏与全透明底部虚拟按键
    public static final int TRANSPARENT_SYSTEM_BAR = 1;
    // 全透明状态栏与隐藏底部虚拟按键
    public static final int TRANSPARENT_STATUS_BAR_AND_HIDDEN_NAVIGATION_BAR = 2;

    /**
     * 设置完全沉浸式
     * @param type 模式类型
     * */
    public void setImmersiveSystemBar(int type) {
        visibility = 0;
        setTransparentStatusBar();
        switch (type) {
            default:
            case TRANSPARENT_STATUS_BAR_AND_TRANSLUCENT_NAVIGATION_BAR:
                setTranslucentBottomVirtualNavigation();
                break;
            case TRANSPARENT_SYSTEM_BAR:
                setTransparentBottomVirtualNavigation();
                break;
            case TRANSPARENT_STATUS_BAR_AND_HIDDEN_NAVIGATION_BAR:
                hideBottomVirtualNavigation();
                break;
        }
    }

    /**
     * 获取状态栏高度
     */
    public int getStatusBarHeight() {
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        return getResources().getDimensionPixelSize(resourceId);
    }
    /**
     * 获取导航栏高度
     */
    public int getNavigationBarHeight() {
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return getResources().getDimensionPixelSize(resourceId);
    }

    /*
     * 顶部状态栏
     * */
    private final int transparentSystemBar = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

    /**
     * 设置透明系统状态栏
     * */
    private void setTransparentStatusBar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        visibility |= transparentSystemBar;
        window.getDecorView().setSystemUiVisibility(visibility);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    /**
     * 设置浅色状态栏时，状态栏显示黑色图标与字符
     * */
    public void setStatusBarLightMode() {
        int setStatusBarLightMode = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        visibility |= setStatusBarLightMode;
        getWindow().getDecorView().setSystemUiVisibility(visibility);
    }

    /**
     * 设置浅色状态栏时，导航栏显示黑色图标与字符
     * */
    public void setNavigationBarLightMode() {
        int setNavigationBarLightMode = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        visibility |= setNavigationBarLightMode;
        getWindow().getDecorView().setSystemUiVisibility(visibility);
    }

    /*
     * 底部导航栏
     * */
    private boolean isHiddenBottom = false;

    public void hideBottomVirtualNavigation() {
        isHiddenBottom = true;
        // 隐藏虚拟按键，并且全屏
        int hideBottomVirtualNavigation = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        visibility |= hideBottomVirtualNavigation;
        getWindow().getDecorView().setSystemUiVisibility(visibility);
    }

    public void setTransparentBottomVirtualNavigation() {
        visibility |= transparentSystemBar;
        getWindow().getDecorView().setSystemUiVisibility(visibility);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);
    }

    public void setTranslucentBottomVirtualNavigation() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }
}
