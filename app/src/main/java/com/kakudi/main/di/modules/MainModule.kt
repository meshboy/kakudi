package com.kakudi.main.di.modules

import com.kakudi.main.view.MainView
import dagger.Module
import dagger.Provides

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 19/03/2019
 */
@Module
class MainModule (private val mainView: MainView) {

    @Provides
    fun providesMainView(): MainView {
        return mainView
    }
}