package com.kakudi.shared.domain.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kakudi.category.data.dao.CategoryDao
import com.kakudi.category.data.model.Category
import com.kakudi.expense.data.dao.ExpenseDao
import com.kakudi.expense.data.model.Expense
import com.kakudi.user.data.dao.UserDao
import com.kakudi.user.data.model.User

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 15/03/2019
 */
@Database(entities = [User::class, Category::class, Expense::class], version = 1, exportSchema = true)
abstract class KakudiRoomDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun categoryDao(): CategoryDao
    abstract fun expenseDao(): ExpenseDao

    companion object {
        private const val databaseName: String = "kakudi_database"
        private var instance: KakudiRoomDatabase? = null

        fun getInstance(context: Context): KakudiRoomDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context): KakudiRoomDatabase {
            return Room.databaseBuilder(context.applicationContext, KakudiRoomDatabase::class.java, databaseName)
                .build()
        }
    }
}