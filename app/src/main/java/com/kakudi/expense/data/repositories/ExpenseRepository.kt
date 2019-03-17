package com.kakudi.expense.data.repositories

import com.kakudi.expense.data.model.Expense
import com.kakudi.shared.domain.repositories.Repository
import io.reactivex.Observable

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 17/03/2019
 */
interface ExpenseRepository: Repository<Expense> {

    fun getAllExpenses(userId: String): Observable<List<Expense>>
}