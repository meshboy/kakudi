package com.kakudi.user.data.repository

import com.kakudi.user.data.dao.UserDao
import com.kakudi.user.data.model.User
import io.reactivex.Observable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {

    override fun insert(data: User): Observable<Unit> {
        return Observable.fromCallable{
            userDao.insertUser(data)
        }
    }

    override fun getCurrentUser(): Observable<User> {
        return Observable.just(null)
    }

    override fun delete(data: User) {

    }

    override fun update(data: User) {

    }

    override fun deleteAll() {

    }
}