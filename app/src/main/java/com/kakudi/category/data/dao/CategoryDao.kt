package com.kakudi.category.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kakudi.category.data.model.Category
import io.reactivex.Observable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
@Dao
interface CategoryDao {

    @Query("SELECT * FROM Categories WHERE userId = :userId")
    fun getCategoriesById(userId: String): Observable<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)
}