package com.kakudi.login.presenter

import com.kakudi.intro.view.MainIntroView
import com.kakudi.login.view.LoginView
import com.kakudi.shared.mvp.BasePresenter
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 30/03/2019
 */
class LoginPresenter @Inject constructor(private val mainIntroView: MainIntroView) :
    BasePresenter<LoginView>() {

    fun navigateToRegistrationScreen() {
        mainIntroView.navigateToRegisterScreenFromLoginScreen()
    }

    fun loginUser(email: String, password: String) {

        ifViewAttached { view ->
            view.showLoading()
        }

        if (isUserCredentialsValid(email, password)) {

            ifViewAttached { view ->
                view.hideLoading()
            }

//            TODO: connect to server to navigate user in
//            TODO: save user details in the db
            mainIntroView.navigateToHomeScreen()

        } else {
            ifViewAttached { v -> v.showError("Please enter your credentials"); v.hideLoading() }
        }

    }

    private fun isUserCredentialsValid(email: String, password: String): Boolean {

        return when {
            email.isEmpty() -> false
            password.isEmpty() -> false
            else -> {
                true
            }
        }
    }
}