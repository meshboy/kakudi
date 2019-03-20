package com.kakudi.category.data.sources.db

import com.kakudi.category.data.dao.CategoryDao
import com.kakudi.category.data.model.Category
import com.kakudi.category.data.repositories.CategoryRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
class CategoryLocalSource @Inject constructor(private val categoryDao: CategoryDao) : CategoryRepository {

    override fun insert(data: Category): Observable<Unit> {
        return Observable.fromCallable {
            categoryDao.insertCategory(data)
        }
    }

    override fun getAllCategories(userId: String): Observable<List<Category>> {
        return categoryDao.getCategoriesByUserId(userId)
    }

    override fun delete(data: Category) {
        categoryDao.delete(data)
    }

    override fun update(data: Category) {

    }

    override fun deleteAll() {

    }
}