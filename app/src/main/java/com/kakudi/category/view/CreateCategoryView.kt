package com.kakudi.category.view

import com.kakudi.shared.mvp.BaseView

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 16/03/2019
 */
interface CreateCategoryView : BaseView {

    fun nameError(message: String?)
    fun budgetExpenseError(message: String?)
}