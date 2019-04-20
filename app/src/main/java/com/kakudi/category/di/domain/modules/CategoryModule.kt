package com.kakudi.category.di.domain.modules

import com.kakudi.category.view.CategoryView
import dagger.Module
import dagger.Provides

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 20/04/2019
 */
@Module
class CategoryModule(val  categoryView: CategoryView) {

    @Provides
    fun providesCategoryView(): CategoryView {
        return categoryView
    }
}