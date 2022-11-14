package com.twomonth.net;


import java.io.IOException;
import java.util.Set;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @description okhttp拦截器，再次统一处理请求头
 * @author wangjianchao
 * @time 2022/11/3 10:00
 */
public class CommonHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request(); // 获取旧连接
        Request.Builder requestBuilder = oldRequest.newBuilder(); // 建立新的构建者
        // 将旧请求的请求方法和请求体设置到新请求中
        requestBuilder.method(oldRequest.method(), oldRequest.body());
        // 获取旧请求的头
        Headers headers = oldRequest.headers();
        if(headers!=null) {
            Set<String> names = headers.names();
            for (String name : names) {
                String value = headers.get(name);
                // 将旧请求的头设置到新请求中
                requestBuilder.header(name, value);
            }
        }
        // 添加额外的自定义公共请求头
        requestBuilder.header("appVersion", HeaderValue.appVersion);
        requestBuilder.header("os", "Android");
        requestBuilder.header("token", HeaderValue.token);
        // 建立新请求连接
        Request newRequest = requestBuilder.build();
        return chain.proceed(newRequest);
    }
}

