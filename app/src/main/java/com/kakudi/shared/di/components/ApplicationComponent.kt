package com.kakudi.shared.di.components

import com.kakudi.main.ui.MainActivity
import com.kakudi.shared.di.modules.ContextModule
import com.kakudi.shared.di.modules.NetworkModule
import com.kakudi.shared.di.modules.RepositoryModule
import dagger.Component
import javax.inject.Singleton

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
@Singleton
@Component(modules = [ContextModule::class, NetworkModule::class, RepositoryModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}