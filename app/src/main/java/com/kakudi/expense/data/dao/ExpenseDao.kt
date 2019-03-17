package com.kakudi.expense.data.dao

import androidx.room.*
import com.kakudi.expense.data.model.Expense
import io.reactivex.Observable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 17/03/2019
 */
@Dao
interface ExpenseDao {

    @Query("SELECT * FROM Expenses WHERE userId = :userId")
    fun getExpensesByUserId(userId: String): Observable<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExpense(expense: Expense)

    @Delete
    fun delete(expense: Expense)
}