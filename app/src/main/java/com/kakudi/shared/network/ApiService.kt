package com.kakudi.shared.network

import com.kakudi.shared.vo.UserVO
import com.kakudi.user.data.model.User
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 03/04/2019
 */
interface ApiService {

    @POST("register")
    fun createAccount(@Body user: UserVO): Observable<ApiResponse<User>>

    @POST("login")
    fun login(@Body user: UserVO): Observable<ApiResponse<User>>
}