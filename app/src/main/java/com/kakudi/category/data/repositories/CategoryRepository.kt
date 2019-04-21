package com.kakudi.category.data.repositories

import com.kakudi.category.data.model.Category
import com.kakudi.shared.domain.repositories.Repository
import io.reactivex.Observable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
interface CategoryRepository : Repository<Category> {
    fun getAllCategories(userId: Long): Observable<List<Category>>
}