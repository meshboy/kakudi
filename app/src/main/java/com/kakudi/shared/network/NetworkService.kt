package com.kakudi.shared.network

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 03/04/2019
 */
class NetworkService @Inject constructor(@Named("RetrofitMod") private val retrofit: Retrofit) {

    val api: ApiService
        get() = retrofit.create(ApiService::class.java)
}