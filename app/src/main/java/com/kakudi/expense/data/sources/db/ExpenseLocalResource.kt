package com.kakudi.expense.data.sources.db

import com.kakudi.expense.data.dao.ExpenseDao
import com.kakudi.expense.data.model.Expense
import com.kakudi.expense.data.repositories.ExpenseRepository
import io.reactivex.Observable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 17/03/2019
 */
class ExpenseLocalResource(private val expenseDao: ExpenseDao) : ExpenseRepository {
    override fun getAllExpenses(userId: String): Observable<List<Expense>> {
        return expenseDao.getExpensesByUserId(userId)
    }

    override fun insert(data: Expense): Observable<Unit> {
        return Observable.fromCallable {
            expenseDao.insertExpense(data)
        }
    }

    override fun deleteAll() {

    }

    override fun delete(data: Expense) {

    }

    override fun update(data: Expense) {

    }
}