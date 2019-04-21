package com.kakudi.user.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val username: String,
    val token: String,
    val email: String
)