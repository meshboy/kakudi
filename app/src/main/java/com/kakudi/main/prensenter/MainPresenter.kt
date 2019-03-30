package com.kakudi.main.prensenter

import com.kakudi.main.view.MainView
import com.kakudi.shared.mvp.BasePresenter
import com.kakudi.user.data.repository.UserRepository
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 20/03/2019
 */
class MainPresenter @Inject constructor(val userRepository: UserRepository) :
    BasePresenter<MainView>() {

    fun onLogin() {

    }
}