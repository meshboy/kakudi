package com.kakudi.intro.di.modules

import com.kakudi.intro.view.MainIntroView
import dagger.Module
import dagger.Provides

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 23/03/2019
 */
@Module
class MainIntroModule(val mainIntroView: MainIntroView) {

    @Provides
    fun providesMainIntroView(): MainIntroView {
        return mainIntroView
    }
}