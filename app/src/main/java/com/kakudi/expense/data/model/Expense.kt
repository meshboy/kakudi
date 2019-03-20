package com.kakudi.expense.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.kakudi.category.data.model.Category
import java.util.*

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 17/03/2019
 */
@Entity(
    tableName = "Expenses",
    indices = [Index("categoryId")],
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("categoryId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val categoryId: Long,
    val amount: Double,
    val quantity: Int,
    val description: String?,
    val total: Double,
    val userId: String,
    val date: Long = Date().time,
    val status: Boolean = false
)