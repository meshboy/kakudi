package com.kakudi.intro.di.components

import com.kakudi.intro.di.modules.MainIntroModule
import com.kakudi.intro.ui.MainWelcomeFragment
import com.kakudi.login.ui.LoginFragment
import com.kakudi.register.ui.RegisterFragment
import dagger.Subcomponent

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 23/03/2019
 */
@Subcomponent(modules = [MainIntroModule::class])
interface MainIntroSubComponent {
    fun inject(fragment: MainWelcomeFragment)
    fun inject(fragment: LoginFragment)
    fun  inject(fragment: RegisterFragment)
}