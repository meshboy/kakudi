package com.kakudi.expense.view

import com.kakudi.expense.data.model.Expense
import com.kakudi.shared.mvp.BaseView

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 17/03/2019
 */
interface ExpenseListView: BaseView {

    fun showExpenseList(list: List<Expense>)
    fun showLoading()
    fun hideLoading()
    fun showNextLoading()
    fun hideNextLoading()
}