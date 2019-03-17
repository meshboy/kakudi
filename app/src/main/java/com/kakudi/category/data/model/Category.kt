package com.kakudi.category.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
@Entity(tableName = "Categories")
data class Category(
    @PrimaryKey val name: String,
    val targetExpense: Double,
    val description: String?,
    val userId: String,
    val date: Long
)