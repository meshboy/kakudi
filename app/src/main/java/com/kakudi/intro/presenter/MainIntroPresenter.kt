package com.kakudi.intro.presenter

import com.kakudi.intro.view.MainIntroView
import com.kakudi.shared.mvp.BasePresenter
import com.kakudi.user.data.repository.UserRepository
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 23/03/2019
 */
class MainIntroPresenter @Inject constructor(val userRepository: UserRepository) :
    BasePresenter<MainIntroView>()