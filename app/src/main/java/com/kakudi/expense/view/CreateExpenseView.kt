package com.kakudi.expense.view

import com.kakudi.shared.mvp.BaseView

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 17/03/2019
 */
interface CreateExpenseView: BaseView {
    fun categoryError(message: String?)
    fun amountError(message: String?)
    fun quantityError(message: String?)
}