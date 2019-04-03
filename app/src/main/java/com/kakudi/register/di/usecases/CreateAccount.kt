package com.kakudi.register.di.usecases

import com.kakudi.shared.network.NetworkService
import com.kakudi.shared.usecases.OneInputUseCase
import com.kakudi.shared.vo.UserVO
import com.kakudi.user.data.model.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 03/04/2019
 */
class CreateAccount @Inject constructor(private val networkService: NetworkService) :
    OneInputUseCase<UserVO, User> {
    override fun execute(input: UserVO): Observable<User>{
        return networkService.api.createAccount(input)
            .map {
                it.data
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}