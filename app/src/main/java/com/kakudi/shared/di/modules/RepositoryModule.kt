package com.kakudi.shared.di.modules

import android.content.Context
import com.kakudi.category.data.dao.CategoryDao
import com.kakudi.shared.domain.db.KakudiRoomDatabase
import dagger.Module
import dagger.Provides

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
@Module
class RepositoryModule {

    @Provides
    fun providesCategoryRepository(providesContext: Context): CategoryDao {
        return KakudiRoomDatabase.getInstance(providesContext).categoryDao()
    }
}