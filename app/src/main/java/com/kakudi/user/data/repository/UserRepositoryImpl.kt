package com.kakudi.user.data.repository

import com.kakudi.user.data.dao.UserDao
import com.kakudi.user.data.model.User
import io.reactivex.Completable
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {

    override fun insert(data: User): Completable {
        return userDao.insertUser(data)
    }

    override fun getCurrentUser(): Single<User> {
        return userDao.getCurrentUser()
    }

    override fun delete(data: User) {

    }

    override fun update(data: User) {

    }

    override fun deleteAll() {

    }
}