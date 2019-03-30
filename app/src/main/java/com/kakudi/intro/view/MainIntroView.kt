package com.kakudi.intro.view

import com.kakudi.shared.mvp.BaseView

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 23/03/2019
 */
interface MainIntroView : BaseView {
    fun navigateToWelcomeScreenFromSplashScreen()
    fun navigateToLoginScreenFromFromWelcomeScreen()
    fun navigateToRegisterScreenFromWelcomeScreen()
    fun navigateToRegisterScreenFromLoginScreen()
    fun navigateToLoginScreenFromRegisterScreen()
    fun navigateToHomeScreen()
}