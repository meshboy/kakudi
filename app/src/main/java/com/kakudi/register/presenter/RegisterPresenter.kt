package com.kakudi.register.presenter

import android.annotation.SuppressLint
import com.kakudi.intro.view.MainIntroView
import com.kakudi.register.di.usecases.CreateAccount
import com.kakudi.register.view.RegisterView
import com.kakudi.shared.mvp.BasePresenter
import com.kakudi.shared.vo.UserVO
import com.kakudi.user.di.usecase.CreateLocalAccount
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 30/03/2019
 */
@SuppressLint("CheckResult")
class RegisterPresenter @Inject constructor(
    private val createAccount: CreateAccount,
    private val createLocalAccount: CreateLocalAccount,
    private val mainIntroView: MainIntroView
) :
    BasePresenter<RegisterView>() {

    fun createAccount(username: String, email: String, password: String, confirmPassword: String) {

        ifViewAttached { view ->

            if (isUserObjectValid(username, email, password, confirmPassword)) {
                view.showLoading()
                createAccount.execute(UserVO(username, password, email))
                    .subscribe({ user ->
                        createLocalAccount.execute(user)
                            .subscribe {
                                view.hideLoading()
                                mainIntroView.navigateToHomeScreen()
                            }
                    }, { err ->
                        view.hideLoading()
                        err.printStackTrace()
                        view.showError(err.message ?: "Something went wrong. Please try  again")
                    })
            }
        }

    }


    fun isUserObjectValid(
        username: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {

        return when {

            username.isEmpty() -> {
                ifViewAttached {
                    it.showError("Username field can't be empty")
                }
                false
            }

            email.isEmpty() -> {
                ifViewAttached {
                    it.showError("Email field can't be empty")
                }
                false
            }

            password.isEmpty() -> {
                ifViewAttached {
                    it.showError("Password field can't be empty")
                }
                false
            }

            confirmPassword.isEmpty() -> {
                ifViewAttached {
                    it.showError("Confirm password field can't be empty")
                }
                false
            }

            confirmPassword != password -> {
                ifViewAttached {
                    it.showError("Password and Confirm password must be the same")
                }
                false
            }


            else -> true
        }
    }
}