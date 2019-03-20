package com.kakudi.shared.di.modules

import android.content.Context
import com.kakudi.category.data.dao.CategoryDao
import com.kakudi.category.data.repositories.CategoryRepository
import com.kakudi.category.data.repositories.CategoryRepositoryImpl
import com.kakudi.category.data.sources.db.CategoryLocalSource
import com.kakudi.expense.data.dao.ExpenseDao
import com.kakudi.expense.data.repositories.ExpenseRepository
import com.kakudi.expense.data.repositories.ExpenseRepositoryImpl
import com.kakudi.expense.data.sources.db.ExpenseLocalResource
import com.kakudi.shared.domain.db.KakudiRoomDatabase
import com.kakudi.user.data.dao.UserDao
import com.kakudi.user.data.repository.UserRepository
import com.kakudi.user.data.repository.UserRepositoryImpl
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
    fun providesCategoryDao(providesContext: Context): CategoryDao {
        return KakudiRoomDatabase.getInstance(providesContext).categoryDao()
    }

    @Provides
    @Named("localCategoryResource")
    fun providesCategoryLocalSource(providesCategoryDao: CategoryDao): CategoryLocalSource {
        return CategoryLocalSource(providesCategoryDao)
    }

    @Provides
    fun providesCategoryRepository(providesCategoryLocalSource: CategoryLocalSource): CategoryRepository {
        return CategoryRepositoryImpl(providesCategoryLocalSource)
    }


    @Provides
    fun providesExpenseDao(providesContext: Context): ExpenseDao {
        return KakudiRoomDatabase.getInstance(providesContext).expenseDao()
    }

    @Provides
    @Named("localExpenseResource")
    fun providesExpenseLocalSource(providesExpenseDao: ExpenseDao): ExpenseLocalResource {
        return ExpenseLocalResource(providesExpenseDao)
    }

    @Provides
    fun providesExpenseRepository(providesExpenseLocalSource: ExpenseLocalResource): ExpenseRepository {
        return ExpenseRepositoryImpl(providesExpenseLocalSource)
    }

    @Provides
    fun providesUserDao(providesContext: Context): UserDao{
        return KakudiRoomDatabase.getInstance(providesContext).userDao()
    }

    @Provides
    fun providesUserRepository(providesUserDao: UserDao): UserRepository {
        return UserRepositoryImpl(providesUserDao)
    }
}