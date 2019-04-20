package com.kakudi.main.prensenter

import android.annotation.SuppressLint
import com.kakudi.main.view.MainView
import com.kakudi.shared.mvp.BasePresenter
import com.kakudi.user.data.repository.UserRepository
import com.kakudi.user.di.usecase.CurrentUser
import timber.log.Timber
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 20/03/2019
 */
@SuppressLint("CheckResult")
class MainPresenter @Inject constructor(private val currentUser: CurrentUser) :
    BasePresenter<MainView>() {

    init {
        displayUsername()
    }

    fun displayUsername() {
        currentUser.execute()
            .subscribe({ user ->
                ifViewAttached {view ->
//                    view.showUsername(user.username)
                }
            }, { err ->
                err.printStackTrace()
            })
    }

}