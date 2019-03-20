package com.kakudi.category.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
@Entity(tableName = "Categories")
data class Category(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val name: String,
        val targetExpense: Double,
        val description: String?,
        val userId: String,
        val date: Long = Date().time
)