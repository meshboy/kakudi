package com.kakudi.intro.welcome.presenter

import com.kakudi.intro.view.MainIntroView
import com.kakudi.intro.welcome.view.WelcomeView
import com.kakudi.shared.mvp.BasePresenter
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 23/03/2019
 */
class WelcomePresenter @Inject constructor(private val mainIntroView: MainIntroView) :
    BasePresenter<WelcomeView>() {

    fun goToLogin() {
        mainIntroView.navigateToLoginScreenFromFromWelcomeScreen()
    }

    fun goToRegister() {
        mainIntroView.navigateToRegisterScreenFromWelcomeScreen()
    }
}