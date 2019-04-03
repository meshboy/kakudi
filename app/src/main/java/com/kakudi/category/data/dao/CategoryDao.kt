package com.kakudi.category.data.dao

import androidx.room.*
import com.kakudi.category.data.model.Category
import io.reactivex.Completable
import io.reactivex.Observable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
@Dao
interface CategoryDao {

    @Query("SELECT * FROM Categories WHERE userId = :userId")
    fun getCategoriesByUserId(userId: String): Observable<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category): Completable

    @Delete
    fun delete(category: Category)
}