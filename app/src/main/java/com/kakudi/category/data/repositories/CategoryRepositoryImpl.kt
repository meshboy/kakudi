package com.kakudi.category.data.repositories

import com.kakudi.category.data.model.Category
import com.kakudi.category.data.sources.db.CategoryLocalSource
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
class CategoryRepositoryImpl @Inject constructor(@Named("localCategoryResource") private val localResource: CategoryLocalSource) :
    CategoryRepository {

    override fun insert(data: Category): Observable<Unit> {
        return localResource.insert(data)
    }

    override fun getAllCategories(userId: String): Observable<List<Category>> {
        return localResource.getAllCategories(userId).filter { it.isNotEmpty() }
    }


    override fun update(data: Category) {

    }

    override fun delete(data: Category) {
        localResource.delete(data)
    }

    override fun deleteAll() {

    }
}