package com.kakudi.shared.domain.repositories

import io.reactivex.Observable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
interface Repository<T> {
    fun insert(data: T): Observable<Unit>
    fun deleteAll()
}