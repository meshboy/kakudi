package com.kakudi.user.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kakudi.user.data.model.User
import io.reactivex.Completable
import io.reactivex.Single

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
@Dao
interface UserDao {

    /**
     * Get a user by  token
     *
     *
     * @return the user from the table with  a specific token
     */

    @Query("SELECT * FROM Users")
    fun getCurrentUser(): Single<User>


    /**
     * insert a user into the database, if the user exist, replace it
     *
     *
     * @param user is inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User): Completable
}