package com.kakudi.expense.data.repositories

import com.kakudi.expense.data.model.Expense
import com.kakudi.expense.data.sources.db.ExpenseLocalResource
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 17/03/2019
 */
class ExpenseRepositoryImpl @Inject constructor(@Named("localExpenseResource") private val localResource: ExpenseLocalResource) :
    ExpenseRepository {

    override fun getAllExpenses(userId: String): Observable<List<Expense>> {
        return localResource.getAllExpenses(userId)
    }

    override fun insert(data: Expense): Observable<Unit> {
        return localResource.insert(data)
    }

    override fun deleteAll() {

    }

    override fun delete(data: Expense) {

    }

    override fun update(data: Expense) {

    }
}