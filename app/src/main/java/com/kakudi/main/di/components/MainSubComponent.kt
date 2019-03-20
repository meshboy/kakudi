package com.kakudi.main.di.components

import com.kakudi.category.ui.CategoryFragment
import com.kakudi.main.di.modules.MainModule
import dagger.Subcomponent

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 19/03/2019
 */
@Subcomponent(modules = [(MainModule::class)])
interface MainSubComponent {
    fun inject(fragment: CategoryFragment)
}