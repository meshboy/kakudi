package com.kakudi.intro

import com.kakudi.shared.mvp.BaseView

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 23/03/2019
 */
interface MainIntroView: BaseView {
    fun navigateToWelcomeScreenFromSplashScreen()
    fun navigateToLoginScreenFromFromWelcomeScreen()
    fun navigateToRegisterScreenFromWelcomeScreen()
    fun navigateToHomeScreen()
}