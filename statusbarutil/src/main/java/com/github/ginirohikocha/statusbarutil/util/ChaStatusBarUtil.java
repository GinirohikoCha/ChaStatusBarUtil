package com.github.ginirohikocha.statusbarutil.util;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * 沉浸式状态栏工具
 * @author GinirohikoCha
 */
public class ChaStatusBarUtil {

    private static int visibility;

    // 全透明状态栏与半透明底部虚拟按键
    public static final int TRANSPARENT_STATUS_BAR_AND_TRANSLUCENT_NAVIGATION_BAR = 0;
    // 全透明状态栏与全透明底部虚拟按键
    public static final int TRANSPARENT_SYSTEM_BAR = 1;
    // 全透明状态栏与隐藏底部虚拟按键
    public static final int TRANSPARENT_STATUS_BAR_AND_HIDDEN_NAVIGATION_BAR = 2;

    /**
     * 设置沉浸式模式
     * @param activity activity
     * @param type 模式类型
     * */
    public static void setImmersiveSystemBar(Activity activity, int type) {
        visibility = 0;
        isHiddenBottom = false;
        setTransparentStatusBar(activity);
        switch (type) {
            default:
            case TRANSPARENT_STATUS_BAR_AND_TRANSLUCENT_NAVIGATION_BAR:
                setTranslucentBottomVirtualNavigation(activity);
                break;
            case TRANSPARENT_SYSTEM_BAR:
                setTransparentBottomVirtualNavigation(activity);
                break;
            case TRANSPARENT_STATUS_BAR_AND_HIDDEN_NAVIGATION_BAR:
                hideBottomVirtualNavigation(activity);
                break;
        }
    }

    /**
     * 获取状态栏高度
     * @param activity activity
     */
    public static int getStatusBarHeight(Activity activity) {
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return activity.getResources().getDimensionPixelSize(resourceId);
    }

    /**
     * 获取导航栏高度
     * @param activity activity
     */
    public static int getNavigationBarHeight(Activity activity) {
        int resourceId = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return activity.getResources().getDimensionPixelSize(resourceId);
    }

    /*
     * 顶部状态栏
     * */
    private static final int transparentSystemBar = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

    /**
     * 设置透明系统状态栏
     * @param activity activity
     * */
    private static void setTransparentStatusBar(Activity activity) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        visibility |= transparentSystemBar;
        window.getDecorView().setSystemUiVisibility(visibility);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    /**
     * 设置浅色状态栏时，使状态栏显示黑色图标与字符
     * @param activity activity
     * */
    public static void setStatusBarLightMode(Activity activity) {
        int setStatusBarLightMode = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        visibility |= setStatusBarLightMode;
        activity.getWindow().getDecorView().setSystemUiVisibility(visibility);
    }

    /**
     * 设置浅色状态栏时，使导航栏显示黑色图标与字符
     * @param activity activity
     * */
    public static void setNavigationBarLightMode(Activity activity) {
        int setNavigationBarLightMode = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        visibility |= setNavigationBarLightMode;
        activity.getWindow().getDecorView().setSystemUiVisibility(visibility);
    }

    /*
    * 底部导航栏
    * */
    private static boolean isHiddenBottom = false;

    /**
     * 隐藏底部导航栏
     * @param activity activity
     */
    public static void hideBottomVirtualNavigation(Activity activity) {
        isHiddenBottom = true;
        // 隐藏虚拟按键，并且全屏
        int hideBottomVirtualNavigation = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        visibility |= hideBottomVirtualNavigation;
        activity.getWindow().getDecorView().setSystemUiVisibility(visibility);
    }

    /**
     * 设置透明底部导航栏
     * @param activity activity
     */
    public static void setTransparentBottomVirtualNavigation(Activity activity) {
        visibility |= transparentSystemBar;
        activity.getWindow().getDecorView().setSystemUiVisibility(visibility);
        activity.getWindow().setNavigationBarColor(Color.TRANSPARENT);
    }

    /**
     * 设置半透明底部导航栏
     * @param activity activity
     */
    public static void setTranslucentBottomVirtualNavigation(Activity activity) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }
}
