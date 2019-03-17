package com.kakudi.shared.di.modules

import android.content.Context
import com.kakudi.category.data.dao.CategoryDao
import com.kakudi.expense.data.dao.ExpenseDao
import com.kakudi.shared.domain.db.KakudiRoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
@Module
class RepositoryModule {

    @Provides
    @Named("localCategoryResource")
    fun providesCategoryRepository(providesContext: Context): CategoryDao {
        return KakudiRoomDatabase.getInstance(providesContext).categoryDao()
    }

    @Provides
    @Named("localExpenseResource")
    fun  providesExpenseRepository(providesContext: Context): ExpenseDao {
        return KakudiRoomDatabase.getInstance(providesContext).expenseDao()
    }

}