package com.kakudi.user.data.repository

import com.kakudi.shared.domain.repositories.Repository
import com.kakudi.user.data.model.User
import io.reactivex.Single

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
interface UserRepository : Repository<User> {
    fun getCurrentUser(): Single<User>
}