package com.kakudi.shared.domain.repositories

import io.reactivex.Completable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
interface Repository<T> {
    fun insert(data: T): Completable
    fun deleteAll()
    fun delete(data: T)
    fun update(data: T)
}