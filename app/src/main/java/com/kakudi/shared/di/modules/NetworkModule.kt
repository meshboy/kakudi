package com.kakudi.shared.di.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kakudi.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.File
import javax.inject.Named

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
@Module
class NetworkModule {

    @Provides
    fun providesLogggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.i(message) })
    }

    @Provides
    fun providesFile(providesContext: Context): File {
        return File(providesContext.cacheDir, "okhttp-network-cache")
    }

    @Provides
    fun providesCacheFile(providesFile: File): Cache {
        return Cache(providesFile, 10 * 1000 * 1000) //10MB cache
    }

    @Provides
    fun providesOkHttpClient(
        providesLoggingInterceptor: HttpLoggingInterceptor,
        providesCache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(providesLoggingInterceptor)
            .cache(providesCache)
            .build()
    }

    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @Provides
    @Named("RetrofitMod")
    fun retrofit(providesGson: Gson, providesOkHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(providesOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create(providesGson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}