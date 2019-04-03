package com.kakudi.intro.presenter

import android.annotation.SuppressLint
import com.kakudi.intro.view.MainIntroView
import com.kakudi.shared.mvp.BasePresenter
import com.kakudi.user.di.usecase.CurrentUser
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 23/03/2019
 */
class MainIntroPresenter @Inject constructor(private val currentUser: CurrentUser) :
    BasePresenter<MainIntroView>() {


    @SuppressLint("CheckResult")
    fun navigateUserBasedOnLoginStatus() {
        currentUser.execute()
            .subscribe({
                ifViewAttached { view ->
                    view.navigateToHomeScreen()
                }
            }, {
                ifViewAttached { view ->
                    view.navigateToWelcomeScreenFromSplashScreen()
                }
                it.printStackTrace()
            })
    }
}