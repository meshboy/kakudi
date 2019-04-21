package com.kakudi.user.di.usecase

import com.kakudi.user.data.model.User
import com.kakudi.user.data.repository.UserRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 03/04/2019
 */
class CurrentUser @Inject constructor(private val userRepository: UserRepository) {

    fun execute(): Observable<User> {
        return userRepository
            .getCurrentUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toObservable()
    }
}