package com.twomonth.study.net;

import com.safframework.http.interceptor.AndroidLoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import rxhttp.RxHttpPlugins;

public class NetWork {
    public static void init(boolean isDebug){
        // 首先 配置okhttp
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS) // 链接超时阈值
                .writeTimeout(10,TimeUnit.SECONDS) // 写入超时
                .readTimeout(10,TimeUnit.SECONDS) // 读取超时
                .retryOnConnectionFailure(true)//连接失败后是否重新连接
                .addInterceptor(new CommonHeaderInterceptor())
                .addInterceptor(AndroidLoggingInterceptor.build(isDebug,false))//添加应用拦截器-日志拦截器
//                .cache(new Cache(new File(mContext.getExternalCacheDir(), "myCatche"), 10 * 1024 * 1024))//添加缓存
                .connectTimeout(15, TimeUnit.SECONDS)//超时时间15S
                .build();
        RxHttpPlugins.init(client);
    }
}
