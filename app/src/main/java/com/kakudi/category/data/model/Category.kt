package com.kakudi.category.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.kakudi.user.data.model.User
import java.util.*

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
@Entity(
    tableName = "Categories",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("userId"),
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("userId")]
)
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String?,
    val userId: Long,
    val synced: Int = 0,
    val date: Long = Date().time
)