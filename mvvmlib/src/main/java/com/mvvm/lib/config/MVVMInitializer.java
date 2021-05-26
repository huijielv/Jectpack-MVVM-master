package com.mvvm.lib.config;


import android.content.Context;



import com.mvvm.lib.util.UIUtils;

import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;

public class MVVMInitializer {

    private static Context context;

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context) {
        init(context, 360, 640);
    }

    /**
     * 初始化
     *
     * @param context
     * @param width   屏幕适配，底图尺寸
     * @param height  屏幕适配，底图尺寸
     */
    public static void init(Context context, int width, int height) {
        MVVMInitializer.context = context;
        // 主项目配置
        UIUtils.init(context);


        // 适配配置
        try {
            AutoSize.initCompatMultiProcess(context);
            AutoSizeConfig.getInstance().setDesignWidthInDp(375);
            AutoSizeConfig.getInstance().setDesignHeightInDp(667);
            AutoSize.initCompatMultiProcess(context);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
