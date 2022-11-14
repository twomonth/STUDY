package com.twomonth.base.utils;

import android.content.Context;
import android.graphics.Color;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.style.MaterialStyle;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * 初始化基础模块
 */
public class BaseInit {

    /**
     * 初始化日志框架
     *
     * @param isDebug 是否打印日志
     */
    public static void loggerInit(boolean isDebug) {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                //.logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("twomonth")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return isDebug;
            }
        });
    }

    /**
     * 初始化 DialogX
     * @param context 上下文
     */
    public static void dialogXInit(Context context) {
        DialogX.init(context);
        //开启调试模式，在部分情况下会使用 Log 输出日志信息
        DialogX.DEBUGMODE = true;
        //设置主题样式
//        DialogX.globalStyle = IOSStyle.style();
        DialogX.globalStyle = MaterialStyle.style();
        //设置亮色/暗色（在启动下一个对话框时生效）
        DialogX.globalTheme = DialogX.THEME.LIGHT;
        //设置对话框最大宽度（单位为像素）
        DialogX.dialogMaxWidth = 1920;
        //设置 InputDialog 自动弹出键盘
        DialogX.autoShowInputKeyboard = true;
        //限制 PopTip 一次只显示一个实例（关闭后可以同时弹出多个 PopTip）
        DialogX.onlyOnePopTip = true;
//        //设置对话框默认按钮文本字体样式
//        DialogX.buttonTextInfo = (TextInfo);
//        //设置对话框默认确定按钮文字样式
//        DialogX.okButtonTextInfo = (TextInfo);
//        //设置对话框默认标题文字样式
//        DialogX.titleTextInfo = (TextInfo);
//        //设置对话框默认内容文字样式
//        DialogX.messageTextInfo = (TextInfo);
//        //设置默认 WaitDialog 和 TipDialog 文字样式
//        DialogX.tipTextInfo = (TextInfo);
//        //设置默认输入框文字样式
//        DialogX.inputInfo = (InputInfo);
//        //设置默认底部菜单、对话框的标题文字样式
//        DialogX.menuTitleInfo = (TextInfo);
//        //设置默认底部菜单文本样式
//        DialogX.menuTextInfo = (TextInfo);
        //设置默认对话框背景颜色（值为ColorInt，为-1不生效）
        DialogX.backgroundColor = Color.WHITE;
//        //设置默认对话框默认是否可以点击外围遮罩区域或返回键关闭，此开关不影响提示框（TipDialog）以及等待框（TipDialog）
//        DialogX.cancelable = true;
//        //设置默认提示框及等待框（WaitDialog、TipDialog）默认是否可以关闭
//        DialogX.cancelableTipDialog = false;
//        //设置默认取消按钮文本文字，影响 BottomDialog
//        DialogX.cancelButtonText = (String);
//        //设置默认 PopTip 文本样式
//        DialogX.popTextInfo = (TextInfo);
//        //设置全局 Dialog 生命周期监听器
//        DialogX.dialogLifeCycleListener = (DialogLifecycleCallback);
//        //设置 TipDialog 和 WaitDialog 明暗风格，不设置则默认根据 globalTheme 定义
//        DialogX.tipTheme = (THEME);
//        //默认 TipDialog 和 WaitDialog 背景颜色（值为 ColorInt，为-1不生效）
//        DialogX.tipBackgroundColor = (ColorInt)
//        /**
//         * 重写 TipDialog 和 WaitDialog 进度动画颜色，
//         * 注意此属性为覆盖性质，即设置此值将替换提示框原本的进度动画的颜色，包括亮暗色切换的颜色变化也将被替代
//         * （值为 ColorInt，为-1不生效）
//         */
//        DialogX.tipProgressColor = (ColorInt)
//        /**
//         * 设置 BottomDialog 导航栏背景颜色
//         */
         DialogX.bottomDialogNavbarColor = Color.TRANSPARENT;

        //是否自动在主线程执行
        DialogX.autoRunOnUIThread = true;
        //使用振动反馈（影响 WaitDialog、TipDialog）
        DialogX.useHaptic = true;
    }
}
