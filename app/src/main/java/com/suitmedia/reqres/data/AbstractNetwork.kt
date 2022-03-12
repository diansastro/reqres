package com.suitmedia.reqres.data

import com.suitmedia.reqres.BuildConfig
import com.suitmedia.reqres.data.base.BaseNetwork
import com.suitmedia.reqres.data.interceptor.ContentTypeInterceptor
import okhttp3.OkHttpClient

abstract class AbstractNetwork<T>(): BaseNetwork<T>() {
    override fun getBaseUrl(): String = BuildConfig.BASE_URL

    override fun okHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        builder.addInterceptor(ContentTypeInterceptor())
        return super.okHttpClientBuilder(builder)
    }
}