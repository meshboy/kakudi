package com.kakudi.category.di.domain.components

import com.kakudi.category.di.domain.modules.CategoryModule
import com.kakudi.category.ui.CategoryListFragment
import com.kakudi.category.ui.CreateCategoryFragment
import dagger.Subcomponent

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 20/04/2019
 */
@Subcomponent(modules = [(CategoryModule::class)])
interface CategorySubComponent {
    fun inject(fragment: CategoryListFragment)
    fun inject(fragment: CreateCategoryFragment)
}