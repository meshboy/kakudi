package com.kakudi.login.presenter

import android.annotation.SuppressLint
import com.kakudi.intro.view.MainIntroView
import com.kakudi.login.di.usecase.LoginUseCase
import com.kakudi.login.view.LoginView
import com.kakudi.shared.mvp.BasePresenter
import com.kakudi.shared.vo.UserVO
import com.kakudi.user.di.usecase.CreateLocalAccount
import retrofit2.HttpException
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 30/03/2019
 */
class LoginPresenter @Inject constructor(
    private val mainIntroView: MainIntroView,
    private val loginUseCase: LoginUseCase,
    private val createLocalAccount: CreateLocalAccount
) :
    BasePresenter<LoginView>() {

    fun navigateToRegistrationScreen() {
        mainIntroView.navigateToRegisterScreenFromLoginScreen()
    }

    @SuppressLint("CheckResult")
    fun loginUser(email: String, password: String) {

        ifViewAttached { view ->
            if (isUserCredentialsValid(email, password)) {
                view.showLoading()
                loginUseCase.execute(UserVO(email = email, password = password))
                    .subscribe({ user ->
                        createLocalAccount.execute(user)
                            .subscribe {
                                view.hideLoading()
                                mainIntroView.navigateToHomeScreen()
                            }
                    }, {
                        ifViewAttached { v -> v.showError("Something went wrong. Please try again"); v.hideLoading() }
                    })

            } else {
                view.showError("Please enter your credentials")
            }
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