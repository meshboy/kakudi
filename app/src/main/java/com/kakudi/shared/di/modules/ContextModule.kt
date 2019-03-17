package com.kakudi.shared.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
@Module
class ContextModule(private val context: Context) {

    @Provides
    fun providesContext(): Context = context
}