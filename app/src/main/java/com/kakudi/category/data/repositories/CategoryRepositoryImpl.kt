package com.kakudi.category.data.repositories

import com.kakudi.category.data.model.Category
import com.kakudi.category.data.sources.db.CategoryLocalSource
import io.reactivex.Observable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
class CategoryRepositoryImpl(private val localResource: CategoryLocalSource): CategoryRepository {

    override fun insert(data: Category): Observable<Unit> {
        return localResource.insert(data)
    }

    override fun getAllCategories(userId: String): Observable<List<Category>> {
        return localResource.getAllCategories(userId).filter{ it.isNotEmpty() }
    }

    override fun deleteCategory(name: String) {
        localResource.deleteCategory(name)
    }

    override fun deleteAll() {

    }
}