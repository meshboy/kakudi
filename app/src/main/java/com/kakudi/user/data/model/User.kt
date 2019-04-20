package com.kakudi.user.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
@Entity
data class User(
    val username: String,
    @PrimaryKey
    val token: String,
    val email: String
)