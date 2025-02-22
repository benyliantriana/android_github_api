package com.example.githubapiapp.lib_network.service

import com.example.githubapiapp.lib_network.interceptor.ConnectivityInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceImpl(
    private val connectivityInterceptor: ConnectivityInterceptor,
) : ApiService {

    companion object {
        private const val BASE_URL = "https://api.github.com/"
        private const val HEADER_API_VERSION = "X-GitHub-Api-Version"
        private const val VERSION = "2022-11-28"
    }

    override fun service(): Retrofit {
        val requestInterceptor = Interceptor { chain ->
            val url = chain.request()
                .url()
                .newBuilder()
                .build()
            val request = chain.request()
                .newBuilder()
                .addHeader(HEADER_API_VERSION, VERSION)
                .url(url)
                .build()
            return@Interceptor chain.proceed(request)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(connectivityInterceptor)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
