package com.kakudi.expense.presenter

import com.kakudi.expense.view.CreateExpenseView
import com.kakudi.user.data.repository.UserRepository
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 17/03/2019
 */
class ExpenseCreatePresenter @Inject constructor(
    private val currentUserRepository: UserRepository,
    private val view: CreateExpenseView
) {

    fun create() {

    }
}