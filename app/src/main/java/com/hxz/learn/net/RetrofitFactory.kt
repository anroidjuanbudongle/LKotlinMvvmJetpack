package com.hxz.learn.net

import com.hxz.learn.Constants
import com.hxz.learn.config.LApplication
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * @author andy
 * @Date2020/12/24 22:43
 * @Description:
 */
object RetrofitFactory {

    private val mOkHttpClientBuilder: OkHttpClient.Builder
        get() {
            return OkHttpClient.Builder()
                .readTimeout(
                    Constants.DEFAULT_TIMEOUT.toLong(),
                    TimeUnit.MILLISECONDS
                )
                .connectTimeout(
                    Constants.DEFAULT_TIMEOUT.toLong(),
                    TimeUnit.MILLISECONDS
                )
//                .addInterceptor(getLogInterceptor())
//                .cookieJar(getCookie())
                .cache(getCache)


        }

//    /**
//     * 获取日志拦截器
//     */
//    private fun getLogInterceptor(): Interceptor {
//        //http log 拦截器
//        return HttpLoggingInterceptor("OkHttp").apply {
//            setPrintLevel(HttpLoggingInterceptor.Level.BODY)
//            setColorLevel(Level.INFO)
//        }
//    }

    //缓存
    private val getCache: Cache
        get() {
            return Cache(
                File(LApplication.getContext().cacheDir, Constants.CACHE_NAME),
                1024 * 1024 * 100
            )
        }

}